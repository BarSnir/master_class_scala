package section2

object Expressions extends App {
    val x: Int = 1 + 1
    println(x)
    println(x == 2 && x != 1)

    var myInt: Int = 2
    myInt += 3
    println(myInt)

    val myCondition: Boolean = true
    if(myCondition){
        println("You right!")
    }

    if(myCondition) println(5) else println(2)

    // var i=0 
    // while(i < 10){
    //     println(i)
    //     i += 1
    // }
    // Never use loops in scala.
    // Everything is Scala is expressions.

    val wiredValue = (myInt=5)
    println(wiredValue)

    // Side effects: println, while loops

    // Code blocks:
    val codeBlock = {
        val x = 5
        val z = 2

        if (x>z) "Hello" else "Bye"
    }

    println(codeBlock) 

    val myBool: Boolean = {
        2 < 3
    }
    println(myBool) 
}