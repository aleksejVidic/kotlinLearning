fun printAllStrings(vararg string: String) {
    for(str in string) {
        println(str)
    }
}

class Cat {
    fun purr() {
        println("Purr purr")
    }
}

fun petAnimal(animal: Any) {
    val isCat = animal is Cat
    
    if(isCat) {
        animal.purr()
    }
}

fun printString(str: Any): Unit { if(str is String && str.length > 0) println(str.length) }



fun main() {
    val byte: Byte = 0b0011
    val int: Short = byte.toShort()
    
    println((5 / 2) == 2)
    val x = 5L / 2
	println (x == 2L)
    
    val y = 1
    val shiftedLeft = y and 2
    println(shiftedLeft)
    println('\uFF00')
    val str = "abcd 123"
    println(str[0])
    for(c in str) {
        println(c)
    }
    val s = "abc" + 1
    println(s + "def")
    val p = "Citao sam \"Dune\""
    val multiline = """
    >jpeojgewgp
    >iohgoiewioghw
    >ighwroighroi
        
    """.trimMargin(">")
    println(multiline)
    
    // converting from string to array
    val arr: CharArray = str.toCharArray()
    arr[0] = 'w'
    println(String(arr))
    
    var array = arrayOf("Nile", "Amazon", "Ukrina")
    array += "Missisipi"
    println(array.joinToString())
    val arr1 = arrayOf(1, 2, 3)
    println(arr1.joinToString())
    val arrOfNulls: Array<Int?> = arrayOfNulls(2)
    println(arrOfNulls.joinToString())
    var exampleArray = emptyArray<String>()
    val initArray = Array<Int>(3) { 0 }
    println(initArray.joinToString())
    
    val asc = Array<Int>(5) { i -> (i * i) }
    println(asc.contentDeepToString())
    val twoDArr = Array(2) { Array(2) { 0 } }
    println(twoDArr.contentDeepToString())
    val arr2 = Array(2) { Array(3) { 0 }}
    println(arr2.contentDeepToString())
    val simpleArr: Array<Int> = arrayOf(1, 2, 3)
    val twoD = Array(2) { Array(2) { it } }
    simpleArr[0] = 10
    println(simpleArr.joinToString())
    twoD[0][0] = 3
    println(twoD.contentDeepToString())
    val lettersArray = arrayOf("c", "d")
    printAllStrings("a", "b", *lettersArray)
    val arr3: Array<Int> = arrayOf(1, 2, 3)
    val arr4: Array<Int> = arrayOf(1, 2, 3)
    println(arr3.contentEquals(arr4))
    println(arr3.contentDeepEquals(arr4))
    println(arr3.sum())
    arr3.shuffle()
    println(arr3.joinToString())
    println(arr3.toList())
    println(arr3.toSet())
    
    val intArr: IntArray = IntArray(3) { it }
    println(intArr.contentToString())
    println(intArr.sum())
    val obj = "fwger"
    if (obj !is String) return

	println(obj.length)
    
    val checkVal: Int = 43
    when(checkVal) {
        is Int -> println(checkVal + 1)
        is String -> println(checkVal.length + 1)
        
    }
    val cat = Cat()
    petAnimal(cat)
    printString(obj)
    
    
}