package lectures.part2_oop

object MethodNotations extends App {

  class Person (val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie.equals(favoriteMovie)
    def hangOutWith(person: Person) : String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person) : String = s"${this.name} is hanging out with ${person.name}"
    def unary_!(): String = s"${name}, what the heck?!"
    def isAlive(): Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"

    // Exercises
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie, age)
    def unary_+(): Person = new Person(name, favoriteMovie, age + 1)
    def learns(topic: String): String = s"$name learns $topic"
    def learnsScala(): String = this learns "Scala"
    def apply(times: Int): String = s"$name watched $favoriteMovie $times times"
  }

  val mary = new Person("Mary", "Inception")
  val tom = new Person("Tom", "Fight Club")

  // infix notation (syntactic sugar)

  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent -> infix notation (operator notation) - works with method with a single arg

  println(mary hangOutWith tom)
  println(mary + tom)

  // All operators are methods.
  println(2.+(3))

  // prefix notation
  val x = -1  // equivalent with 1.unary_-
  // unary_ only works with - + ~ !
  println(!mary)
  println(mary.unary_!())


  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary())

  /*
    1. Overload the + operator which receives a string
    mary + "the rockstar" => new Person "Mary (the rockstar)"
   */
  println((mary + "the rockstar").name)

  /*
    2. Add an age to the person class default 0
        Add unary + operator => new Person age +1
   */
  println((+mary).age)

  /*
    3. Add learns method in the person class => Mary leans Scala
       Add learnsScala method, calls the learns method with "Scala" as a parameter
       Use it in postfix notation.
   */
  println(mary learns "Mathematics")
  println(mary learnsScala)

  /*
    4. Overload apply method to receive a number and return a String
        mary.apply(2) => "Mary watched Inception 2 times"
   */
  println(mary(2))
  println(tom(15))
}
