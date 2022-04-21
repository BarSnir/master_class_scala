package section3

object OOPBasics extends App {
    val person: Person = new Person("Bar", 30)
    println(person.age)
    println(person.greet("John"))
    // overloading
    println(person.greet)

    val writerA: Writer = new Writer("John", "Doe", 76)
    println(writerA.fullName)
    val novelA: Novel = new Novel("Great Mind", 1998, writerA)
    println(s"The award is for ${novelA.name}, by ${novelA.writtenBy}, first release in ${novelA.release} At age of ${novelA.authorAge}")


    val counter : Count = new Count(1)
    val counterA: Count = counter.incrementCount(50).incrementCount(50)
    val counterB: Count = counter.decrementCount(2)
    println(counterA.currentCount)
    println(counterB.currentCount)

    val testCounter: Count = new Count(1)
    println(testCounter.incrementCountAcc(10, 2, 0).count)
}

// Construction class params.
// Class params are not members!
// Unless you declare them.

class Person(name: String,val age: Int=0) {
    //declare members
    val x = 2

    // creating some side effects
    println("Every pice of the cold block will be executed")

    def greet(name: String): Unit = println(s"Hey from ${this.name} to $name")

    def greet(): Unit = println(s"Hey $name")

    // Multiple constructors.
    def this(name: String) = this(name, 0)
    def this() = this("John Doe")
}


class Novel(val name: String, val release: Int, val  writer:Writer) {

    def authorAge(): Int = {
        this.writer.age
    }

    def writtenBy(): String = {
        this.writer.fullName
    }

    def copy(name: String, release: Int, writer: Writer): Novel = {
        this
    }

}


class Writer(val name: String, val last: String, val age: Int = 80) {
    def fullName(): String = {
        s"${this.name} ${this.last}"
    }
}

class Count(val count: Int) {

    def currentCount(): Int = count

    def incrementCount(): Count = new Count(count+1)
    def incrementCount(n: Int): Count = new Count(count+n)
    def incrementCountAcc(n: Int, myInt: Int ,acc: Int): Count = {
        if(n<1) new Count(acc)
        else incrementCountAcc(n-1, myInt ,acc+myInt)
    }
    
    def decrementCount(): Count = new Count(count-1)
    def decrementCount(n: Int): Count = new Count(count-n)
}