//scope functions

class Person {
    var name: String = ""
    var age: Int = 0
}

fun main() {
    
    // with function
    val person = Person()
    
    val res: Int = with(person) { 
    	println(name)
        println(age)
        age + 5 // with returns a last statment from lambda function
    }
    println(res)
    
    // apply function
    val person2 = Person().apply { 
    	name = "Alesej"
        age = 34
    }.also {
        println(it.name)
        println(it.age)
    }
    
    // apply function - we use this function when we want to apply additional opoperations 
    // on object after initializing it
    val numbersList: MutableList<Int> = mutableListOf(1, 2, 3).also {
        it.add(4)
        println("Print the numbers list $it")
        it.remove(2)
        println("Print the numbers list $it")
    }
    
    println(numbersList)

    // let function - main usage of let function is to avoid NullPointerException
    val name: String? = "null"
    val result = name?.let {
       	println(it.reversed())
        println(it.capitalize())
        println(it.length)
    }
    println(result)
    
    // run function - combination of let and with functions
    
    val person3: Person? = null
    person3?.run {
        println(name)
        println(age)
        age + 5 
    }
    
    // usages of scope functions:
    // with - if you want to operate on a non-null object
    // let - if you want to execute lambda function and avoid NullPointerExeption
    // run - combination of with and let functions
    // apply - for initialising and configuring an object
    // also - for adding additional object configuration or operations
    
//     let: Used to check nulls, also better than simple null check in multi-threading case
//     also: same as 'let'  but it doesn't return the last line as 'let', instead 'also'  will return the object it was called on and 'not the last line!'
//     apply: helpful function to modify objects, if you want to change in properties of the objects, and it uses 'this' instead of 'it' as we work inside the class of the object
//     run: equivalent to 'apply', but it won't return the object it was called, instead it will return the last line 
//     with: same as 'run' but a different signature.
    
}