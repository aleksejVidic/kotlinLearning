import java.util.Calendar
data class User(val name: String, val email: String, val age: Int) {
    fun isValid() = true
    fun saveToDB() = true
    fun sendWelcomeEmail() = true
}

class DatabaseConnection {
    var host: String = ""
    var port: Int = 0
    var dbName: String = ""
    var username: String = ""
    var password: String = ""
    
    fun connect() {
        println("Connecting to database $dbName at $host:$port with username $username")
    }
    
    fun executeQuery(query: String) {
        println("Executing query: $query")
    }
}

class File {
    var name: String = ""
    var extension: String = ""
    var context: String = ""
    
    fun save() {
        println("Saving file $name.$extension with content: $context")
    }
}


fun main() {
    
    // let - use when you want to perfrom some operations on an object and then return a result
    val name = "   Kotlin  "
    val clearName = name.let {
        val trimmed = name.trim()
        val reversed = trimmed.reversed()
        reversed
    }
    println(clearName)
    println(name)
    // run - use when you want to execute a block of code on an object and return a result
    // but unlike in let you dont have to access object with name of reference
    // this is useful if you want to call many functions and properties from that object
	val user = User("John Doe", "johndoe@gmail.com", 30)
    val result = user.run {
        if(!isValid()) {
            return@run "User validation failed"
        }
        if(!saveToDB()) {
            return@run "Failed to save to DB"
        }
        
        if(!sendWelcomeEmail()) {
            return@run "Faild to send welcome email"
        }
        
        "User registration successful"
    }
    
    println(result)
    
    // with function - use when you want to perform a multiple operations on a non-null object
    // it is useful when you are working on an object that has several properties or methods that you need to access in sequence
    
    // apply function - useful when we are setting up an object with multiple properties or configurations
    val dbConnection = DatabaseConnection().apply {
        host = "localhost"
        port = 5432
        dbName = "myDB"
        username = "admin"
        password = "password"
    }
    dbConnection.connect()
    
    // also - useful when we want something to do with object right after initializing or transforming it
    val report = File().apply {
       	this.name = "Report"
        extension = "txt"
        context = "This is the content of report"
    }.also {
        it.save()
    }
    
    //chaining scope functions
    
    // chaining let and also
    val text: String = "Hello, Kotlin"
   	val newText = text.let {
        val trimmed = it.trim()
        trimmed.replace(",", "")
    }.also {
        println(it)
    }
    
    // chaining apply and run
    val connection = DatabaseConnection().apply {
        host = "localhost"
        port = 5000
        dbName = "extension"
        username = "admin"
        password = "password"
    }.run {
        connect()
        executeQuery("SELECT * FROM User")
    }
    
    // chaining with and also
    val dayOfWeek = with(Calendar.getInstance()) {
        val year = get(Calendar.YEAR)
        val month = get(Calendar.MONTH) + 1
        val day = get(Calendar.DAY_OF_MONTH)
        println("Today's date: $day/$month/$year")
        get(Calendar.DAY_OF_WEEK)
    }.also {
        val daysOfWeek = arrayOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    	println(daysOfWeek[it - 1])
    }
}