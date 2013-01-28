
object MergeSort {

  /*
  	Merge sort as an effecient sort algorithm:
  	1. if there is only one or even none element in the list, return the list
  	2. split the list in two halves
  	3. sort both of the halves in isolation
  	4. merge the two sorted parts
  */
  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {

      val (first, second) = xs splitAt n
      betterMerge(msort(first), msort(second))
    }
  }                                               //> msort: (xs: List[Int])List[Int]

  def merge(xs: List[Int], ys: List[Int]): List[Int] = xs match {
    case Nil => ys
    case x :: xs1 =>
      ys match {
        case Nil => xs
        case y :: ys1 =>
          if (x < y) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
  }                                               //> merge: (xs: List[Int], ys: List[Int])List[Int]

	def betterMerge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
		case (Nil, ys) => ys
		case (xs, Nil) => xs
		case (x :: xs1, y :: ys1) =>
		  if (x < y) x :: betterMerge(xs1, ys)
		  else y :: betterMerge(xs, ys1)
	}                                         //> betterMerge: (xs: List[Int], ys: List[Int])List[Int]
	
  val myList = List(10, 2, 6, 3, 1, 4)            //> myList  : List[Int] = List(10, 2, 6, 3, 1, 4)

  msort(myList)                                   //> res0: List[Int] = List(1, 2, 3, 4, 6, 10)
}