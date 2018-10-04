package lectures.part2_oop

// import everything with playground._
// Import aliasing with => (to avoid naming conflicts)
import playground.{Cinderella => Princess, PrinceCharming}

import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App {
  // package members are accessable by their simple name
  val writer = new Writer("Daniel", "Rock the JVM", 2018)

  // import the package
  val princess = new Princess

  // If you do not want to import the package (fully qualified name):
  // val princess = new playground.Cinderella

  // packages are ordered hierarchie (part2_oop is a subpackage of lectures)

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

  // 1. Use full qualified name to avoid naming conflicts
  val date = new Date
  val sqlDate = new java.sql.Date(2018, 5, 4)

  // 2. Import Aliasing
  val sqlDate2 = new SqlDate(2018, 5, 4)

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.PreDef - println, ???
}
