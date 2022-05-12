package section3

object Generics extends App {
    class MyList[A] {
        // Use Type A
        val listOfInt = new MyList[Int]
        val listOfString = new MyList[String]
    }

    class MyMap[Key, Value]{}

    // generic methods
    object MyList {
        def empty[A]: MyList[A] = ???
    }
    val myEmptyList = MyList.empty[Int]

    class Animal
    class Dog extends Animal {}
    class Cat extends Animal {}

    // List[Cat] extends List[Animals] = Covariance
    class CovarianceList[+A]
    val animal = new Cat
    val animalList: CovarianceList[Animal] = new CovarianceList[Cat]

    // Bounded types
    // Any animal
    class Cage[A <: Animal](animal: A)
    val dogCage = new Cage(new Dog)
}