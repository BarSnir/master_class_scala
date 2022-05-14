package section3

object CaseClass extends App {
    case class Person(name: String, age: Int){}

    val jim = new Person("Jim", 34)
    println(jim.name)
    println(jim.toString)

    // Syntactic sugar for toString
    println(jim)

    // case classes are equals
    val jim2 = new Person("Jim", 34)
    println(jim==jim2)

    // case class got copies
    val jim3 = jim2.copy(age=45)
    println(jim3)

    // case class got companion Objects
    val thePerson = Person
    val mary = Person("mary", 34)
    println(mary)

    // case class are serializable
    case object UnitedKingdom {
        def name: String = "Hello from UK"
    }
}