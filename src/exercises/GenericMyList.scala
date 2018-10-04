package exercises

abstract class MyGenericList[+T] {
  /*
    head = first Element of the list (int)
    tail = remainder of the list
    isEmpty = is this list empty
    add(int) = new List with this element added
    toString = returns a string representation
   */
  def head(): T
  def tail(): MyGenericList[T]
  def isEmpty(): Boolean
  def add[T1 >: T](item: T1): MyGenericList[T1]
  def map[T2](transformer: T => T2): MyGenericList[T2]
  def flatMap[T2](transformer: T => MyGenericList[T2]): MyGenericList[T2]
  def filter(predicate: T => Boolean): MyGenericList[T]

  def ++[T1 >: T](list: MyGenericList[T1]): MyGenericList[T1]
}
object MyGenericList {
  def apply[T](): MyGenericList[T] = Empty
}

case class Cons[+T](h: T, t: MyGenericList[T] = Empty) extends MyGenericList[T] {
  def head(): T = h
  def tail(): MyGenericList[T] = t
  def isEmpty(): Boolean = false
  def add[T1 >: T](item: T1): MyGenericList[T1] = Cons(item, this)
  override def toString(): String = s"Node($h, ${t.toString()})"

  def map[T2](transformer: T => T2): MyGenericList[T2] =
    new Cons[T2](transformer(h), t.map(transformer))

  def filter(predicate: T => Boolean): MyGenericList[T] =
    if (predicate(h)) Cons(h, t.filter(predicate))
    else t.filter(predicate)

  def ++[T1 >: T](list: MyGenericList[T1]): MyGenericList[T1] = Cons(h, t ++ list)

  def flatMap[T2](transformer: T => MyGenericList[T2]): MyGenericList[T2] =
    transformer(h) ++ t.flatMap(transformer)
}

case object Empty extends MyGenericList[Nothing] {
  def head(): Nothing = throw new NoSuchElementException
  def tail(): Nothing = throw new NoSuchElementException
  def isEmpty(): Boolean = true
  def add[T1 >: Nothing](item: T1): MyGenericList[T1] = Cons(item)
  override def toString(): String = "EmptyList()"

  def map[T2](transformer: Nothing => T2): MyGenericList[T2] = Empty
  def flatMap[T2](transformer: Nothing => MyGenericList[T2]): MyGenericList[T2] = Empty
  def filter(predicate: Nothing => Boolean): MyGenericList[Nothing] = Empty

  def ++[T1 >: Nothing](list: MyGenericList[T1]): MyGenericList[T1] = list
}

object GenericMyList extends App {
  val listOfIntegers: MyGenericList[Int] = new Cons[Int](1, Empty)
  println(listOfIntegers.toString)
  println(listOfIntegers.add(5).add("asdasd").toString)


  val empty = Empty
  val list = Empty.add(1).add(2).add(3)
  val list2 = Empty.add(4).add(5).add(6)

  println(list.map(_ * 2).toString)
  println(list.filter(x => x % 2 == 0).toString)

  println((list ++ list2).toString)

  println(list.flatMap(item => new Cons(item, new Cons(item + 1, Empty))).toString)
}
