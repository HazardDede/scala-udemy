package lectures.part3_functional

trait MyFunction[A, B] {
  def apply(element: A): B
}


object WhatIsAFunction extends App {
  // Use functions as first class elements
  // Problem: We come from OOP

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  val stringToIntConverter = new Function[String, Int] {
    override def apply(str: String): Int = str.toInt
  }

  println(stringToIntConverter("6"))

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(n1: Int, n2: Int): Int = n1 + n2
  }

  println(adder(5, 6))

  // Function types Function2[A, B, R] === (A, B) => R
  // All Scala functions are objects

  /*
    1. A function which takes two strings and concats
   */
  val concat: (String, String) => String = (str1: String, str2: String) => str1 + str2
  println(concat("Hi ", "you!"))

  /*
    2. transform the MyPredicate and MyTransformer into function types
   */
  // Remove MyFunction & MyPredicate and realize that you can use Functions or (A => B resp. A => Boolean) in method signatures
  /*
    3. define a function which takes an int and return another function which takes an int and returns an int
      - what's the type of the function
      - how to do it
   */
  val functionRes: (Int => (Int => Int)) = new Function[Int, Function[Int, Int]] {
    override def apply(v1: Int): Function[Int, Int] = new Function[Int, Int] {
      override def apply(v1: Int): Int = v1
    }
  }
  println(functionRes(1)(5))

  val sugarFunctionRes: Int => (Int => Int) = (v1: Int) => (v2:Int) => v1 + v2
  println(sugarFunctionRes(1)(5))
}
