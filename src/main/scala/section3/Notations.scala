package section3

import scala.language.postfixOps

object MethodNotation extends App {
    class Person(val name:String, favoriteMovie:String, age: Integer = 0) {
        def likes(movie:String): Boolean = movie == favoriteMovie;
        def hangoutWith(person: Person): String = {
            s"${this.name} is like to hangout with ${person.name}";
        }
        def unary_! : String = s"${this.name}, what the hack?"
        def isAlive : Boolean = true
        def apply(): String = s"Hey my name is ${this.name} and my fav movie is ${this.favoriteMovie} age ${age}";
        def apply(times: Int): String = s"${this.name} watched ${this.favoriteMovie} ${times} times";
        def unary_+ : Person = new Person(name, favoriteMovie, age+1) ;
        def learns(skill: String): String = s"Mary Learn ${skill}" ;
        def learnsScala : String = this.learns("scala") ;
        }
    val mary = new Person("Mary", "Inception");
    println(mary.likes("Inception"));
    // Infix Notations - Works with method with single argument.
    println(mary likes "Inception");
    println(s"${mary hangoutWith new Person("Mike", "Lord of the rings")} \n");
    println(s"All operator are methods:\nthis operator is 1.+(2) ${1.+(2)} is equal to this 1+2 ${1+2}");

    val x = -1
    val y = 1.unary_-
    println (s"\n-1 is equal to 1.unary_- | result: ${1.unary_-}")
    println ("\nunary_ operator is working with - + ~ !")
    println(s"\n!mary result: ${!mary}")

    // Postfix Notations
    println(mary.isAlive)
    println(mary isAlive)

    // Apply
    println(mary())
    val maryPlus : Person = (+mary)
    println((+maryPlus)())

    println(mary learnsScala)
    println(mary(9))
}