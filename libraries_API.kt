// libraries

import kotlin.time.*// * represent wildcard import that means that Kotlin will import everyting within the pacakage
// * cannot be used in importing companion objects instead we need to explicitly declare the members of companion object
// instead we need to import properties of companion object
import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
fun main() {
    val text = "emosewa si niltoK"
    val reversedText = text.reversed()
    println(reversedText)
    
    val thirtyMinutes: Duration = 30.minutes
    val halfHour: Duration = 0.5.hours
    println(thirtyMinutes == halfHour)
    
    
}