// lambda expressions with receiver
// Lambda expressions can also have a receiver. In this case, lambda expressions can access any member functions or properties of the receiver object without having to explicitly specify the receiver object each time.

class MenuItem(val name: String)

class Menu(val name: String) {
    val items = mutableListOf<MenuItem>()
    
    fun item(name: String) {
        items.add(MenuItem(name))
    }
}

fun menu(name: String, init: Menu.() -> Unit): Menu {
    val menu = Menu(name)
    menu.init()
    
    return menu
}

fun printMenu(menu: Menu) {
    println("Menu: ${menu.name}")
    menu.items.forEach { println("  Item: ${it.name}") }
}

fun main() {
    fun StringBuilder.appendText() { append("Hello") }
    val stringBuilder = StringBuilder()
    stringBuilder.appendText()
    println(stringBuilder.toString())
    
    val mainMenu = menu("Main Menu") {
        item("Home")
        item("Settings")
        item("Exit")
    }
    printMenu(mainMenu)
}