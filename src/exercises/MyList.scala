package exercises

abstract class MyList {
  /*
    head = first Element of the list (int)
    tail = remainder of the list
    isEmpty = is this list empty
    add(int) = new List with this element added
    toString = returns a string representation
   */
  def head(): Int
  def tail(): MyList
  def isEmpty(): Boolean
  def add(item: Int): MyList
}
object MyList {
  def apply(): MyList = EmptyList
}

class Node(val item: Int, val succ: MyList = EmptyList) extends MyList {
  def head(): Int = item
  def tail(): MyList = succ
  def isEmpty(): Boolean = false
  def add(item: Int): MyList = new Node(item, this)
  override def toString(): String = s"Node($item, ${succ.toString()})"
}

object EmptyList extends MyList {
  def head(): Int = throw new NoSuchElementException
  def tail(): MyList = throw new NoSuchElementException
  def isEmpty(): Boolean = true
  def add(item: Int): MyList = new Node(item)
  override def toString(): String = "EmptyList()"
}

object Runner extends App {
  val list: MyList = MyList()
  //println(list.head())
  //println(list.tail())
  println(list.isEmpty())
  println(list.toString())

  val singleItemList: MyList = list.add(5).add(10).add(15)
  println(singleItemList.head())
  println(singleItemList.tail())
  println(singleItemList.isEmpty())
  println(singleItemList.toString())
}
