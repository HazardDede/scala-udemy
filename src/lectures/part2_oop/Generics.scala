package lectures.part2_oop

object Generics extends App {
  class MyList[A] {
    // use the type A inside the class definition
  }

  class MyMap[Key, Value] {

  }

  val listOfIntegers = new MyList[Int]
  val listOfString = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = new MyList[A]
  }
  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // Does a List of Cat also extends a List of Aninmal?
  // 1. yes (covariance)
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog)???  HARD QUESTION
  // Adding a dog will turn the list into more generic (List of animals)
  class QuestionList[+A] {
    def add[B >: A](element: B): MyList[B] = ???
  }

  // 2. no (invariance)
  class InvariantList[A]
  // val invariantListAnimalList: InvariantList[Animal] = new CovariantList[Cat]

  // 3. Hell, no! Contravariance
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]
  // Makes no sense for list, but ...
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]  // Better: Trainer[Animal] is better. He can train even dogs...

  // Bounded types
  class Cage[A <: Animal](animal: A)  // Only accepts types that are a subtype of Animal
  val cage = new Cage(new Dog)

  class Car
  // val newCage = new Cage(new Car)
}
