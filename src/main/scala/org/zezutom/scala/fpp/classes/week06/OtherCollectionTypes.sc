
import scala.io.Source

object OtherCollectionTypes {

	val xs = Array(1, 2, 3, 44)               //> xs  : Array[Int] = Array(1, 2, 3, 44)
	xs map (x => x * 2)                       //> res0: Array[Int] = Array(2, 4, 6, 88)
	
	val sum = xs.foldLeft(0) {(total, n) => total + n}
                                                  //> sum  : Int = 50
	val myList = List(1, 2, 3)                //> myList  : List[Int] = List(1, 2, 3)
	
	val s = "Hello World"                     //> s  : java.lang.String = Hello World
	s filter (c => c.isUpper)                 //> res1: String = HW
	
	val r1: Range = 1 until 5                 //> r1  : Range = Range(1, 2, 3, 4)
	val r2: Range = 1 to 5                    //> r2  : Range = Range(1, 2, 3, 4, 5)
	1 to 10 by 3                              //> res2: scala.collection.immutable.Range = Range(1, 4, 7, 10)
	6 to 1 by -2                              //> res3: scala.collection.immutable.Range = Range(6, 4, 2)
	
	s exists (c => c.isUpper)                 //> res4: Boolean = true
	s forall (c => c.isUpper)                 //> res5: Boolean = false
	
	val pairs = List(1, 2, 3) zip s           //> pairs  : List[(Int, Char)] = List((1,H), (2,e), (3,l))
	pairs.unzip                               //> res6: (List[Int], List[Char]) = (List(1, 2, 3),List(H, e, l))
	
	s flatMap (c => List('.', c))             //> res7: String = .H.e.l.l.o. .W.o.r.l.d
	
	xs.sum                                    //> res8: Int = 50
	xs.max                                    //> res9: Int = 44
	
	// a concise test of whether a number is is a prime number
	// (can be divided only by 1 and itself)
	def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0)
                                                  //> isPrime: (n: Int)Boolean
	
	isPrime(5)                                //> res10: Boolean = true
	
	val abba = List(('a', 2), ('a', 1), ('b', 2), ('b', 1))
                                                  //> abba  : List[(Char, Int)] = List((a,2), (a,1), (b,2), (b,1))
	abba ::: List(())                         //> res11: List[Any] = List((a,2), (a,1), (b,2), (b,1), ())
	
}