package section2

object CallBy extends App {
    def callByValue(n: Long): Unit = {
        println(s"call value $n")
        println(s"call value $n")
    }

    def callByName(n: => Long): Unit = {
        println(s"call name $n")
        println(s"call name $n")
    }

    callByValue(System.nanoTime())
    // value calculate before function.

    callByName(System.nanoTime())
    // value calculate every time the argument is called => Lazy evaluation

}