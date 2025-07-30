class Box<T>(private var item: T) {
    fun getItem(): T = item
    fun setItem(newItem: T) {
        item = newItem
    }
} // this is class with invariant generic


// out - covariance
class ReadOnlyBox<out T>(private var item: T) {
    fun getItem(): T = item
    private fun setItem(newItem: T) {
        item = newItem 
    }
    
}

// in - contravariance
class WriteOnlyBox<in T>(private var item: T) {
    fun setItem(newItem: T) {
        item = newItem
    }
    
    private fun getItem(): T = item
}

// declaration-site variance and properties
class Box1<out T>(val item: T)

class Box2<in T>(private var item: T)

// declaration site-variance and inheritance
// type parameters in inheritance are not inherited they are redefined in the subclass
interface Box3<out T> {
    fun get(): T
}

interface MutableBox<X>: Box3<X> {
    fun set(item: X)
}

// rule for variance in inheritance
// for each type parameter, a subtype can declare the same variance as its supertype
// or it can effetively remove the variance declared on its supertype

// breaking vows
class UnsafeBox<out T>(private var item: T) {
    fun get(): T = item
    fun set(newItem: @UnsafeVariance T) {
        item = newItem
    }
}


open class Animal
open class Dog: Animal()
open class Schnauzer: Dog()

fun setIt(box: UnsafeBox<Dog>, dog: Dog) = box.set(dog)

// alternatives and trade-offs

// primary alternative of declaration-site variance is use-site variance
// in use-site variance code uses generic agrees to treat it as if it had taken one of these vows
// declaration-site variance is prefferable if you have code thats under your control
// where variance is specified only once
// but if you have class, interface where you will have different ways of using it then use use-site variation
// it is recommended to use use-site in classes that you dont control i.e. classes from libraries

interface Box4<out T> {
    fun get(): T
}
interface MutableBox2<T>: Box4<T> {
    fun set(item: T)
}
fun main() {
    val box: UnsafeBox<Schnauzer> = UnsafeBox(Schnauzer())
	//setIt(box, Dog())
	//val schnauzer: Schnauzer = box.get() // ClassCaseException
}