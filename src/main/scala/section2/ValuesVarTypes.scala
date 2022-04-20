package section2

object ValuesVarTypes extends App {
  val x: Int = 42
  println(x)
  // Vals are immutable
  val y = "Some text"
  val myString: String = "This is my string."
  println(myString)

  val myBool: Boolean = true || false;
  val myChar: Char = 'a'
  val myShort: Short = 12
  val myLong: Long = 1235432431234L
  val myFloat: Float = 1.0f
  val myDouble: Double = 2.0


  var myBool2: Boolean = false
  // Side effects
  myBool2 = true 
  println(myBool2)
}