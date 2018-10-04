package lectures.part2_oop

object Interhitance extends App {
  class Animal {
    val creatureType: String = "wild"
    def eat = println("nomnomnom")
  }

  // single class inheritance
  class Cat extends Animal {
    def crunch = {
      this.eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog extends Animal {
    override val creatureType: String = "domestic"
    override def eat = {
      super.eat
      println("crunchy, crunchy")
    }
  }

  val dog = new Dog
  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog
  unknownAnimal.eat

  // prevent overloading
  // 1. final on member
  // 2. final on class
  // 3. sealed class - Extension in this file - no extension in other files
}
