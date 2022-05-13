package section3

object AnonymousClasses extends App {
    abstract class Animal {
        def eat: Unit
    }
    // AnonymousClass
    val funnyAnimal: Animal = new Animal {
        override def eat: Unit = println("Hahaha")
    }

    println(funnyAnimal.getClass)

    class Person(name: String) {
        def greet: Unit = println(s"Hello $name")
    }

    val jim: Person = new Person("Jim") {
        override def greet: Unit = println("Hello jim")
    }

    println(jim.getClass)
}