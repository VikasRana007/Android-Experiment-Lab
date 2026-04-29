package me.vikas.experimentLab.solid_design.LSP_Design.first_problem


interface Bird

interface Flyable{
    fun fly()
}

class BirdClient{

    fun processBird(bird: Bird){
        println("Processing Bird Hashing : ${bird.hashCode()}")
    }

    fun makeFly(flyable: Flyable){
        println(flyable.fly())
    }
}


class Sparrow: Bird, Flyable{
    override fun fly() {
        println("Sparrow is flying.")
    }
}

class Ostrich: Bird


fun main(){
    val birdClient = BirdClient()

    val sparrow = Sparrow()
    val ostrich = Ostrich()

    birdClient.processBird(ostrich)
    birdClient.makeFly(sparrow)

}