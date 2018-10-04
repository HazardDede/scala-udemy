package lectures.part1_basics

object Expressions extends App {
  val x: Int = 1 + 2
  println(x)

  println(2 + 3 * 4)  // Math operators: + - * / & | ^ << >> >>> (right shift with zero extension)

  println(1 == x)
  // == equality
  // != non equality

  println(!(1 == x))
  // ! logical negation

  var aVariable = 2
  aVariable += 3

  // Instructions (DO) vs. Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 3
  println(aConditionValue)

  // Loops - avoid them like plague -> specific to imperative programming
  var i = 0
  while (i < 10) {  // NEVER write this again
    println(i)
    i += 1
  }

  val aWeirdValue: Unit = (aVariable = 3)
  println(aWeirdValue)

  // Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"  // Value of the code block is the value of the last expression
  }
  println(aCodeBlock)

  // 1. What is the difference between "hello world" and println("hello World")?
  // 2. Whats the value?
  val someValue = {
    2 < 3
  }
  println(someValue)

  // 3. What's the value?
  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }
  println(someOtherValue)
}
