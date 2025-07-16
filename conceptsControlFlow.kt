enum class Bit {
    ZERO, ONE
}

// fun foo() {
//     listOf(1, 2, 3, 4, 5).forEach lit@{
//         if(it == 3) return@lit
//         println(it)
//     }
//     print("Done")
// }

fun foo() {
    listOf(1, 2, 3, 4, 5).forEach {
        if(it == 3) return@forEach
        println(it)
    }
    print("Done")
}


fun getIndicies(count: Int): List<Int> {
    require(count >= 0) { "Count must be non-negative. You set count to $count." }
    return List(count) { it + 1 }
}

fun printNonNullString(str: String?) {
    require(str != null)
    println(str.length)
}

fun printNonNullStringWithCheck(str: String?) {
    check(str != null) { "String ne smije da bude null" }
    println(str.length)
}

class User(val name: String, val role: String)

fun processUserRole(user: User) {
    when(user.role) {
        "admin" -> println("${user.name} is admin")
        "editor" -> println("${user.name} is editor")
        "viewer" -> println("${user.name} is viewer")
        else -> error("Undefined role: ${user.role}")
    }
}

fun count(): Int {
    val a = 0
    return 10 / a
}

open class WithdrawalException(message: String): Exception(message)

class InsufficientFundsException(message: String): WithdrawalException(message)

fun processWithdrawal(amount: Double, availableFunds: Double) {
    if (amount > availableFunds) {
        throw InsufficientFundsException("Insufficient funds for the withdrawal.")
    }
    if (amount < 1 || amount % 1 != 0.0) {
        throw WithdrawalException("Invalid withdrawal amount.")
    }
    println("Withdrawal processed")
}

fun divideOrNull(a: Int): Int {
    try {
        val b = 44 / a
        println(b)
        return b
    } catch(e: ArithmeticException) {
        println("catch block: Encountered ArithmeticException $e")
        return -1
    } finally {
        println("finally block: The finally block is always executed")
    }
}

open class MyException: Exception("My message")
class SubException: MyException()
//Exceptions in Kotlin are stateful objects, carrying information specific to the context of their creation, referred to as the stack trace. Avoid creating exceptions using object declarations. Instead, create a new instance of the exception every time you need one. This way, you can ensure the exception's state accurately reflects the specific context.

class NumberTooLargeExceptios: ArithmeticException("My message")

class NegativeNumberException: Exception("Negative number are forbidden")

fun myFun(number: Int) {
    if(number < 0) throw NegativeNumberException()
    
    println(number)
}

sealed class AccountException(message: String, cause: Throwable? = null): Exception(message, cause)
class InvalidAccountCredentialsException: AccountException("Invalid account credentials detected")
class APIKeyExpiredException(message: String = "API key expired", cause: Throwable? = null)	: AccountException(message, cause)

class Person(val name: String?)

fun fail(message: String?): Nothing {
    throw IllegalArgumentException(message)
}

fun main() {
//     val a = 4
//     val b = 3
//     val max = if(a < b) {
//         println("b is bigger")
//         b
//     } else {
//         println("a is bigger")
//         a
//     }
    
//     println(max)
    
//     val x = 2
//     when(x) {
//         1 -> println("x == 1")
//         2 -> println("x == 2")
//     }
    
//     val text = when(x) {
//         1 -> "x == 1"
//         2 -> "x == 2"
//         else -> "neither 1 nor 2"
//     }
//     println(text)
//     val bool: Boolean = false
//     val valu = when(bool) {
//         true -> "Yes"
//         false -> "No"
//     }
//     val bit = Bit.ZERO
//     val numericValue = when(bit) {
//         Bit.ZERO -> 0
//         Bit.ONE -> 1
//     }
//     println(numericValue)
    
//     val number: Int = 4
//     when {
//         number % 2 == 0 -> println("Broj je paran")
//         number % 2 != 0 -> println("Broj je neparan")
//         else -> "Broj je nevazec"
//     }
    
//     val arr = arrayOf(4, 6, 2, 1)
//     for(el in arr.indices) {
//         println(arr[el])
//     }
    foo()
//     val userInput = -2
//     val cause = IllegalStateException("Original cause: Illegal state")
//     if(userInput < 0) {
//         throw cause
//     }
    
    println(getIndicies(2))
    printNonNullString("wweg")
    
    var someState: String? = null
    fun getStringValue(): String {
        val state = checkNotNull(someState) { "State must be set beforehand!" }
        check(state.isNotEmpty()) { "State must be non-empty!" }
        
        return state
    }
    
     //getStringValue()
     
     someState = "ffwrgw"
    println(getStringValue())
    printNonNullStringWithCheck("null")
    
    val user1 = User("Alice", "admin")
    processUserRole(user1)
    
    val user2 = User("Bob", "user")
    
    val num: Int = try {
        count()
    } catch(e: ArithmeticException) {
        -1
    }
    println("num is $num")
    
    val availableFunds = 500.0
    val withdrawalAmount = 500.5
    
    try {
        processWithdrawal(availableFunds, withdrawalAmount)
    } catch(e: InsufficientFundsException) {
        println(e.message)
    } catch(e: WithdrawalException) {
        println(e.message)
    }
    divideOrNull(0)
    myFun(5)
    
    val person = Person(null)
    val s: String = person.name ?: fail("Name required")

    // 's' is guaranteed to be initialized at this point
    println(s)
}