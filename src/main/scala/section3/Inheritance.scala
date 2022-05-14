package section3

import scala.language.postfixOps

object Inheritance extends App {
    sealed class Animal {
        val name = "None"
        final val breathing: Boolean = true
        def eat = println("Eating...")
        protected def eating = println("Eating...")
        val aType: String = "wild"
        // private def eating = println("Eating...")
    }

    class Cat extends Animal {
        def special_dinner: Unit = eating
    }

    val cat: Cat = new Cat
    cat.eat
    cat.special_dinner


    // Constructors
    class Person(name:String, age: Int){
        def this(name:String) = this(name, 0)
    }

    class Adult(name:String, age:Int, idCard:Int) extends Person(name){}

    class Dog(override val name:String) extends Animal {
        override def eat: Unit = {
            println("Crunch")
            super.eat
        }
        override val aType: String = "domestic"
    }

    val dog:Dog = new Dog("k9")
    dog.eat
    println(dog aType)
    println(dog name)

    // Polymorphism

    val unknownDog: Animal = new Dog("k8")
    unknownDog eat

    // Prevent override.
    // Use final in member class
    // Use final entire class
    // sealed the class only to this file
    // final val breathing: Boolean = true or final before class, def.

}