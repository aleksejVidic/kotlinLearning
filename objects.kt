// object decalarations declase class with a single instance
// it create class and instance at the same time
// this is useful when you want to create a class to use as a single reference
// for your program or to coordinate behavior across a system

//A class that has only one instance that is easily accessible is called a singleton.

interface Auth {
    fun takeParams(username: String, password: String)
}

object DoAuth: Auth {
    override fun takeParams(username: String, password: String) {
        println("input Auth parameters = $username:$password")
    }
}

// data objects

data object AppConfig {
    var appName: String = "My app"
    var version: String = "1.0.0"
}

// companion objects

class BigBen {
    companion object Bonger {
        fun getBongs(nTimes: Int) {
            repeat(nTimes) { print("BONG ") }
        }
    }
    
}

class Temperature(val celsius: Double) {
    val fahrenheit: Double = celsius * 9 / 5 + 32
    
    companion object {
        fun fromFahrenheit(fahrenheit: Double): Temperature = Temperature((fahrenheit - 32) * 5 / 9)
    }
}

fun main() {
    DoAuth.takeParams("fwewv", "Ewrgew")
    println(AppConfig)
    println(AppConfig.appName)
    BigBen.getBongs(10)
    val fahr: Double = 90.0
    val temp = Temperature.fromFahrenheit(fahr)
    
    println("${temp.celsius} is $fahr")
    
}