package section2

object Arguments extends App {
    def treFunc(n: Int, accumulator: Int = 1): Int = {
        if(n <= 1) accumulator
        else treFunc(n-1, n+accumulator)
    }

    val fact10 = treFunc(10, 1)

    def savePic(format: String="jpg", x: Int=400, y: Int=800): Unit = {
        println(s"saving pic $format in x: $x and y: $y")
    }

    savePic(format="bmp", x=500, y=500)
}