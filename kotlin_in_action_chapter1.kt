enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    BLUE(0, 0, 255),
    GREEN(0, 255, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238),
    WHITE(255, 255, 255);
    
    fun rgb() = (r * 256 + g) * 256 + b
    
}

class Person(val name: String, val surname: String)

fun printName(person: Person): Unit = println("${person.name} ${person.surname}")

fun getMnemonic(color: Color) = when(color) {
    Color.RED -> "Richard"
    Color.BLUE -> "Of"
    Color.GREEN -> "York"
    Color.ORANGE -> "Gave"
    Color.YELLOW -> "Battle"
    Color.INDIGO -> "In"
    Color.VIOLET -> "Vains"
    else -> "Nothing"
}

fun mix(c1: Color, c2: Color) = when(setOf(c1, c2)) {
    setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
    setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
    setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
    else -> "Nothin"
}

interface Expr

class Num(val number: Int): Expr
class Sum(val left: Expr, val right: Expr): Expr

fun eval(e: Expr): Int = when(e) {
    is Num -> e.number
    is Sum -> eval(e.left) + eval(e.right)
    
    else -> 0
}

abstract class Human() {
    abstract val name: String
    abstract val surname: String
}

class Programmer(override val name: String, override val surname: String, val laptop: String): Human()

class Butcher(override val name: String, override val surname: String, val axe: Int): Human()

fun printInfo(human: Human): Unit = when(human) {
    is Programmer -> println("${human.name} ${human.surname} ${human.laptop}")
    
    is Butcher -> println("${human.name} ${human.surname} ${human.axe}")
    else -> println("None")
}

open class Motor(val name: String)

class Car(name: String, val brand: String): Motor(name)
class Plane(name: String, val size: Int): Motor(name)

fun printInf(motor: Motor): Unit = when(motor) {
    is Car -> println("${motor.brand}")
    is Plane -> println("${motor.size}")
    else -> println("fwe")
}

fun fizzBuzz(i: Int): String = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
    
}

fun isLetter(c: Char): Boolean = c in "a..z" || c in "A..Z"

fun recognize(c: Char) = when(c) {
    in '0'..'9' -> "Its digit"
    in 'a'..'z', in 'A'..'Z' -> "Its letter"
    else -> "I dont know"
}
fun main() {
    val long = 1L
    println(long)
    val e = 2.7182818284f
    println(e)
    val hexadecimal = 0x1e
    println(hexadecimal)
    val binary = 0b0001
    println(binary)
    
    val a: Int = 100000
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    println(boxedA == anotherBoxedA)
    println(boxedA === anotherBoxedA)
    println(Color.BLUE.rgb())
    println(getMnemonic(Color.BLUE))
    println(mix(Color.RED, Color.YELLOW))
    println(eval(Sum(Sum(Num(2), Num(3)), Num(1))))
    printInfo(Programmer("Aleksej", "Vidic", "lenovo"))
    val car = Car("VW", "Audi")
    printInf(car)
    
    val oneToTen = 1..10
    println(oneToTen)
    
    for (i in 100 downTo 1 step 2) {
        println(fizzBuzz(i))
    }
    for (i in 1 until 10) {
        println(i)
    }
    
    val binaryReps = mutableMapOf<Char, String>()
    
    for(c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }
    
    for ((key, values) in binaryReps) {
        println("$key: $values")
    }
    
    val list: List<Int> = listOf(2, 4, 3, 1, 7)
    for(i in list) {
        if(i % 2 == 0) println(i)
    }
    println(isLetter('q'))
    println(recognize('e'))
    println(3 in 0..9)
    println("Kotlin" in "Java".."Scala")
    
    val number: Int = 110
    val percentage = if(number in 0..100) {
        number
    } else {
        throw IllegalArgumentException("Percantage value must be between 0 and 100")
    }
}