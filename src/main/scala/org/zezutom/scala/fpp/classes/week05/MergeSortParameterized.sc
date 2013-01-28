import math.Ordering

object MergeSortParameterized {
  /*
  	Merge sort as an effecient sort algorithm:
  	1. if there is only one or even none element in the list, return the list
  	2. split the list in two halves
  	3. sort both of the halves in isolation
  	4. merge the two sorted parts
  */
  def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (ord.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
      val (first, second) = xs splitAt n
      merge(msort(first), msort(second))
    }
  }                                               //> msort: [T](xs: List[T])(implicit ord: scala.math.Ordering[T])List[T]

  val nums = List(7, -1, 4, 8, 2, 6, 1, 5, 3, 0)  //> nums  : List[Int] = List(7, -1, 4, 8, 2, 6, 1, 5, 3, 0)
  msort(nums)                                     //> res0: List[Int] = List(-1, 0, 1, 2, 3, 4, 5, 6, 7, 8)

	val fruits = List("apple", "pineapple", "orange", "banana")
                                                  //> fruits  : List[java.lang.String] = List(apple, pineapple, orange, banana)
 	msort(fruits)                             //> res1: List[java.lang.String] = List(apple, banana, orange, pineapple)
	
}