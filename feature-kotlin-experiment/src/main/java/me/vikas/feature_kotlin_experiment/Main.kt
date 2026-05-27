package me.vikas.feature_kotlin_experiment


data class Contact(val name: String, val phoneNumber: String)

val contacts = listOf(
    Contact("Vikas", "+9199XXX11111"),
    Contact("Messi", "+9199XXX22222"),
    Contact("Ronaldo", "+9199XXX33333"))


/*Now, let's use the associateBy function on this list of
Contact to get a Map with the
key as name
value as phoneNumber*/


fun main(){

    val nameToNumberMap = contacts.associateBy( {it.name}, {it.phoneNumber})
    println(nameToNumberMap)

}