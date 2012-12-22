package org.zezutom.scala.fpp.classes.week02.currying

object Basics {
  // sum is a function that returns another function (sumF)
  // sumF applies the given function parameter and sums the results
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0 else f(a) + sumF(a + 1, b)
    sumF
  }                                               //> sum: (f: Int => Int)(Int, Int) => Int

  // now we can easily provide implementations of f(Int)
  /*
  	Notice, that no parameters need to be defined
  	with the implementations below.
  	
  	For ex. instead of
  	
  	def sumInts(a: Int, b: Int) = sum(..)
  	def sumCubes(a: Int, b: Int) = sum(..)
  	etc.
  	
  	See how the same parameters are defined over and over again.
  	
  	We resolve the redundancy as follows:

	  def sumInts = sum(..)
  	def sumCubes = sum(..)
  	
  	This concept is called Currying. Named after a logician Haskell Brooks Curry (1900 - 1982).
  	
  */
  def sumInts = sum(x => x)                       //> sumInts: => (Int, Int) => Int
  def sumCubes = sum(x => x * x * x)              //> sumCubes: => (Int, Int) => Int
  def sumFactorials = sum(factorial)              //> sumFactorials: => (Int, Int) => Int

  def factorial(a: Int): Int =
    if (a == 0) 1 else a * factorial(a - 1)       //> factorial: (a: Int)Int
    
	// finally, we can use the whole concept
	sumCubes(1, 10) + sumFactorials(10, 20)   //> res0: Int = 267634641
	
	// Instead of using a predefined function like this one
	sumCubes(1, 10)                           //> res1: Int = 3025
	
	// We can further simplify the calls by pasing a function as a paramter
	sum(x => x * x * x)(1, 10)                //> res2: Int = 3025

}