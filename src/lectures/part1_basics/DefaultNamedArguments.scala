package lectures.part1_basics

object DefaultNamedArguments extends App {
  def factorial(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else factorial(n - 1, n * acc)

  val fact10 = factorial(5)
  println(fact10)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("Don't care")
  savePicture()
  savePicture("bmp")
  savePicture(width = 800, height = 600)  // Could also pass them in different order
}
