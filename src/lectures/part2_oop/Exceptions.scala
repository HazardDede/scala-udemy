package lectures.part2_oop

object Exceptions extends App {
  val x: String = null
//  print(x.length)
//  ^^ thiswill crash with a NullPointerException

  // val aWeirdValue = throw new NullPointerException

  // 1. throwing Exceptions
  // throwable classes extend the Throwable class.
  // Exception and Error are the major Throwable subtypes
  // Exception: Something wrong with your program
  // Error: Something wrong with your system (OOM)

  // 2. catching exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    // code that might fail
    getInt(true)
  } catch {
    case e: RuntimeException => 42
  } finally {
    // code that will get executed no matter what
    // optional
    // does not influence the return type of the expression
    // use finally only for side effects
    println("finally")
  }

  println(potentialFail)
  println(potentialFail.getClass)

  // 3. how to define your own exceptions
  class MyException extends Exception
  val exception = new MyException
  // throw exception

  /*
    1. Crash your program with an OutOfMemoryError
   */
//  val array = Array.ofDim(Int.MaxValue)

  /*
    2. Crash your problem with an StackOverflowError
   */
//  def infinite: Int = 1 + infinite
//  infinite

  /*
    3. Pocket Calculator
      - add(x, y)
      - subtract(x, y)
      - multiply(x, y)
      - divide(x,y)

      Throw custom exceptions
        - OverflowException if add(x, y) exceeds Int.MAX_VALUE
        - UnderflowException if substract(x, y) exceeds Int.MIN_VALUE
        - MathCaculationException for division by 0
   */
  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }
    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }
    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }
    def divide(x: Int, y: Int): Int = {
      if (y == 0) throw new MathCalculationException
      x / y
    }
  }

  val calc = PocketCalculator
  // println(calc.add(Int.MaxValue, 4))
  // println(calc.divide(10, 0))
  // println(calc.multiply(6, Int.MaxValue))
  // println(calc.subtract(Int.MinValue, 2))
}
