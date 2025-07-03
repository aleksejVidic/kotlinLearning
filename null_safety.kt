// null safety

// is and !is operators
fun printObjectType(obj: Any) {
    when(obj) {
        is Int -> println("Obj is type Int")
        !is Double -> println("Object is not type Double")
        else -> println("Unknown type")
    }
}

// as and as? operators

// fun calculateTotalStringLength(items: List<Any>): Int {
//     var totalLength: Int = 0
//     for (item in items) {
//         totalLength += if(item is String) {
//             item.length
//         } else {
//             0
//         }
//     }
    
//     return totalLength
// }

fun calculateTotalStringLength(items: List<Any>): Int {
    return items.sumOf { (it as? String)?.length ?: 0 }
}

data class User(val name: String?, val age: Int?)

// early returns and Elvis operator

data class User1(val id: Int, val name: String, val friends: List<Int>)

// fun getNumberOfFriends(users: Map<Int, User1>, userId: Int): Int {
//     val user = users[userId] ?: return -1
    
//     return user.friends.size
// }

fun getNumberOfFriends(users: Map<Int, User1>, userId: Int): Int {
    return users[userId]?.friends?.size ?: -1
}

fun main() {
    val myInt = 43
    val myDouble = 3.23
    val myList = listOf(2, 3, 2)
    printObjectType(myInt)
    printObjectType(myList)
    printObjectType(myDouble)
    
    // as and as? operators
    val a: String? = null
    //val b = a as String unsafe cast operator
    val b = a as? String //,as? safe operator
    println(b)
    
    val list: List<Any> = listOf(3, 2, "ewfwg", "efew")
    println(calculateTotalStringLength(list))
    
    // null values and collections
    val emails: List<String?> = listOf("alice@gmail.com", null, "bob@example.com", null, "carol@example.com")
	val validEmails = emails.filterNotNull() 
    
    println(validEmails)
    
    val serverConfig = mapOf(
    	"appConfig.json" to "App Configuration",
    	"dbConfig.json" to "Database Configuration"
    )
    
    val requestedFile = "appConfig.json"
    val configFiles = listOfNotNull(serverConfig[requestedFile])
    println(configFiles)
    
    val temperatures = listOf(13, 34, 31, 56, 24, 27)
    val singleHotDay = temperatures.singleOrNull { it -> (it > 20 && it < 30) }
    println(singleHotDay)
    val maxTemp = temperatures.maxOrNull()
    println(maxTemp)
    val minTemp = temperatures.minOrNull()
    println(minTemp)
    val users = listOf(
        User(null, 25),
        User("Alice", null),
        User("Bob", 30))
    val firstNonNullName = users.firstNotNullOfOrNull { it.name }
    println(firstNonNullName)
    
    val list1: List<Int?> = listOf(23, null, 3)
	println(list1.firstNotNullOfOrNull{ it })
    
    val itemPrices = listOf(20, 35, 15, 40, 10)
    val totalPrice = itemPrices.reduceOrNull { runningTotal, price -> runningTotal + price }
    println(totalPrice)
    
    val emptyCard = listOf<Int>()
    val  emptyTotalPrice = emptyCard.reduceOrNull{ accumulator, card -> accumulator + card}
    println(emptyTotalPrice)
    
    val user1 = User1(1, "Alice", listOf(2, 3))
    val user2 = User1(2, "Bon", listOf(1))
    val user3 = User1(3, "Charlie", listOf(1))
    
    val users1: Map<Int, User1> = mapOf(1 to user1, 2 to user2, 3 to user3)
    println(getNumberOfFriends(users1, 1))
    println(getNumberOfFriends(users1, 4))
}