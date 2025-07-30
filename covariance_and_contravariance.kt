// covariance
open class A
open class B: A()

fun read(list: List<A>) {
    
}

// creating covariance
class Box<out T>(val item: T)

// covariance and inheritance
// Covariance doesn’t just apply to generics. When you override a function in a subclass, you can declare a return type that’s more specific than the superclass declares.
// for example if you have superclass with a function that return  an A its legal for subclass to declare that it return a B instead

open class SuperCLass {
    open fun getValue(): A {
        return A()
    }
}

class SubClass: SuperCLass() {
    override fun getValue(): B {
        return B()
    }
}

// return types in Kotlin(and Java) are covariant


fun main() {
    val listOfB: List<B> = listOf(B())
    val listOfA: List<A> = listOfB
    read(listOfB)
    val boxB: Box<B> = Box(B())
    val boxA: Box<A> = boxB
}

// contravariance
open class A
open class B: A()

class Box<in T> {
    private val items = mutableListOf<T>()
    fun deposit(item: T) = items.add(item)
}

fun update(box: Box<B>) {
    
}

// contravariance and inheritance
// variance is a concept that also applies to inheritance not just generics
// in many languages including Java and Kotlin covariant return types allow methods
// on a subclass to return a more specific type than their superclass
// on the other hand most languages do not allow for contravariant argument types
//So, even though it would be safe for a subclass to expect a more general argument type than its superclass, it’s not actually allowed.

open class Super {
    open fun execute(arg: B) {}
}

class Sub: Super() {
    override fun execute(arg: A) {}
}
fun main() {
    val boxOfA: Box<A> = Box<A>()
    val boxOfB: Box<B> = boxOfA
    update(boxOfA)
}