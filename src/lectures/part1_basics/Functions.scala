package lectures.part1_basics

object Functions extends App {
  def aFunction(a: String, b: Int): String = a + " " + b

  println(aFunction("Hello", 3))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction) // Calls the function. It is not the function

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("a", 5))

  // In scala you use recursion, NOT loops

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)
  aFunctionWithSideEffects("blub")

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n - 1)
  }
  println(aBigFunction(10))

  /*
    1. Greeting function (name, age) => Hi, my name is <name> and I am <age> years old
   */
  def greeting(name: String, age: Int): String = "Hi, my name is " + name + " and I am " + age + " years old."
  println(greeting("Jonathan", 1))

  /*
    2. Factorial function 1 * 2 * 3 * 4 * .. * n
   */
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }
  println(factorial(2))
  println(factorial(3))
  println(factorial(4))
  println(factorial(5))

  /*
    3. Fibonacci function f(1) = 1, f(2) = 1, f(n) = f(n - 1) + f(n - 2)
   */
  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }
  println(fibonacci(2))
  println(fibonacci(3))
  println(fibonacci(4))
  println(fibonacci(5))
  println(fibonacci(8))

  /*
    4. Tests if a number is prime
   */
  def prime(n: Int): Boolean = {
    def helper(divider: Int): Boolean = {
      if (divider <= 1) return true
      if (n % divider == 0) false
      else helper(divider - 1)
    }
    helper(n / 2)
  }
  println(prime(2))
  println(prime(3))
  println(prime(4))
  println(prime(5))
  println(prime(15))
  println(prime(2003))
}
