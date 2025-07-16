 

fun main() {
    
    // index out of bounds exception
    val myList = mutableListOf(1, 2, 3)
    //myList.removeAt(3)
    val el = myList.getOrNull(3)
    println(el)
    println(myList)
    
    // no such element exception
    
    val emptyList = listOf<Int>()
    //println(emptyList.first())
    val el1 = emptyList.firstOrNull()
    println(el1)
    
    // number format exception
    
    val string = "This is not a number"
    //val num = string.toInt()
    val num = string.toIntOrNull()
    println(num)
    
    // null pointer exception
    val text: String? = null
    println(text?.length)
}