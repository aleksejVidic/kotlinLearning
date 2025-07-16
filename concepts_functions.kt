import kotlin.math.pow
fun double(x: Int): Int {
    return x * 2
}

fun powerOf(number: Double, exponent: Double): Double {
   return number.pow(exponent)
}

fun sum(a: Int = 0, b:Int = 0): Int {
    return a + b
}

open class A {
    open fun foo(i: Int = 10) {} 
}

class B: A() {
    override fun foo(i: Int) {}
}

fun foo(bar: Int = 0, baz: Int) {}

fun foo1(bar: Int = 0, baz: Int = 1, qux: () -> Unit) {}

fun reformat(str: String, normalizeCase: Boolean = true, 
            upperCaseFirstLetter: Boolean = true,
            divideByCamelHumps: Boolean = false,
            wordSeperator: Char = ' ') {
    
}

fun foo(vararg strings: String) {
    
}

fun printHello(name: String?): Unit {
    if(name != null) {
        println("Hello $name")
    } else {
        println("Hi there")
    }
}

fun duplo(x: Int): Int = x * 2
fun duplo1(x: Int) = x * 2


fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    
    for(t in ts) {
        result.add(t)
    }
    
    return result
}

class MyStringCollection {
    infix fun add(s: String) { }
    fun build() {
        this add "abc"
        add("abc")
        // add "abc" //Incorrect: the receiver must be specified
        this.add("abc")
    }
}

class Sample {
    fun foo() { println("Foo") }
}

// generic functions

fun <T> singletonList(item: T) {
   
}


// tail recursion functions

val eps = 1E-10
tailrec fun findFixPoint(x: Double = 1.0): Double = 
    if(Math.abs(x - Math.cos(x)) < eps) x else findFixPoint(Math.cos(x))
    
tailrec fun fibonnacci(x: Int): Int = 
    if(x < 0) 1 else x + fibonnacci(x - 1)
    
tailrec fun printNums(x: Int) {
    if(x == 0) return
    println(x)
    printNums(x - 1)
}

tailrec fun factTR(n: Int): Int {
    if(n <= 1) return n
    return n * factTR(n - 1)
}

tailrec fun factTR1(n: Int, acc: Int): Int {
    if(n <= 1) return acc
    return factTR1(n - 1, acc * n)
}

fun <T, R> Collection<T>.fold(
	initial: R,
    combine: (acc: R, nextElement: T) -> R
): R {
    var accumulator: R = initial
    for(element: T in this) {
        accumulator = combine(accumulator, element)
    }
    
    return accumulator
}

// operator overloading

interface IndexedContainer {
    operator fun get(index: Int)
}

class OrdersList: IndexedContainer {
    override fun get(index: Int) { // dont require operator keyword
        
    }
}

data class Point(val x: Int, val y: Int)

operator fun Point.unaryMinus() = Point(-x, -y)

data class Point1(val x: Int, val y: Int) {
    operator fun unaryMinus() = Point(-x, -y)
}

data class Klasa(var x: Int) {
    operator fun not() { x = 0 }
}

data class Num(val vr: Int) {
    operator fun inc(): Num {
        return Num(vr + 1)
    }
} 

data class MyString(val text: String) {
    operator fun unaryMinus(): MyString {
        return MyString(text.reversed())
    }
}

data class CustomString(var value: String) {
    operator fun inc(): CustomString {
        value += "a"
        return this
    }
}

data class CustomData(val name: String, val value: Int) {
    operator fun plus(other: CustomData): CustomData {
        return CustomData("${name} + ${other.name}", value + other.value)
    }
}

data class Score(val value: Int): Comparable<Score> {
    
    // for relatinal operators like <, >, <=,>=, ==, !=
    override fun compareTo(other: Score): Int {
        return this.value - other.value
    }
}

data class Counter(val dayIndex: Int) {
    operator fun plus(increment: Int): Counter {
        return Counter(dayIndex + increment)
    }
}
 

fun main() {
    val kotlin = "🙂"
    println(kotlin)
    val result = double(4)
    println(result)
    println(sum())
    foo(baz = 1)
    foo1 { println("Hello") }
    foo1(qux = { println("Hello") })
    foo1(1){ println("Hello") }
    
    val b: B = B()
    b.foo()
    reformat("String", false, upperCaseFirstLetter = false,
            divideByCamelHumps = true, '_')
   	
    reformat("This is a long String!")
    reformat("This is a long string", upperCaseFirstLetter = false, 
             wordSeperator='-')
	foo(*arrayOf("a", "b", "c"))
    printHello("Aleksej")
    println(duplo(3))
    println(duplo1(4))
    
    val list = asList(1, 2, 3)
    println(list)
    val a = arrayOf(1, 2, 3)
    val lista = asList(-1, 0, *a, 4)
    println(lista)
    
    // primitive type array
    val arr = intArrayOf(1, 2, 3)
    val list1 = asList(-1, 0, *arr.toTypedArray(), 4)
    println(list1)
    // infix notation
    
    // function must be member or extension function
    // must have one parameter
    // cant have default values for parameters
    infix fun Int.shl(x: Int): Int {
        return x
    }
    println(1 shl 2) // infix notation
    println(1.shl(2))
    
    val sample = Sample()
    sample.foo()
    println(fibonnacci(5))
    printNums(6)
    
    println(factTR(4))
    val fact = factTR1(5, 1)
    println(fact)
    
    val funk = fun() {
        println("Hello")
    }
    val items = listOf(1, 2, 3, 4, 5)
    println(items.fold(0, {
        acc: Int, i: Int -> acc + i
    }))
    
    val joinedToString = items.fold("Elements:", { acc, i -> acc + " " + i })
    println(joinedToString)
    val product = items.fold(1, Int::times)
    println(product)
    //val a = {i: Int -> i + 1}
    val sum: (Int, Int) -> Int = {x, y -> x + y}
    println(sum(4, 3))
    val mul: (Int, Int) -> Int = {x: Int, y: Int -> x * y}
    println(mul(4, 3))
    
    val ints:List<Int> = listOf(3, 4, 2, 6)
    println(ints.filter { it % 2 == 0 })
    val map: Map<Int, String> = mapOf(23 to "Aleksej", 45 to "Marko")
    map.forEach { (_, valu) -> println(valu) }
    val point = Point(10, 20)
    println(-point)
    val klasa = Klasa(4)
   	!klasa
    println(klasa)
    var num = Num(4)
    println(num++)
    println(num)
    val myString = MyString("Aleksej")
    println(-myString)
    var str = CustomString("Hello")
    str++
    println(str)
    val c = CustomData("Chair", 3)
    val d = CustomData("Table", 4)
    println(c + d)
    val s1 = Score(10)
    val s2 = Score(15)
    println(s1 == s2)
}