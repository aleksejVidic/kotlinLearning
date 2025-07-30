data class Student(val name: String, val age: Int)


// using destructuring with data classes

data class LatLng(val lat: Double, val lng: Double)

// custom destructuring declarations
class StudentData(val name1: String, val age1: Int) {
    operator fun component1() = name1
    operator fun component2() = age1
}

fun main() {
    val student = Student("Aleskej", 12)
    val (name, age) = student
    println(name)
    println(age)
    val latLng = LatLng(10.0, 20.0)
    val (lat, lng) = latLng
    println(lat)
    println(lng)
    
    // destructuring in collections
    val coordinates = listOf(Pair(1, 2), Pair(3, 4), Pair(5, 6))
    for((x, y) in coordinates) {
        println("x: $x, y: $y")
    }
    
    // destructuring in maps
    val map = mapOf("Mukesh" to 100, "Manish" to 200, "Amar" to 300)
    for((key, value) in map) {
        println("key: $key, value: $value")
    }
    
    val studentData = StudentData("Mukesh", 10)
    val (name1, age1) = studentData
    println("$name1 $age1")
}