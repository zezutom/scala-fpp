
object ListSandbox {
  val fruits = List("apples", "oranges", "pears") //> fruits  : List[java.lang.String] = List(apples, oranges, pears)
  val nums = List(1, 2, 3, 4)                     //> nums  : List[Int] = List(1, 2, 3, 4)
  val diag = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
                                                  //> diag  : List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
  val empty = List()                              //> empty  : List[Nothing] = List()
  
 // which can be rewritten using the '::' operator called 'cons'
 // this also shows how the data structure actually looks like
 
 val fruitsCon = "apples" :: ("oranges" :: ("pears":: Nil))
                                                  //> fruitsCon  : List[java.lang.String] = List(apples, oranges, pears)
 val numsCon = 1 :: (2 :: (3 :: (4 :: Nil)))      //> numsCon  : List[Int] = List(1, 2, 3, 4)
 val emptyCon = Nil                               //> emptyCon  : scala.collection.immutable.Nil.type = List()
 
 // thanks to the convention in Scala
 // that operators ending in ':' associate to the right
 // thus the parenthesses can be skipped
 val numsConSimple = 1 :: 2 :: 3 :: 4 :: Nil      //> numsConSimple  : List[Int] = List(1, 2, 3, 4)

 // since it is right-associative, the compiler sees it as:
 Nil.::(4).::(3).::(2).::(1)                      //> res0: List[Int] = List(1, 2, 3, 4)

 // insertion into an ordered list
 def insert(x: Int, xs: List[Int]): List[Int] = xs match {
 	 case List() => List(x)
 	 case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
 }                                                //> insert: (x: Int, xs: List[Int])List[Int]
 
 // insertion sort has complexity of N * N
 // for the number of both isort and insert methods
 // will be, in the worst case scenario, equal to the number
 // of elements in the list
 def isort(xs: List[Int]): List[Int] = xs match {
 	 case List() => List()
 	 case y :: ys => insert(y, isort(ys))
 }                                                //> isort: (xs: List[Int])List[Int]
}