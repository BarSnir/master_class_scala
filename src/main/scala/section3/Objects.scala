package section3

object Objects extends App {
    //  scala doesn't have class level static methods
    object Person {
        val NAME: String = "Bar"
        def canFly: Boolean = true
        // factory method
        def apply(mother: Person, father: Person): Person = new Person("Bob")
    }

    class Person(val name: String){}

    println(s"${Person.NAME} can fly ${Person canFly}")
    val mary: Person = new Person("Mary")
    val john: Person = new Person("John")
    // Objects are singletons 
    println(mary==john)

    println(Person(mary, john))

    // def main(args: Array[String]): Unit = extends App
}