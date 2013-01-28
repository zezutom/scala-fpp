
object ListHOFunctions {

	val nums = List(2, -4, 5, 7, 1)           //> nums  : List[Int] = List(2, -4, 5, 7, 1)
	val fruits = List("apple", "pineapple", "orange", "banana")
                                                  //> fruits  : List[java.lang.String] = List(apple, pineapple, orange, banana)
  nums filter (x => x > 0)                        //> res0: List[Int] = List(2, 5, 7, 1)
  nums filterNot (x => x > 0)                     //> res1: List[Int] = List(-4)
  
  // filter and filterNot run in a single iteration, returns two sets of data
	nums partition (x => x > 0)               //> res2: (List[Int], List[Int]) = (List(2, 5, 7, 1),List(-4))
	
	// find the longest prefix of the list for which the condition holds true
	nums takeWhile (x => x > 0)               //> res3: List[Int] = List(2)
	
	// returns the remainder of the list
	nums dropWhile (x => x > 0)               //> res4: List[Int] = List(-4, 5, 7, 1)

	// combines take and drop
  nums span (x => x > 0)                          //> res5: (List[Int], List[Int]) = (List(2),List(-4, 5, 7, 1))

	val data = List("a", "a", "a", "b", "c", "c", "a")
                                                  //> data  : List[java.lang.String] = List(a, a, a, b, c, c, a)
	  
  def pack[T](xs: List[T]): List[List[T]] = xs match {
 		case Nil => Nil
 		case x :: xs1 =>
 			val (first, rest) = xs span (y => y == x)
 			first :: pack(rest)
  }                                               //> pack: [T](xs: List[T])List[List[T]]

  pack(data)                                      //> res6: List[List[java.lang.String]] = List(List(a, a, a), List(b), List(c, c)
                                                  //| , List(a))
  def encode[T](xs: List[T]): List[(T, Int)] =
    pack(xs) map (ys => (ys.head, ys.length))     //> encode: [T](xs: List[T])List[(T, Int)]
    
  encode(data)                                    //> res7: List[(java.lang.String, Int)] = List((a,3), (b,1), (c,2), (a,1))
}