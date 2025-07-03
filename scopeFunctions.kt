// let scope function - use let scope function when want to check for null value

fun sendNotification(recipientAdress: String): String {
    println("Yo $recipientAdress")
    return "Notification sent"
}

fun getNextAdress(): String {
    return "sebastian@jetbrains.com"
}

// apply function - use apply scope function to initialize objects

class Client {
    var token: String? = null
    fun connect() = println("connected!")
    fun authenticate() = println("authenticated!")
    fun getData(): String = "Mock data"
}

val client = Client()
val client1 = Client().apply {
    token = "dcba"
}

// run function - similar to apply you can use run scope function to initizalize an object, but its beter to use run to initizalize an object at spcific moment in your code and immediately compute a result 

// also function - use also function when you want to complete an additional action with an object and then return the object to continue using it in your code

// with function - use with function when we want to call multiple function on an object

class Canvas {
    fun rect(x: Int, y: Int, w: Int, h: Int): Unit = println("$x, $y, $w, $h")
    fun circ(x: Int, y: Int, rad: Int): Unit = println("$x, $y, $rad")
    fun text(x: Int, y: Int, str: String): Unit = println("$x, $y, $str")
}

fun main() {
    val adress: String? = getNextAdress()
    val confirm = adress?.let {
        sendNotification(it)
    }
    
    client.token = "abcd"
    client.connect()
    client.authenticate()
    client.getData()
    
    //run
    val result: String = client.run {
        connect()
    	authenticate()
        getData()
    }
    
    // apply
    val medals: List<String> = listOf("Gold", "Silver", "Bronze")
    val reversedLongUppercaseMedals: List<String> = 
    	medals
    		.map { it.uppercase() }
            .also { println(it) }
            .filter { it.length > 4 }
            .also { println(it) }
            .reversed()
    println(reversedLongUppercaseMedals)
    
    // with
    val mainMonitorPrimaryBufferBackedCanvas = Canvas()
    mainMonitorPrimaryBufferBackedCanvas.text(10, 10, "Foo")
    mainMonitorPrimaryBufferBackedCanvas.rect(20, 30, 100, 50)
    mainMonitorPrimaryBufferBackedCanvas.circ(40, 60, 25)
    mainMonitorPrimaryBufferBackedCanvas.text(15, 45, "Hello")
    mainMonitorPrimaryBufferBackedCanvas.rect(70, 80, 150, 100)
    mainMonitorPrimaryBufferBackedCanvas.circ(90, 110, 40)
    mainMonitorPrimaryBufferBackedCanvas.text(35, 55, "World")
    mainMonitorPrimaryBufferBackedCanvas.rect(120, 140, 200, 75)
    mainMonitorPrimaryBufferBackedCanvas.circ(160, 180, 55)
    mainMonitorPrimaryBufferBackedCanvas.text(50, 70, "Kotlin")
    
    println("with variant")
    
    with(mainMonitorPrimaryBufferBackedCanvas) {
        text(10, 10, "Foo")
        rect(20, 30, 100, 50)
        circ(40, 60, 25)
        text(15, 45, "Hello")
        rect(70, 80, 150, 100)
        circ(90, 110, 40)
        text(35, 55, "World")
        rect(120, 140, 200, 75)
        circ(160, 180, 55)
        text(50, 70, "Kotlin")
    }
    
}