package lectures.part2_oop

class Person(name: String, val age: Int) {  // constructor
  // Body
  val x = 2
  println("Nicen!")

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // overloading constructors
  def this(name: String) = this(name, 0)
}

/*
  Novel and a Writer
  Writer: first name, surname, year of birth
    - fullname

  Novel: name, year of release, author
    - authorAge
    - isWrittenBy(author)
    - copy (new year of release) = new instance of Novel
 */

class Writer(firstName: String, surname: String, val yearOfBirth: Int) {
  def fullname(): String = s"$firstName $surname"
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge(): Int = yearOfRelease - author.yearOfBirth
  def isWrittenBy(author: Writer): Boolean = author.equals(author)
  def copy(yearOfRelease: Int) : Novel = new Novel(name, yearOfRelease, author)
}

/*
  Counter class
    - receives int
    - method: current count
    - method: increment / decrement counter by 1 => new Counter
    - overload inc/dec to receive a param (amount) -> new Counter
 */
class Counter(val counter: Int = 0) {
  def inc(): Counter = inc(1)
  def dec(): Counter = dec(1)
  def inc(amount: Int): Counter = new Counter(counter + amount)
  def dec(amount: Int): Counter = new Counter(counter - amount)
}

object OOBasics extends App {
  val person = new Person("Jonathan", 1)
  println(person.x)
  person.greet("Dennis")
  person.greet()

  val writer = new Writer("John", "Doe", 1984)
  val imposter = new Writer("John", "Doe", 1984)
  println(writer.fullname())

  val novel = new Novel("Witcher", 2007, writer)
  println(novel.authorAge())
  println(novel.isWrittenBy(writer))
  println(novel.isWrittenBy(imposter))
  println(novel.copy(2018))

  val counter = new Counter
  println(counter.counter)
  println(counter.inc().counter)
  println(counter.inc(10).dec(5).counter)
}
