package section3

object Exceptions extends App {
    val x: String = null

    // 1. throw exception throw new NullPointerException

    // Throwable classes is extends the throwable class

    // 2. catch exception throw

    def getInt(withException: Boolean): Int = {
        if (withException) throw new RuntimeException("No int for you.")
        else 42
    }

    val potentialFail = try {
        getInt(true)
    } catch {
        case e: RuntimeException => println("Runtime exceptions")
    } finally {
        println("Finally code...")
    }

    // 3. custom exception
    // class MyException extends Exception

    // val customException = new MyException

    // throw customException

    // 4. OOM exception 
    // val array = Array.ofDim(Int.MAX_VALUE)

    // 5. Stack overflow exception
    // def infinite: Int = 1 + infinite
    // val noLimit = infinite()


}