fun main() {
    val a = 4
    var b = 3
    println(a + b)
    b = 5
    println(a + b)
    println("Vrijednost a je $a")
    println("Sledeci broj a je ${a + 1}")
    
    // data types
    
    // signed numbers
    val int: Int = 3
    val short: Short = 34
    val byte: Byte = 3
    println(byte)
    val long: Long = 4434235325
    println(long)
    
    // unsigned numbers
    val uByte: UByte = 23u
    val uShort: UShort = 345u
    val uInt: UInt = 23242u
    val uLong: ULong = 2435325464353u
    
    // floating point numbers
    
    val float: Float = 32.21f
    println(float)
    val double: Double = 234.121
    println(double)
    
    // boolean
    val bool: Boolean = true
    println(bool)
    
    //char 
    val char: Char = '3'
    println(char)
    
    // string
    val string: String = "Zdravo svete"
    println(string)
    
    // lists
    val list: List<Int> = listOf(3, 2, 6, 1)
    println(list)
    
    val list1: List<String> = listOf("smoki", "cips", "bananice")
    println(list1)
    
    val mutableList: MutableList<Int> = mutableListOf(4, 2, 5, 7)
    println(mutableList)
    
    mutableList[0] = 1
    println(mutableList)
    
    println("First item is ${list.first()}")
    println("Last item is ${list.last()}")
    println("Number of elements in list is ${list.count()}")
    println(2 in list)
    mutableList.add(9)
    println(mutableList)
    mutableList.remove(9)
    println(mutableList)
    
    // sets
    val set1: Set<Int> = setOf(1, 1, 3, 4, 12)
    println(set1)
    
    val mutableSet: MutableSet<Int> = mutableSetOf(3, 2, 1, 6)
    println(mutableSet)
    println("Set have ${mutableSet.count()} items")
    println(4 in mutableSet)
    
    mutableSet.add(7)
    println(mutableSet)
    mutableSet.remove(7)
    println(mutableSet)
    
    
    // maps
    
    val readOnlyMap: Map<String, Int> = mapOf("pica" to 23, "sendic" to 12, "palacinka" to 3)
	println(readOnlyMap)
    
    val mutableMap: MutableMap<Int, String> = mutableMapOf(1 to "nedovoljan", 
                                                           2 to "dovoljan",
                                                           3 to "dobar",
                                                           4 to "vrlo dobar",
                                                           5 to "odlican")
    
    println(mutableMap)
    println(mutableMap[5])
    println(readOnlyMap["pica"])
    mutableMap[5] = "super"
    println(mutableMap)
    println(mutableMap.count())
    mutableMap.remove(5)
    println(mutableMap)
    println(mutableMap.containsKey(4))
    println(mutableMap.keys)
    println(mutableMap.values)
    println(4 in mutableMap)
    println(5 in mutableMap)
    
    
    // conditions
    
    val num: Int = 4
    if(num % 2 == 0) println("Parno") else println("Neparno")
    
    
    // when condition
    
    val ocjena: Int = -3
    
    val nazivOcjene: String = when(ocjena) {
        1 -> "Nedovoljan"
        2 -> "Dovoljan"
        3 -> "Dobar"
        4 -> "Vrlo dobar"
        5 -> "Odlican"
        
        else -> "Nevazeca ocjena"
    }
    
    println(nazivOcjene)
    
    val trafficLightState: String = "Red"
    
    val trafficAction: String = when {
        trafficLightState == "Red" -> "Stop"
        trafficLightState == "Yellow" -> "Ready"
        trafficLightState == "Green" -> "Go"
        
        else -> "Undefined"
    }
    
    println(trafficAction)
    
    for (i in 1..4) {
        println(i)
    }
    
    for (i in 1..<4) {
        println(i)
    }
    
    for (i in 4 downTo 1) {
        println(i)
    }
    
    for (i in 1..7 step 2) {
        println(i)
    }
    
    for(i in 'a'..'e') {
        println(i)
    }
    
    for (i in 'z' downTo 'a' step 3) {
        println(i)
    }
    
    val jela: List<String> = listOf("kolaci", "mafin", "pica")
    
    for(jelo in jela) {
        println(jelo)
    }
    
    var counter: Int = 0
    
    while(counter < 10) {
        println("Nisam sit")
        counter++
    }
    
    println("Sit sam")
}