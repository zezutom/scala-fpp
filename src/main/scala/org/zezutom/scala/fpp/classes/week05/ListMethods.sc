
object ListMethods {
	// All of the methods above are available in the List class
	// Implementing them as external functions helps understand their complexity
	
	val xs = List(5, 10, 15)                  //> xs  : List[Int] = List(5, 10, 15)
	val ys = List(4, 2)                       //> ys  : List[Int] = List(4, 2)
	
	// complexity of N (recursive calls are proportional to the list size)
	def last[T](xs: List[T]): T = xs match {
		case List() => throw new Error("last of empty list")
		case List(x) => x
		case y :: ys => last(ys)
	}                                         //> last: [T](xs: List[T])T
	last(xs)                                  //> res0: Int = 15
	xs.last                                   //> res1: Int = 15
	
	def init[T](xs: List[T]): List[T] = xs match {
		case List() => throw new Error("init of empty list")
		case List(x) => List()
		case y :: ys => y :: init(ys)
	}                                         //> init: [T](xs: List[T])List[T]
		
	init(xs)                                  //> res2: List[Int] = List(5, 10)
	xs.init                                   //> res3: List[Int] = List(5, 10)
	
	// Complexity is proportial to the size of the first list, short-hand notation is: |xs|
	def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
		case List() => ys
		case z :: zs => z :: concat(zs, ys)
	}                                         //> concat: [T](xs: List[T], ys: List[T])List[T]
	concat(xs, ys)                            //> res4: List[Int] = List(5, 10, 15, 4, 2)
  xs ::: ys                                       //> res5: List[Int] = List(5, 10, 15, 4, 2)
  
  // Quadratic complexity (N concatenations * N reversals)
  // To be improved later on
  def reverse[T](xs: List[T]): List[T] = xs match {
  	case List() => xs
  	case y :: ys => reverse(ys) ++ List(y)
  }                                               //> reverse: [T](xs: List[T])List[T]
  
  reverse(xs)                                     //> res6: List[Int] = List(15, 10, 5)
  xs.reverse                                      //> res7: List[Int] = List(15, 10, 5)
  
  def removeAt(n: Int, xs: List[Int]) = (xs take n) ::: (xs drop n + 1)
                                                  //> removeAt: (n: Int, xs: List[Int])List[Int]
  removeAt(1, xs)                                 //> res8: List[Int] = List(5, 15)
}