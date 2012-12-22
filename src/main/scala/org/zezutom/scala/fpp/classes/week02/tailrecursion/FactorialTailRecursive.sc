package org.zezutom.scala.fpp.classes.week02.tailrecursion

object FactorialTailRecursive {
  
  // computes a factorial of the given integer
  def factorial(n: Int): Int = {
  	def loop(acc: Int, n: Int): Int =
  		if (n == 0) acc else loop(acc * n, n - 1)
  	loop(1, n)
  }                                               //> factorial: (n: Int)Int
  
  factorial(4)                                    //> res0: Int = 24
  
  // here is how it expands
  /*
  	-> (4 == 0) 1 else loop(1 * 4, 4 - 1)
  	..
  	-> loop(4, 3)
  	-> (3 == 0) 4 else loop(4 * 3, 3 - 1)
  	..
  	-> loop(12, 2)
  	..
  	-> loop(24, 1)
  	..
  	-> loop(24, 0)
  	-> (0 == 0) 24 else loop(..)
  	-> 24
  */
}