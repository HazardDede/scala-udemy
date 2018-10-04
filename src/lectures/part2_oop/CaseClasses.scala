package lectures.part2_oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  // 1. Class params are promoted to fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  println(jim)  // will automatically delegate to toString method

  // 3. equals and hashCode implemented out of the box
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. Case classes have handy copy methods
  val jim3 = jim.copy(age=45)
  println(jim3)

  // 5. Case classes have companion objects
  val thePerson = Person
  val mary = Person("Mary", 18)  // in practice we do not use new

  // 6. Case classes are serializable
  // Akka -> deals with sending message through the network and use case classes

  // 7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  /*
    Expand MyList - use case classes and case objects
   */
}
