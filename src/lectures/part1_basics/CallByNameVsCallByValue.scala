package lectures.part1_basics

object CallByNameVsCallByValue extends App {

  def calledByValue(x: Long): Unit = {
    println("by val: " + x)
    println("by val: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  // printFirst(infinite(), 42)
  printFirst(42, infinite())
}
