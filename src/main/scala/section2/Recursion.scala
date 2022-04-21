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

    def concatenateTailrec(myString: String, n: Int, accumulator: String): String = {
        if (n <= 0) accumulator
        else concatenateTailrec(myString, n-1, accumulator+myString)
    }

    println(concatenateTailrec("Hello Bar", 5000, ""))


    def isPrime(myInt: Int): Boolean = {
        def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean = {
            if (!isStillPrime) false
            else if (t <= 1) true
            else isPrimeTailrec(t-1, myInt % t != 0 && isStillPrime)
        }
        isPrimeTailrec(myInt/2, true)
    }

    println(isPrime(2003))
    println(isPrime(679))


    def fibonacciFunc(n: Int): BigInt = {
        def fibonacciFuncTailrec(i: Int, last: Int, prev: Int): BigInt = {
            if (i >= n) last
            else fibonacciFuncTailrec(i+1, last+prev, last)
        }
        if (n <= 2) 1
        else fibonacciFuncTailrec(2, 1, 1)
    }

    println(fibonacciFunc(2000))

}