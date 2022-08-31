package module_12.Generics_And_Utility_Classes_Throwable

class NoAmmoException (message: String) : Exception(message){
    init { println(message) }
}
