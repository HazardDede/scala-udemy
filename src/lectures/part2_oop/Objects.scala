package lectures.part2_oop

object Objects extends App {
  object Person {  // type + only instance
    // static / class level functionality
    val N_EYES = 2

    def canFly: Boolean = false

    // factory method
    def from(mother: Person, father: Person): Person = new Person("Jonathan")

    def apply(mother: Person, father: Person): Person = from(mother, father)
  }
  class Person (val name: String) {
    // instance-level functionality
  }
  // object Person and class Person are companions

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = Singleton instance by definition
  val mary = Person  // <- instance
  val john = Person  // both are the same
  println(mary == john)

  val jennifer = new Person("Jennifer")
  val dennis = new Person("Dennis")
  println(jennifer == dennis)

  val jonathan = Person.from(jennifer, dennis)
  val jonathanthesecond = Person(jennifer, dennis)

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit


}
