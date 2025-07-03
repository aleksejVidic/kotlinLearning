// open class Vehicle(val make: String, val model: String, val transimissioType: String = "Manual") {
//     open fun displayInfo() {
//         println("Vehicle Info: Make - $make, Model - $model")
//     }
// }

// class Car(make: String, model: String, val numberOfDoors: Int): Vehicle(make, model, "Automatic") {
//     override fun displayInfo() {
//         println("Car Info: Make - $make, Model - $model, Number of Doors - $numberOfDoors")
//     }
// }

interface EcoFriendly {
    val emissionLevel: String
}

interface ElectricVehicle {
    val batteryCapacity: Double
}

open class Vehicle(val make: String, val model: String)

open class Car(make: String, model: String, val numOfDoors: Int): Vehicle(make, model)

class ElectricCar(make: String, model: String, numOfDoors: Int, val capacity: Double, val emission: String):
Car(make, model, numOfDoors), EcoFriendly, ElectricVehicle {
    override val emissionLevel: String = emission
    override val batteryCapacity: Double = capacity
}

// special classes

// sealed classes

sealed class Mammal(val name: String)

class Cat(val catName: String): Mammal(catName)
class Human(val humanName: String, val job: String): Mammal(humanName)

fun greetMammal(mammal: Mammal): String {
    when(mammal) {
        is Human -> return "Hello ${mammal.name}; You're working as a ${mammal.job}"
        is Cat -> return "Hello ${mammal.name}"  
    }
}

// enum classes

enum class State {
    IDLE, RUNNING, FINISHED
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00); // kotlin stores hexadecimals as integers
    
    fun containsRed() = (this.rgb and 0xFF0000 != 0)
}

// inline value classes

@JvmInline
value class Email(val adress: String)

fun sendEmail(email: Email) {
    println("Sending email to ${email.adress}")
}


fun main() {
    val car1 = Car("Toyota", "Corolla", 4)
    val car2 = Car("Honda", "Civic", 2)
    
//     car1.displayInfo()
//     car2.displayInfo()
    
//     println(car1.transimissioType)
    println(greetMammal(Cat("Snowy")))
    val state = State.RUNNING
    val message = when(state) {
        State.IDLE -> "Idle" 
        State.RUNNING -> "Running"
        State.FINISHED -> "Finished"
    }
    println(message)
    
    val red = Color.RED
    
    println(red.containsRed())
    println(Color.BLUE.containsRed())
    
    val myEmail = Email("example@example.com")
    sendEmail(myEmail)
}