package org.zezutom.scala.fpp.classes.week02.tailrecursion

object FactorialNonTailRecursive {

  // computes a factorial of the given integer
  def factorial(n: Int): Int =
  	if (n == 0) 1 else n * factorial(n - 1)   //> factorial: (n: Int)Int
  	
	factorial(4)                              //> res0: Int = 24
	
	// here is how it expands
	/*
		-> if (4 == 0) 1 else 4 * factorial(4 - 1)
		-> 4 * factorial(3)
		..
		-> 4 * (3 * factorial(2))
		..
		-> 4 * (3 * (2 * factorial(1)))
		..
		-> 4 * (3 * (2 * (1 * factorial(0)))
		-> 4 * (3 * (2 * (1 * 1)))
		-> 24
		
		After calling a factorial there is still work left to be done (multiplication).
		The calls accumulate and more and more stack frames are needed.
		
		Conclusion:
		
		This is NOT a tail recursive function. Therefore we can
		eventually hit the StackOverflow exception.
	*/
	
	// We risk overflowing the stack even when the input is a low number
	factorial(10)                             //> res1: Int = 3628800
	

}