class A { // implicit label @A
    inner class B { // implicit label @B
        fun Int.foo() { // implicit label @foo
            val a = this@A // A's this
            val b = this@B // B's this
            
            val c = this // foo() receiver, Int
            val c1 = this@foo // foo receiver, Int
            
            val funLit = lambda@ fun String.() {
                val d = this // funLit receiver, string
            }
            
            val funLit2 = { s: String ->
                // foo()'s receiver, since enclosing lambda expression
                // doesn't have any receiver
                val d1 = this
            }
        }
    }
}

fun main() {
    
    
}