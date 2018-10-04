package lectures.part3_functional

object AnonymousFunctions extends App {
  // anonymous function (lambda)
  val doubler: Int => Int = x => x * 2

  // multiple params in lambda
  val adder: (Int, Int) => Int = (a, b) => a + b

  // no params
  val justDoIt: () => Int = () => 3

  println(justDoIt)    // function pointer
  println(justDoIt())  // 3

  // We must call lambdas with parenthesis

  // curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // More syntactic sugar
  val niceIncrementer: Int => Int = _ + 1   // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _  // equivalent to (a, b) = a + b

  /*
    1. MyList: replace all FunctionX calls with lambdas
   */

  /*
    2: Rewrite the "sepcial" adder as an anonymous function
   */
  val curryAdder: Int => (Int => Int) = (v1: Int) => (v2:Int) => v1 + v2

  println(curryAdder(3)(4))
}
