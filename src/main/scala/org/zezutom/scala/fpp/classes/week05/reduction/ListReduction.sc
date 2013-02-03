
object ListReduction {

	def sum(xs: List[Int]): Int = xs match {
		case Nil => 0
		case y :: ys => y + sum(ys)
	}                                         //> sum: (xs: List[Int])Int
	
	val data = List(2, 2, 3)                  //> data  : List[Int] = List(2, 2, 3)
	sum(data)                                 //> res0: Int = 7
	
	// we can abstract it using the reduceLeft method of the List
	// applies the provided function on each consecutive pair of elements
	// in our application, the sum is 0 by default
	def sum1(xs: List[Int]): Int = (0 :: xs) reduceLeft((x, y) => x + y)
                                                  //> sum1: (xs: List[Int])Int
	sum1(data)                                //> res1: Int = 7
	
	def product(xs: List[Int]): Int = (1 :: xs) reduceLeft((x, y) => x * y)
                                                  //> product: (xs: List[Int])Int
  product(data)                                   //> res2: Int = 12
  
  // we can save us a bit of typing as follows
  def sum2(xs: List[Int]): Int = (0 :: xs) reduceLeft(_ + _)
                                                  //> sum2: (xs: List[Int])Int
  def product1(xs: List[Int]): Int = (1 :: xs) reduceLeft(_ * _)
                                                  //> product1: (xs: List[Int])Int
  
  sum2(data)                                      //> res3: Int = 7
  product1(data)                                  //> res4: Int = 12
  
  // now, with foldLeft we can drop even more code
  // foldLeft takes a default parameter, so called 'accumulator'
  // that one is returned if the list is empty
  def sum3(xs: List[Int]): Int = (xs foldLeft 0) (_ + _)
                                                  //> sum3: (xs: List[Int])Int
  sum3(data)                                      //> res5: Int = 7
  
  def product2(xs: List[Int]): Int = (xs foldLeft 1) (_ * _)
                                                  //> product2: (xs: List[Int])Int
  product2(data)                                  //> res6: Int = 12
  
  // the ops above have their counterparts which make the tree
  // lean towards right: reduceRight, foldRight
  
  def concat[T](xs: List[T], ys: List[T]): List[T] = (xs foldRight ys) (_ :: _)
                                                  //> concat: [T](xs: List[T], ys: List[T])List[T]
  
  val text1 = List('h', 'e', 'l', 'l', 'o')       //> text1  : List[Char] = List(h, e, l, l, o)
  val text2 = List('w', 'o', 'r', 'l', 'd')       //> text2  : List[Char] = List(w, o, r, l, d)
  
  concat(text1, text2)                            //> res7: List[Char] = List(h, e, l, l, o, w, o, r, l, d)

}