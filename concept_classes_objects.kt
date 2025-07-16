class Person constructor(firstName: String)
class Empty

class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)
    
    init {
        println("First initializcer block that prints $name")
    }
    
    val secondProperty = "Second property ${name.length}".also(::println)
    
    init {
        println("Second initializer block that prints ${name.length}")
    }
}



//Primary constructor parameters can be used in the initializer blocks. They can also be used in property initializers declared in the class body:

class Customer(name: String) {
    val customKey = name.uppercase()
}

// Kotlin has a concise syntax for declaring properties and initializing them from the primary constructor:
class Person1(val firstName: String, val lastName: String, var age: Int, var isEmployed: Boolean = true)

class RectangleWithParameters(width: Int, height: Int) {
    val perimeter = 2 * width + 2 * height
    
    init {
        println("Rectangle created with width = $width and height = $height")
    }
}

//class Customer1 public @Inject constructor(name: String) {}

// secondary constructors 

class Human(val pets: MutableList<Pet> = mutableListOf())

class Pet {
    constructor(owner: Human) {
        owner.pets.add(this)
    }
}

class Person2(val name: String) {
    val children: MutableList<Person2> = mutableListOf()
    constructor(name: String, parent: Person2): this(name) {
        parent.children.add(this)
    }
}

class Add(val a: Int, val b: Int) {
    val c = a + b
}

open class Employee {
    constructor(empId: Int, empName: String) {
        println("$empId")
        println("$empName")
    }
}

class Manager: Employee {
    constructor(empId: Int, empName: String, salary: Double): super(empId, empName) {
        println("$salary")
    }
}

class Constructors {
    init {
        println("Init block")
    }
    
    constructor(i: Int) {
        println("Constructor $i")
    }
}

open class Base(p: Int)

class Derived(p: Int): Base(p)

open class Shape {
    open fun draw() {}
    fun fill() {}
}

class Circle: Shape() {
    override fun draw() {}
}

open class Rectangle(): Shape() {
    final override fun draw() {}
}

open class Shape1() {
    open val vertexCount: Int = 0
}

class Rectangle1: Shape1() {
    override val vertexCount = 4
}

open class ValClass {
    open val str: String = "ffre"
}
class VarClass: ValClass() {
    override var str: String = "wfr"
}

interface Shape2 {
    val vertexCount: Int
}

class Rectangle2(override val vertexCount: Int = 4): Shape2

open class Base1(val name: String) {
    init {
        println("Initializing base class")

    }
    open val size: Int = name.length.also {
        println("Initializing size in the base class: $it")
    }
}

class Derived1(name: String, val lastName: String): Base1(name.replaceFirstChar { it.uppercase() }.also { println("Argument for the base class: $it") }) {
    init {
        println("Initializing derved class")
    }
    
    override val size: Int = (super.size + lastName.length).also { println("Initializing size in the base class: $it") }
}

open class Rectangle3 {
    open fun draw() {
        println("Drawing a rectangle")
    }
    val boardColor: String
    	get() = "black"
    	
}

class FilledRectangle: Rectangle3() {
    override fun draw() {
        super.draw()
        println("Filing the rectangle")
    }
    
    val fillColor: String
    	get() = super.boardColor
   	
    inner class Filler {
        fun fill() = println("Filling")
        fun drawAndFill() {
            super@FilledRectangle.draw()
        }
    }
}

fun main() {
    val initOrder = InitOrderDemo("Aleksej")
    val customer = Customer("Aleksej")
    println(customer.customKey)
    val person = Person2("Aleksej", Person2("Stefan"))
    val add = Add(5, 3)
    println(add.c)
    val manager = Manager(18018, "Sagnik", 50000.55)
    val constu = Constructors(8)
    val derived = Derived1("aleksej", "Vidic")
}
