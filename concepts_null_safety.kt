fun main() {
    val a: String = "abc"
    val l = a.length
    println(l)
    
    var b: String? = "abc"
    b = null
    
    
    // check for null with if condition
    val l1 = if(b is String) b.length else -1
    println(l1)
    
    val c: String? = "Kotlin"
    if(c != null && c.length > 0) {
        println("String of length ${c.length}")
    } else {
        println("Empty string")
    }
    
    // safe call operator
    val d: String? = "Kotlin"
    val e: String? = null
    println(d?.length)
    println(e?.length)
    
    // elvis operator
    val b1: String? = null
    val l2 = b1?.length ?: 0
    println(l2)
    
    
    // not-null assertion operator
    val b3: String? = "kotlin"
    
    val l4 = b3!!.length
    println(l4)
    val b4: String? = null
    //val l5 = b4!!.length
    //println(l5)
    
    // let function
    val listWithNulls: List<String?> = listOf("Kotlin", null)
    
    for(list in listWithNulls) {
        list?.let {
            println(it)
        }
    }
}