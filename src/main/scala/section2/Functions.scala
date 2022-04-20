package section2

object Functions extends App {

    def aFunction(a: String, b: Int): String = {
        a + " " + b
    }

    println(aFunction("Hello", 3))

    // parameters less Functions

    def aParameterLess(): Int = 42
    println(aParameterLess)


    def aRepeaterFunc(myString: String, n:Int): String = {
        if (n==1) myString
        else myString + aRepeaterFunc(myString, n-1)
    }

    println(aRepeaterFunc("Bar", 3))

    // In Scala we iterate over with recursively functions

    def aBigFunc(n: Int): Int = {
        def aSmallerFunc(a: Int, b: Int): Int = a + b

        aSmallerFunc(n, n-1)
    }

    def greetingFunc(name: String, age: Int): String = {
        s"Hey, my name is $name, and im $age years old"
    }

    println(greetingFunc("Bar", 31))

    def factorialFunc(n: Int): Int = {
        if (n == 1) n
        else n * factorialFunc(n-1)
    }

    println(factorialFunc(10))


    def fibonacciFunc(n: Int): Int = {
        if (n < 3) 1
        else fibonacciFunc(n-2) + fibonacciFunc(n-1)
    }

    println(fibonacciFunc(10))

    def isPrime(n: Int): Boolean = {
        def isPrimeUntil(t: Int): Boolean = {
            if (t <= 1) true
            else n % t != 0 && isPrimeUntil(t-1)
        }
        isPrimeUntil(n/2)
    }

    println(isPrime(10))
    println(isPrime(5))
}

