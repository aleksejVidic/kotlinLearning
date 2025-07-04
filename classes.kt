class Person(val name: String, val surname: String, val age: Int = 0, 
             parentName: String) {
    val hobby: String = "crtanje"
    
    fun prikaziHobi() {
        println(hobby)
    }
    
}

class Car(name: String, model: String, godiste: Int) {
    var name: String = name
    val model: String = model
    val godiste: Int = godiste
}

data class User(val name: String, val id: Int)

fun main() {
    val person = Person("Aleskej", "Vidic", 43, "Dragana")
  	println(person.hobby) 
    println(person.name)
    println(person.age)
    
    val tesla3 = Car("Tesla", "3", 2012)
    println(tesla3.name)
    tesla3.name = "Mercedes"
    println(tesla3.name)
    person.prikaziHobi()
    
    val user = User("Alex", 1)
    println(user)
    val secondUser = User("Alex", 1)
    println(user == secondUser)
    val thirdUser = user.copy(name = "Max")
    println(thirdUser)
    val fourthUser = user.copy()
    println(fourthUser)
    
    
}