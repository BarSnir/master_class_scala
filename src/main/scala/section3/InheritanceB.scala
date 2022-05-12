package section3

object InheritanceB extends App {
    // abstract members
    abstract class Animal {
        val aType: String
        def eat: Unit
    }

    class Dog extends Animal {
        override val aType: String = "dog"
        def eat: Unit = println("Crunch")
    }

    // Traits
    trait Carnivora {
        def eat(animal: Animal): Unit
    }

    class Crocodile extends Animal with Carnivora {
        val aType: String = "crocodile"
        def eat: Unit = println("super crunch")
        def eat(animal: Animal): Unit = println(s"lets eat some ${animal.aType}")
    }

    val dog: Dog = new Dog
    val croc: Crocodile = new Crocodile
    croc eat dog
    // traits vs abstract class
    // 1- traits doesn't have constructors
    // 2- we can implement class with multiped traits, but expends one class
    // 3- traits are behaviors, traits - what the animal do, abstract class- who is the animal
}