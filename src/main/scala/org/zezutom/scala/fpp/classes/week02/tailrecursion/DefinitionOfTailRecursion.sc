package org.zezutom.scala.fpp.classes.week02.tailrecursion

object DefinitionOfTailRecursion {
  // the greatest common divisor of two numbers
  // using the Euclid's algorithm
  def gcd(a: Int, b: Int): Int = {
  	if (b == 0) a else gcd(b, a % b)
  }                                               //> gcd: (a: Int, b: Int)Int
  
  gcd(14, 21)                                     //> res0: Int = 7
  
  // here is how it expands
  /*
  	-> if (21 == 0) 14 else gcd(21, 14 % 21)
  	-> if (false) 14 else gcd(21, 14 % 21)
  	-> gcd(21, 14 % 21)
  	-> gcd(21, 14)
  	-> if (14 == 0) 14 else gcd(14, 21 % 14)
  	..
  	-> gcd(14, 7)
  	..
  	-> gcd(7, 0)
  	-> if (0 == 0) 7 else gcd(0, 7 % 0)
  	-> 7
  	
  	The reduction sequence oscilates. The gcd is always called in the last step.
  	
  	Conclusion:
  	
  	If a function calls itself as its last action, the function's stack frame
  	can be reused. This is called Tail Recursion.
  	
  	Tail recursive functions are iterative processes. They execute as effiently as a loop.
  	
  	In general, if the last action of a function consists of calling a function
  	(which may be the same), one stack frame would be sufficient for both functions.
  	Such calls are called Tail Calls.
  	
  	Tail recursive calls execute at the constant space.
  */
}