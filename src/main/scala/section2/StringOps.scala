package section2

object StringOps extends App {
    // Old Java ops
    val myString: String = "Learning Scala"
    println(myString.charAt(2))
    println(myString.substring(7, 12))
    println(myString.split(" ").toList)
    println(myString.split(" ").toArray)
    println(myString.startsWith("Learning"))
    println(myString.replace(" ", "_"))
    println(myString.toLowerCase)
    println(myString.toUpperCase)
    println(myString.length)

    val numberString: String = "456"
    // appending presenting
    println("a" +: numberString :+ "b")
    // reverse
    println(numberString.reverse)
    // take
    println(numberString.take(2))
    // parsing int
    val parsedNumber: Int = numberString.toInt
    println(parsedNumber)

    // New Scala strings StringOps

    // s- Interpolators
    val name = "Bar"
    val last = "Schlinger"
    val age = 30

    println(s"Hello $name $last in couple of days i will be ${age+1}")

    // f- Formats
    val speed = 1.2f
    val myth = f"$name can eat in speed of $speed%2.2f"
    println(myth)

    // raw- Interpolators
    println(raw"Backspace will print literally \n")
    // not via injected val or vars.
}