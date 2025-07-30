data class Person(val name: String, val age: Int)

// returning two values from a function
data class Result(val result: Int, val status: Boolean)

fun function(): Result {
    return Result(4, true)
}

data class User(val email: String, val password: String)

// destructuring declarations on maps
// to make destructuring works you should:
// present the map as sequence of values by providing an iterator() function
// present each of the elements as a pair by providing functions component1() and component2()

// kotlin provides these extension function below to enable destructuring maps
// operator fun <K, V> Map<K, V>.iterator(): Iterator<Map.Entry<K, V>> = entrySet()
// operator fun <K, V> Map.Entry<K, V>.component1() = getKey()
// operator fun <K, V> Map.Entry<K, V>.component2() = getValue()
fun main() {
    val person = Person("Aleksej", 20)
    val (name, age) = person
    println(name)
    println(age)
    
    // val (name, age) = person is equivalent to:
    val name1 = person.component1()
    val age1 = person.component2()
    println(name1)
    println(age1)
    val (status, result) = function()
    println(status)
    println(result)
    
    // underscore for unused variables
    
    val map: Map<Int, Char> = mapOf(1 to 'a', 2 to 'b', 3 to 'c')
    for((key, value) in map) {
        println("$key: $value")
    }
    
    //
}