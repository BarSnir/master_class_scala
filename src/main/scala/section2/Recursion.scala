package section2

object Recursion extends App {
    def factorialFunc(n: Int): Int = {
        if (n == 1) n
        else {
            println(s"Computing factorial of $n with $n-1")
            // Causing stack overflow (we calculating)
            val result = n * factorialFunc(n-1)
            println(s"Done Computing factorial of $n with $n-1")
            result
        }
    }

    def factorialFuncV2(n: Int): BigInt = {
        def factHelper(x: Int, accumulator: Int): Int = {
            if (x <= 1) accumulator
            // TAIL recursion, override the last call stack and drop the last.
            else factHelper(x-1, x * accumulator) 
        }
        factHelper(n, 1)
    }
    println(factorialFuncV2(2000))
    /*
        When u need loops, Iterate with Tail recursion.
    */
}