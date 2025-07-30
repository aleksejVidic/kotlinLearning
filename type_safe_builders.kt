class Coffee {
    var strength = ""
    val flavors = mutableListOf<String>()
    
    fun setStrength(strength: String) {
        strength = strength
    }
    
    fun addFlavor(flavor: String) {
        flavors.add(flavor)
    }
}

fun brew(block: Coffee.() -> Unit): Coffee {
    val coffee = Coffee()
    coffee.block()
    return coffee
}


fun main() {
    val myCoffee = brew {
        setStrength("Strong")
        addFlavor("Vanilla")
        addFlavor("Caramel")
        
    }
}