// abstract classes

// NOTE: Abstract classes are useful only if you need one inhreritance for class, because Kotlin supports single inheritance. For multiple inheritance
// use Interface

// When you define the behavior of an inherited function or property, we call that an implementation.

abstract class Product(val name: String, val price: Double) {
    
    abstract val category: String
    
    fun productInfo(): String {
        return "Name: $name, price: $price, category: $category"
    }
}

class Electronics(name: String, price: Double, val warrantly: Int): Product(name, price) {
    override val category = "Electronics"
}

// interface

interface PaymentMethod {
    
    fun initiatePayment(amount: Double): String
}

interface PaymentType {
    val paymentType: String
}

class CreditCardPayment(val cardNumber: String, val cardHolderName: String,
                       val expiryDate: String): PaymentMethod, PaymentType {
    override fun initiatePayment(amount: Double): String {
        return "Payment of $$amount initiated using Credit Card ending in ${cardNumber.takeLast(4)}."
    }
    
    override val paymentType = "Credit Card"
}

fun main() {
    val kotlin = "🙂"
    val laptop = Electronics("laptop", 1000.0, 2)
    println(laptop.productInfo())
    val paymentMethod = CreditCardPayment("1234", "John Doe", "12/25")
    println(paymentMethod.initiatePayment(100.0))
    println(paymentMethod.paymentType)
}