data class Customer(val id: Int, var email: String) {
    fun printId(): Unit {
        println(id)
    }
}

fun printMyName(name: String?): Unit {
    if(name == null) {
        return println("Unesite vase ime")
    }
    
    println("Vase ime je $name")
}

fun lengthOfString(str: String?): Int? = str?.length

fun main() {
   	
    var int: Int? = 3
    println(int)
    int = null
    println(int)
    printMyName(null)
    printMyName("Aleksej")
    println(lengthOfString(null))
    val string: String? = "null"
    println(string?.uppercase())
    
    // elvis operator
    val str: String? = null
    println(str ?: 0)
}