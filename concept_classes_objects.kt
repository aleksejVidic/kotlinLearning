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

open class Rectangle {
    open fun draw() {}
}

interface Polygon {
    fun draw() {}
}

class Square: Rectangle(), Polygon {
    override fun draw() {
        super<Rectangle>.draw()
        super<Polygon>.draw()
        println("Draw Square")
    }
}

open class Rectangle {
    open fun draw() {}
}

interface Polygon {
    fun draw() {}
}

class Square: Rectangle(), Polygon {
    override fun draw() {
        super<Rectangle>.draw()
        super<Polygon>.draw()
        println("Draw Square")
    }
}


class Adress {
    val name: String = "Aleksej Vidic"
    var street: String = "Programmer"
    var city: String = "Banja Luka"
    var state: String? = null
    var zip: String = "123456"
    
}

class Rectangle1(val width: Int, val height: Int) {
//     val area: Int
//     	get() = width * height
    
    val area get() = width * height
    var counter = 0
    	set(value) {
            if(value >= 0)
            	field = value
        }
} 

// backing property

class Table {
    private var _table: Map<String, Int>? = null
    public val table: Map<String, Int>
    	get() {
            if(_table == null) {
                _table = HashMap()
            }
            
            return _table ?: throw AssertionError("Seto to null by another thread")
        }
}

// compile-time constants
//If the value of a read-only property is known at compile time, mark it as a compile time constant using the const modifier.

const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"

// interface 
interface MyInterface {
   	
    fun bar()
}

class Child: MyInterface {
    override fun bar() {
        
    }
}

interface MyInterface1 {
    val prop: Int
    
    val propertyWithImplementation: String
    	get() = "foo"
   	
    fun foo() {
        println(prop)
    }
}

class Child1: MyInterface1 {
    override val prop: Int = 29
}

interface Named {
    val name: String
}

interface Person: Named {
    val firstName: String
    val lastName: String
    
    override val name: String get() = "$firstName $lastName"
}

data class Employee(
		override val firstName: String,
    	override val lastName: String, 
	): Person

interface A {
    fun foo() { 
    	print("A")
    }
    
    fun bar()
}

interface B {
    fun foo() {
        print("B")
    }
    
    fun bar() {
        print("bar")
    }
}

class C: A {
    override fun bar() { 
    	print("bar")
  	}
}

class D: A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }
    
    override fun bar() {
        super<B>.bar()
    }
}


// function(single abstract method) interface 

fun interface KRunnable {
    fun invoke()
}

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

// without SAM conversion

val isEven = object: IntPredicate {
    
    override fun accept(i: Int): Boolean {
        return i % 2 == 0
    }
}

// using SAM conversion

val isEven1 = IntPredicate { it % 2 == 0}


typealias NumPredicate = (i: Int) -> Boolean

val isEven2: NumPredicate = { it % 2 == 0 }

// visibility modifiers

// PACKAGE
// public - used by default declarations(functions, classes, variables) will e visible everywhere
// private - only visible inside same file that contains declaration
// internal - visible only in same module
// protected - not available for top-level declarations

// CLASSES
// private -  means that the member is visible inside this class only (including all its members)
// protected - memeber has the same visibility as private but it is accessible for subclasses in inheritane chain
// public - means that any client who sees the declaring class sees its public members
// internal - members of class are accessible by clients that are in the same module

open class Outer {
    private val a = 1
    protected open val b = 2
    internal open val c = 3
    val d = 4
    
    protected class Nested {
        public val e: Int = 5
    }
}

class Subclass: Outer() {
 	override val b = 5
    override val c = 7
}

class Unrelated(o: Outer) {
    
}

// extensions

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

fun <T> MutableList<T>.swap1(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

open class Shape2

class Rectangle2: Shape2()
fun Shape2.getName() = "Shape"
fun Rectangle2.getName() = "Rectangle"

fun printClassName(s: Shape2) {
    println(s.getName())
}

class Example {
    fun printFunctionType() {
        println("Class method")
    }
}

fun Example.printFunctionType() { println("Extension function") } 

class Example1 {
    fun printFunctionType() { println("Class method") }
}

fun Example1.printFunctionType(i: Int) {
    println("Extension function #$i")
}

// nullable receiver
fun Any?.toString(): String {
    if(this == null) return "null"
    return toString()
}

// extension properties
val <T> List<T>.lastIndex: Int
	get() = size - 1

// companion object extensions
// we can define extension properties and methods inside companion object
class MyClass {
    companion object {}
}

fun MyClass.Companion.printCompanion() {
    println("companion")
}

// declaring extensions as memebers

class Host(val hostname: String) {
    fun printHostname() {
        print(hostname)
    }
}

class Connection(val host: Host, val port: Int) {
    fun printPort() {
        print(port)
    }
    fun Host.printConnectionString() {
        printHostname()
        print(":")
        printPort()
    }
    fun connect() {
        host.printConnectionString()
    }
}

open class Base

class Derived: Base()

open class BaseCaller() {
    open fun Base.printFunctionInfo() {
        println("Base extension function in BaseCaller")
    }
    
    open fun Derived.printFunctionInfo() {
        println("Derived extension function in BaseCaller")
    }
    
    fun call(b: Base){
        b.printFunctionInfo()
    }
}

class DerivedCaller: BaseCaller() {
    override fun Base.printFunctionInfo() {
        println("Base extension function in BaseCaller")
    }
    
    override fun Derived.printFunctionInfo() {
        println("Base extension functio in DerivedCaller")
    }
}

// data classes

data class User(val name: String = "", val age: Int = 0)

data class Person(val name: String) {
    var age: Int = 0
}

data class Person(val name: String) {
    var age: Int = 0
}

// copying
data class User(val name: String, var age: Int) {
    
}

// sealed classes and interfaces
sealed interface Error
sealed class IOError: Error

class FileReadError(val file: String): IOError()
class DatabaseError(val source: String): IOError()

object RuntimeError: Error

sealed class Result {
    data class Success(val data: String): Result()
    data class Error(val exception: Throwable): Result()
    object Loading: Result()
}

fun handleResult(result: Result) {
    when(result) {
        is Result.Success -> println("Data: ${result.data}")
        is Result.Error -> println("Error: ${result.exception.message}")
        Result.Loading -> println("Loading")
    }
}

// constructors in sealed classes
// sealed class is an abstract class so it cant have instances

sealed class Error1(val message: String) {
    class NetworkError: Error1("Network failure")
    class DatabaseError: Error1("Database cannot be reached")
    class UnknownError: Error1("An unknown error has occured")
    
}

enum class ErrorSeverity {
    MINOR, 
    MAJOR, 
    CRITICAL
}

sealed class Error2(val severity: ErrorSeverity) {
    class FileReadError(val file: String): Error2(ErrorSeverity.MAJOR)
    class DatabaseError(val source: String): Error2(ErrorSeverity.CRITICAL)
    object RuntimeError: Error2(ErrorSeverity.MINOR)
}

// constructors of sealed classes can have two visibility modifiers: protected(by default) and private

sealed class IOError1 {
    
    // protected constructor
    constructor() {
        
    }
    
    private constructor(decs: String): this() {
        
    }
    
    
}

// sealed classes with when expression

fun log(e: Error2) = when(e) {
    is Error2.FileReadError -> println("Error while reading file")
    is Error2.DatabaseError -> println("Error while reading from database")
    Error2.RuntimeError -> println("Runtime error")
}

// use case scenarios for sealed classes

//	1. state managment in UI apps

sealed class UIState {
    data object Loading: UIState()
    data class Success(val data: String): UIState()
    data class Error(val exception: Throwable): UIState()
    
}

fun updateUI(state: UIState) = when(state) {
    is UIState.Success -> println("Success")
    is UIState.Error -> println("Error")
    UIState.Loading -> println("Loading...")
}

//	2. payment method handling

sealed class Payment {
    data class CreditCard(val number: String, val expiryDate: String): Payment()
    data class PayPal(val email: String): Payment()
    data object Cash: Payment()
}

fun processPayment(payment: Payment) = when(payment) {
    is Payment.CreditCard -> println("Payment using credit")
    is Payment.PayPal -> println("Payment using paypal")
    Payment.Cash -> println("Payment using cash")
}

//	3. API request-response handling

// nested and inner class

// nested class

class Outer {
    private val bar: Int = 1
    class Nested {
        fun foo() = 2
    }
}

interface OuterInterface {
    class InnerClass
    interface InnerInterface
}

class OuterClass {
    class InnerClass
    interface InnerInterface
}

// inner class
class Outer1 {
    private val bar: Int = 1
    inner class Inner {
        fun foo() = bar
    }
}

// enum classes
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
}

// anonymous class
//Enum constants can declare their own anonymous classes with their corresponding methods, as well as with overriding base methods.

enum class ProtocolState {
    WAITING  {
        override fun signal() = TALKING
    },
    
    TALKING {
        override fun signal() = WAITING
    };
    
    abstract fun signal(): ProtocolState
}

// implementing interface in enum classes
// an enum class can implement an interface but it cannot derive from a class

// working with enum constants

enum class RGB1 {
    RED, 
    GREEN,
    BLUE
}

// object declaration and expression

// object declarations
object DataProviderManager {
    private val providers = mutableListOf<String>()
    fun registerDataProvider(provider: String) {
        providers.add(provider)
    }
    
    val allDataProviders: Collection<String>
    	get() = providers
}

// object declarations cannot be local which means they cannot be nested
// inside a function, they can be nested inside other objects or non-inner classes

// data object

object MyObject {
    val num: Int = 3
}

data object MyDataObject {
    val num: Int = 3
}

// use data object with sealed hierarchies
sealed interface ReadResult

data class Number(val num: Int): ReadResult
data class Text(val text: String): ReadResult
data object EndOfFile: ReadResult
// companion object
class MyClass {
    companion object Factory {
        fun create(): MyClass = MyClass()
    }
}

class User1(val name: String) {
    companion object {
        fun create(name: String): User1 = User1(name)
    }
}


class User2(val name: String) {
    companion object {
        private val defaultGreeting = "Hello"
    }
    
    fun sayHi() {
        println(defaultGreeting)
    }
}

class User3 {
    companion object Named {
        fun show(): String = "User named companion object"
    }
}

class User4 {
    companion object {
        fun show(): String = "User named comapnion object"
    }
}

// members of companion objects are not static members but instance members of comapnion object
// because of that we can have interfaces to  implement them on the companion object

interface Factory<T> {
    fun create(name: String): T
}

class User5(val name: String) {
    companion object: Factory<User5> {
        override fun create(name: String): User5 = User5(name)
    }
}

// object expression
val helloWorld = object {
    val hello = "Hello"
    val world = "World"
    
    override fun toString() = "$hello $world"
}

// inherit anonymous objects from supertypes

open class BankAccount(initialBalance: Int) {
    open val balance: Int = initialBalance
}

interface Transaction {
    fun execute()
}

fun specialTranasaction(account: BankAccount) {
    val temporaryAccount = object: BankAccount(account.balance), Transaction {
        override val balance = account.balance + 500
        
        override fun execute() {
            println("Executing special transaction. New balance is $balance.")
        }
    }
    temporaryAccount.execute()
}

// use anonoymous objects as return and value types
class UserPreferences {
    private fun getPreferences() = object {
        val theme: String = "Dark"
        val fontSize: Int = 14
    }
    
    fun printPreferences() {
        val preferences = getPreferences()
        println("Theme: ${preferences.theme}, Font Size: ${preferences.fontSize}")
    }
}

// if a function or property that returns an anonymous object has public, protected
// or internal visibility its actual type is:
// Any if the object doesnt have a declared supertype
// the declared supertype if object inherits class
// the explicityly declared type if there is more than one declared supertype of an object
// in all these cases members added in the anonymous object are not accessible
// overriden memebrs are accessible if the they are declared in the actual type of the function or property
interface Notification {
    fun notifyUser()
}

interface DetailedNotification

class NotificationManager {
    fun getNotification() = object {
        val message: String = "General notification"
    }
    
    fun getEmailNotification() = object: Notification {
        override fun notifyUser() { // ACCESSIBLE
            println("Sending email notification")
        }
        
        val message: String = "You've got mail!" //NOT ACCESSIBLE
    }
    
    fun getDetailedNotification(): DetailedNotification = object: Notification, DetailedNotification {
        override fun notifyUser() {
            println("Sending detailed notification")
        }
        val message: String = "Detailed message content"
    }
    
}


// type aliases

typealias NodeSet = Set<String>

typealias FileTable<K> = Map<K, MutableList<String>>

typealias MyHandler = (Int, String, Any) -> Unit
//typealias Predicate<T> = (T) -> Boolean

class A {
    inner class Inner
}

class B {
    inner class Inner
}

typealias AInner = A.Inner
typealias BInner = B.Inner

typealias Predicate<T> = (T) -> Boolean

fun foo(p: Predicate<Int>) = p(42)



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
    val square = Square()
    square.draw()
    
    val result = Adress()
    println(result.name)
    println(result.javaClass)
    
    val num: Int = 7
    println("${isEven1.accept(num)}")
    println(isEven2(6))
    val list = mutableListOf(1, 2, 3)
    list.swap(0, 2)
    println(list)
    val strings: MutableList<String> = mutableListOf("jabuka", "limun", "naranda")
    strings.swap1(1, 2)
    println(strings)
    printClassName(Rectangle2())
    Example().printFunctionType()
    Example1().printFunctionType(5)
    MyClass.printCompanion()
    Connection(Host("kotl.in"), 443).connect()
    BaseCaller().call(Base())
    DerivedCaller().call(Base())
    DerivedCaller().call(Derived())

    val person1 = Person("John")
    val person2 = Person("John")
    person1.age = 10
    person2.age = 20
    
    println("${person1 == person2}")
    println("${person1 === person2}")
    
    println("${person1}")
    val jack = User(name = "Jack", age = 1)
    val olderJack = jack.copy(age = 2)
    println(jack)
    println(olderJack)
    
    // data classes and destructuring declaration
    val jane = User("Jane", 35)
    val (name, age) = jane // destructuring
    println("$name, $age")
    val errors = listOf(Error1.NetworkError(), Error1.DatabaseError(), Error1.UnknownError())
    errors.forEach {
        println(it.message)
    }
    
    val DBError = Error2.DatabaseError("db.sql")
    println(DBError.severity)
    val success = UIState.Success("Successful created navbar")
    updateUI(success)
    val person1 = Person("John")
    val person2 = Person("John")
    person1.age = 10
    person2.age = 20
    
    println("${person1 == person2}")
    println("${person1 === person2}")
    
    println("${person1}")
    val jack = User(name = "Jack", age = 1)
    val olderJack = jack.copy(age = 2)
    println(jack)
    println(olderJack)
    
    // data classes and destructuring declaration
    val jane = User("Jane", 35)
    val (name, age) = jane // destructuring
    println("$name, $age")
    val errors = listOf(Error1.NetworkError(), Error1.DatabaseError(), Error1.UnknownError())
    errors.forEach {
        println(it.message)
    }
    
    val DBError = Error2.DatabaseError("db.sql")
    println(DBError.severity)
    val success = UIState.Success("Successful created navbar")
    updateUI(success)
    val demo = Outer.Nested().foo()
    println(demo)
    val demo1 = Outer1().Inner().foo()
    println(demo1)
    for(color in RGB1.entries) println(color.toString())
    println("${RGB1.valueOf("RED")}")
    println(RGB1.RED.name)
    println(RGB1.BLUE.ordinal)
    
    DataProviderManager.registerDataProvider("M:tel")
    println(DataProviderManager.allDataProviders)
    val myObject = object {
        val name = "Singleton"
    }
    println(MyObject)
    println(MyDataObject)
    println(Number(8))
    println(EndOfFile)
    val userInstance = User1.create("John Doe")
    println(userInstance.name)
    User2("Nick").sayHi()
    val reference1 = User3
    println(reference1)
    val reference2 = User4
    println(reference2)
    val userFactory: Factory<User5> = User5
    val newUser = userFactory.create("Example User")
    println(newUser.name)
    println(helloWorld)
    val f: (Int) -> Boolean = { it > 0 }
    println(foo(f))
    val p: Predicate<Int> = { it > 0 }
    println(listOf(1, -2).filter(p))
}
