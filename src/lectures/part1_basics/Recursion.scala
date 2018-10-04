package lectures.part1_basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)
      result
    }
  }

  println(factorial(10))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)  // Tail recursion = use the recursive call as the LAST expression

    factHelper(n, 1)
  }

  println(anotherFactorial(10))

  /*
    anotherFactorial(5) = factHelper(5, 1)
    = factHelper(4, 1 * 5)
    = factHelper(3, 4 * 5 * 1)
    = factHelper(2, 3* 4 * 5 * 1)
    = factHelper(1, 2 * 3 * 4 * 5 * 1)
   */

  println(anotherFactorial(400))

  /*
    1. String concat a string n times using tail recursion
   */
  def concat(aString: String, n: Int): String = {
    @tailrec
    def aux(n: Int, accu: String): String = {
      if (n <= 0) accu
      else aux(n - 1, aString + accu)
    }
    aux(n, "")
  }
  println(concat("a", 0))
  println(concat("a", 1))
  println(concat("a", 5))

  /*
    2. prime which is tail recursive
   */
  def prime(n: Int): Boolean = {
    @tailrec
    def helper(divider: Int): Boolean = {
      if (divider <= 1) return true
      if (n % divider == 0) false
      else helper(divider - 1)
    }
    helper(n / 2)
  }
  println(prime(5))
  println(prime(2003))
  println(prime(629))

  /*
    3. fibonacci which is tail recursive
   */
  def fibonacci(n: Int): Int = {
    @tailrec
    def fiboTailRec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fiboTailRec(i + 1, last + nextToLast, last)
    }

    if (n <= 2) 1
    else fiboTailRec(2, 1, 1)
  }

  println(fibonacci(8))
}
