package org.zezutom.scala.fpp.classes.week02.higherorderfunctions

object Better {

	// let's abstract the core functionality
	def sum(f: Int => Int, a: Int, b: Int): Int =
		if (a > b) 0 else f(a) + sum(f, a + 1, b)
                                                  //> sum: (f: Int => Int, a: Int, b: Int)Int
	// now, we can reuse it
	def sumInts(a: Int, b: Int) = sum(id, a, b)
                                                  //> sumInts: (a: Int, b: Int)Int
	def sumCubes(a: Int, b: Int) = sum(cube, a, b)
                                                  //> sumCubes: (a: Int, b: Int)Int
	def sumFactorials(a: Int, b: Int) = sum(factorial, a, b)
                                                  //> sumFactorials: (a: Int, b: Int)Int

	def id(a: Int): Int = a                   //> id: (a: Int)Int
	def cube(a: Int): Int = a * a * a         //> cube: (a: Int)Int
  def factorial(a: Int): Int =
  	if (a == 0) 1 else a * factorial(a - 1)   //> factorial: (a: Int)Int

  sumInts(1, 3)                                   //> res0: Int = 6
  sumCubes(1, 3)                                  //> res1: Int = 36
  sumFactorials(1, 3)                             //> res2: Int = 9
	
	/*
		We were able to abstract the core functionality by using a construct
		called Function Type, which takes form as: A => B
		
		for ex. Int => Int is a function accepting an integer parameter and returning
		an integer value
		
		Now we have a cleaner code than the one in Basics.sc, but ..
		
		.. we had to create a bunch of smaller functions (id, cube, factorial).
		This is not very efficient.
		
		Can we do any better?
	*/
	
}