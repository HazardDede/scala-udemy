package lectures.part1_basics

object ValuesVariablesTypes extends App {

  // Values

  val x: Int = 42  // Vals are immutable (constant or final)
  println(x)

  val x1 = 42 // Types of vals are optional. Compiler can infer types
  println(x1)

  val aString: String = "Hello Scala"
  println(aString)

  val aBoolean : Boolean = true
  val aChar : Char = 'a'
  val anInt : Int = x
  val aShort : Short = 255
  val aLong : Long = 1234566789L
  val aFloat : Float = 2.1f
  val aDouble : Double = 3.14

  // Variables

  var aVariable: Int = 4
  aVariable = 5 // Can be reassigned
  aVariable += 1
  println(aVariable)
}
