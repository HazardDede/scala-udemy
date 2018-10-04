package lectures.part2_oop

object Traits extends App {
  // abstract classes and members
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("crunch, crunch")
  }

  // traits - ultimate abstract data type
  trait Carnivore {
    def eat(aninmal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Croc"

    override def eat: Unit = println("nomnomnom")
    override def eat(aninmal: Animal): Unit = println(s"I am a croc and I am eating a ${aninmal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs. abstract classes
  // abstract and traits: abstract and non-abstract members
  // 1. traits do not have constructor parameters
  // 2. Only extend one class but multiple traits by the same class
  // 3. Traits are behaviour, abstract class is a type of thing
}
