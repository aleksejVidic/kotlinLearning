open class Person(val name: String, val surname: String) {}

class Programmer(name: String, surname: String, val laptop: String, val company: String): Person(name, surname) {
    fun printDetails() {
        println("$name, $surname, $laptop, $company")
    }
}

// abstract classes

// When you define the behavior of an inherited function or property, we call that an implementation.

abstract class Animal {
    abstract fun makeSound()
    abstract val sound: String
}

class Lion(val size: Int): Animal() {
    override val sound: String = "rawwr"
    override fun makeSound() {
        println(sound)
    }
}

abstract class Product(val name: String, val price: Double) {
    abstract val category: String
    
    fun printInfo(): String {
        return "Product: $name, Category: $category, Price: $price"
    }
}

class Electronics(name: String, price: Double, val warranty: Int): Product(name, price) {
    override val category: String = "Electronics"
}

// interfaces

interface PaymentMethod {
    fun initiatePayment(amount: Double): String
}

class CreditCardPayment(val cardNumber: String, val cardHolder: String
                        , val expiryDate: String): PaymentMethod {
    override fun initiatePayment(amount: Double): String {
        return "Payment of $$amount initiated using Credit Card ending in ${cardNumber.takeLast(4)}."
    }
}

interface Human {
    val name: String
    val surname: String
    
    fun greeting(): String
}

class Programmer1(name: String, surname: String, val company: String): Human {
    override val name: String = name
    override val surname: String = surname
    override fun greeting(): String {
        return "Hi! My name is $name $surname and i am working in $company"
    }
}

interface FlyingAnimal {
    fun flying(): String
}

interface SwimmingAnimal {
    fun swimming(): String
}

class FlyingSwimmingAnimal(val name: String): FlyingAnimal, SwimmingAnimal {
    override fun flying(): String {
        return "I am flying"
    }
    
    override fun swimming(): String {
        return "I am swimming"
    }
}

// delegation

interface Drawable {
    fun draw()
    fun resize()
    val color: String?
}

open class Circle: Drawable {
    override fun draw() {
        println("Draw")
    }
    
    override fun resize() {
        println("resize")
    }
    
    override val color: String? = null
}

class RedCirlce(val circle: Circle): Circle() {
    override val color: String? = "red"
}

fun main() {
    val kotlin = "🙂"
    println(kotlin)
    val progra = Programmer("Aleksej", "Vidic", "lenovo", "none")
    progra.printDetails()
    
    val lion = Lion(5)
    lion.makeSound()
    println(lion.size)
    val animal: Animal = Lion(5)
    animal.makeSound()
    val lion2 = animal as Lion
    println(lion2.size)
    val int: Int = 34
    val string: String? = int as? String
    println(string)
    
    
    val laptop = Electronics("laptop", 1000.0, 2)
    println(laptop.printInfo())
    
    val paymentMethod = CreditCardPayment("1234 5678 9012 3456", "John Doe", "12/25")
    println(paymentMethod.initiatePayment(100.0))
    
    val programmer = Programmer1("Aleksej", "Vidic", "JetBrains")
    println(programmer.greeting())
    
    val human = FlyingSwimmingAnimal("Human")
    println(human.flying())
    val circle = Circle()
    val red = RedCirlce(circle)
    red.resize()
}