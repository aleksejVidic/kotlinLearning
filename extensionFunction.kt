
// create extension function

fun String.bold(): String = "<b>$this</b>"

fun String.firstUpper(): String {
    val first: String = this[0].uppercase()
    val rest: String = this.substring(1, this.length)
    return "$first$rest"
}

fun main() {
   	// extension function
    
    // receiver object and receiver type
    val str: String = "wefgrw"
    println(str.uppercase())
    val list: List<String> = listOf("fwre", "erger", "Ergr")
    println(list.first())
    
    
    println("hello".bold())
    println("hello".firstUpper())
}