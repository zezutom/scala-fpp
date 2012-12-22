package org.zezutom.scala.fpp.classes.week02.higherorderfunctions

object BetterWithAnonymousFunctions {

	// let's abstract the core functionality
	def sum(f: Int => Int, a: Int, b: Int): Int =
		if (a > b) 0 else f(a) + sum(f, a + 1, b)
                                                  //> sum: (f: Int => Int, a: Int, b: Int)Int
	// now, we can reuse it
	// let's use anonymous functions to avoid creating
	// unnecessary pieces of code
	def sumInts(a: Int, b: Int) = sum(x => x, a, b)
                                                  //> sumInts: (a: Int, b: Int)Int
	def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b)
                                                  //> sumCubes: (a: Int, b: Int)Int
	def sumFactorials(a: Int, b: Int) = sum(factorial, a, b)
                                                  //> sumFactorials: (a: Int, b: Int)Int

  def factorial(a: Int): Int =
  	if (a == 0) 1 else a * factorial(a - 1)   //> factorial: (a: Int)Int

  sumInts(1, 3)                                   //> res0: Int = 6
  sumCubes(1, 3)                                  //> res1: Int = 36
  sumFactorials(1, 3)                             //> res2: Int = 9

}