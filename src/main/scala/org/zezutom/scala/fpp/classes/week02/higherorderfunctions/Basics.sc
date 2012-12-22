package org.zezutom.scala.fpp.classes.week02.higherorderfunctions

object Basics {
  
  def sumInts(a: Int, b: Int): Int =
    if (a > b) 0 else a + sumInts(a + 1, b)       //> sumInts: (a: Int, b: Int)Int
    
  def sumCubes(a: Int, b: Int): Int =
    if (a > b) 0 else cube(a) + sumCubes(a + 1, b)//> sumCubes: (a: Int, b: Int)Int
  
  def sumFactorials(a: Int, b: Int): Int =
  	if (a > b) 0 else factorial(a) + sumFactorials(a + 1, b)
                                                  //> sumFactorials: (a: Int, b: Int)Int
  
  def cube(a: Int): Int = a * a * a               //> cube: (a: Int)Int
  
  def factorial(a: Int): Int =
  	if (a == 0) 1 else a * factorial(a - 1)   //> factorial: (a: Int)Int
  	
  sumInts(1, 3)                                   //> res0: Int = 6
  sumCubes(1, 3)                                  //> res1: Int = 36
  sumFactorials(1, 3)                             //> res2: Int = 9
  
  /*
  	This is all very well, but ..
  	
  	.. can this be written in a more efficient way?
  	
  	Is there a common pattern to it?
  
  */
}