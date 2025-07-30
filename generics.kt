// generics

// without generics

open class Remote {
    override fun toString(): String = "Remote"
}

open class TVRemote: Remote() {
    override fun toString(): String = "TV Remote"
    
    open fun onRedButtonClicked() {
        println("TV turns ON or OFF")
    }
}

open class ACRemote: Remote() {
    override fun toString(): String = "AC Remote"
    
    open fun onONOFFButtonClicked() {
        println("AC turns ON or OFF")
    }
}

class BrokenTVRemote: TVRemote() {
    override fun toString(): String = "Broken TV Remote"
    
    override fun onRedButtonClicked() {
        println("TV doenst turn on or off")
    }
}

class BrokenACRemote: ACRemote() {
    override fun toString(): String = "Broken AC Remote"
    
    override fun onONOFFButtonClicked() {
        println("AC doesnt turn ON or OFF")
    }
}

// class PersonSatDownNearRemote(private val remote: Remote) {
//     fun pleaseGiveMeRemote(): Remote = remote
// }

// kotlin code with generic

// generic constraints

// covariance
class PersonSatDownNearRemote<out T: Remote>(private val remote: T) {
    fun pleaseGiveMeRemote(): T = remote
}

// contravariance
class Dustbin<in T: Remote> {
    fun throwBrokenRemote(remote: T) {
        println("I will not give you $remote")
    }
}



fun main() {
//     val abhilash = PersonSatDownNearRemote(TVRemote())
//     val remote1 = abhilash.pleaseGiveMeRemote()
//     if(remote1 is TVRemote) {
//         remotel.onRedButtonClicked()
//     }
//     val sourabh = PersonSatDownNearRemote(ACRemote())
//     val remote2 = sourabh.pleaseGiveMeRemote()
//     if(remote2 is ACRemote) {
//         remote2.onONOFFButtonClicked()
//     }
    val abhilash = PersonSatDownNearRemote(TVRemote())
    val remote1 = abhilash.pleaseGiveMeRemote()
    remote1.onRedButtonClicked()
    val sourabh = PersonSatDownNearRemote(ACRemote())
    val remote2 = sourabh.pleaseGiveMeRemote()
    remote2.onONOFFButtonClicked()
    
    // generic constraint - with this you can prevent user to enter ohter unwanted types
    // with generic constraint you can only pass Remote and its subclasses as generic type, preventing missuse
    // before generic constraint because statment above is equivalent to:
    // class PersonSatDownNearRemote<T: Any?>(private val remote: T)
//     val nandan = PersonSatDownNearRemote(null)
//     val remote3 = nandan.pleaseGiveMeRemote()
    
    var amit: PersonSatDownNearRemote<Remote>? = null
    val abhilash2: PersonSatDownNearRemote<TVRemote> = PersonSatDownNearRemote(TVRemote())
    amit = abhilash2
    val dustbinRemote: Dustbin<Remote> = Dustbin()
    var dustbinBrokenRemote: Dustbin<BrokenTVRemote>? = null
    dustbinBrokenRemote = dustbinRemote
}