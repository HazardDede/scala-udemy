package lectures.part2_oop

object AnonymousClasses extends App {
  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahhahaha")
  }

  println(funnyAnimal.getClass)
  funnyAnimal.eat


  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name!. How can I help?")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println("Hi, my name is Jim")
  }
}
