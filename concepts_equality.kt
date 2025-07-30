// to provide custom equal function we have to override equal function
// by default non-data classes are compared by reference(referencial equality)
class Point(val x: Int, val y: Int) {
    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if(other !is Point) return false
        
        return this.x == other.x && this.y == other.y
    }
}

// when we override equals() function we should also override hashCode() function
// to keep consistency between equality and hashing and ensure a proper behavior of these fucntion


fun main() {
    // structural equality
    
    // by definition expression like a == b is translated to: a?.equals(b) ?: (b == null)
	var a = "hello"
    var b = "hello"
    var c = null
    var d = null
    var e = d
    println(a == b)
    println(a == c)
    println(c == e)
    
    // referential equality
    var a1 = "Hello"
    var b1 = a1
    var c1 = "world"
    var d1 = "world"
    println(a1 === b1)
    println(a1 === c1)
    println(c1 === d1)
}