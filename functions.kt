fun func(): Unit {
    println("This is function")
}

fun sum(a: Int = 0, b: Int = 0): Int {
    return a + b
}

// single-expression function

fun sum2(x: Int, y: Int): Int = x + y

fun isEven(num: Int): Boolean {
    if(num < 0) return false
    if(num % 2 != 0) return false
    return true
}

val emails: List<String> = listOf("aco@gmail.com", "aleksej@hotmail.com", "acika@yahoo.com")

fun emailExist(email: String): Boolean {
    if(!(email in emails)) return false
    return true
}

// lambda functions

val upperCaseString = { str: String -> str.uppercase()}
fun upperCase(str: String): String = str.uppercase()

// usage of lamba expressions

//1. pass to another function

val numbers: List<Int> = listOf(3, -4, 2, -1, 6)

val positives: List<Int> = numbers.filter({ x: Int -> x > 0})

val isNegative = { x: Int -> x < 0 }

val negatives: List<Int> = numbers.filter(isNegative)

val even = numbers.filter{x: Int -> x % 2 == 0}

val squares: List<Int> = numbers.map{ x: Int -> x * x}

val double: (Int) -> Int = { x -> x * 2}

//2. return from a function

fun toSeconds(time: String): (Int) -> Int = when(time) {
    "hour" -> { hour -> hour * 60 * 60 }
    "minute" -> { minute -> minute * 60 }
    "second" -> { second -> second }
    else -> { va -> va}
}

// 3. trailing lambdas(case when lambda is last parameter inside function)
fun main() {
  
    
    func()
    println(sum(b = 3, a = 2))
    println(sum())
    println(sum2(3, 6))
    println(isEven(-3))
    println(isEven(3))
    println(isEven(34))
    println(emailExist("sfdsd"))
    println(emailExist("aco@gmail.com"))
    println(upperCaseString("fwgr"))
    println(upperCase("fegw"))
    println(positives)
    println(negatives)
    println(even)
    println(squares)
    println(double(3))
    println(double(4))
    val timeInMinutes: List<Int> = listOf(2, 10, 15, 1)
    val toSec = toSeconds("minute")
    val totalTimeInSeconds = timeInMinutes.map(toSec).sum()
    println(totalTimeInSeconds)
}

