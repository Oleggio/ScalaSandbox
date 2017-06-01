class Fraction(n: Int, d: Int) { //Main constructor
  // Other constructors
  def this(n: Int, d:Int, t: String) = {
    this(n, d) // As in Java must be first statement in the constructor
    println("Another constructor")
  }
  require(n < 1000, "Too big numerator")
  println("numerator is " + n)
  println("denominator is " + d)
  println("Fraction: " + n + "/" + d + ". Decimal: " + (n/d).toDouble)
}

val a = new Fraction(12,3)
val b = new Fraction(12,3, "Decimal")

// val c = new Fraction(1001, 4) //java.lang.IllegalArgumentException: requirement failed: Too big numerator

a == b

//Singleton
object hw{
  def main(args: Array[String]) = {
  println("test")
  }
}

hw.main(Array(""))


//Collections
var l = (0 to 10).toSet //.toArray //.toSet - create in a funny way Set(0, 5, 10, 1, 6, 9, 2, 7, 3, 8, 4)
l size;
l.tail
l.head
l.last
l take 3
l.zip(List(4,5,6))
val l2 = (1, 3, 5, "f")
val l3 = List(1, 3, 5, "f")

val l4 = (0 to 10).toList
// l4 = l4 :+ 4 Error: reassignment to val

var l5 = (0 to 10).toList
l5 = l5 :+ 11
l5 = -1 +: l5
l5 = -2 :: l5 // Does the same as previous
l5 size;
l5 = l5 ++ l // joins 2 lists

var l6 = List((1, 1), (2,2))
var l7 = List((1, "abc"), (2,2))
var l8 = List((1, "abc"), (2,2), (("def"),3))

l6.isEmpty
l5.sum
var l9 = l5.filter(x => x < 5)
  l9 = l5.filter(x => { //anonymous function
    x % 2 == 0
  }
)

val f = { println("x"); 1}

lazy val f2 = { println("x"); 2}

val t = List((1, "abc"), (2, "def"), (3,"ghi"), (4, "jkl"), (5, "mno"))
t.take(0)
t(1)
t(0)_1

t.map(x => x._1).sum
t.map(x => x._1).max

t.sortBy(k => k._2 equals "abc")
