package org.zezutom.scala.fpp.classes.week02.currying

object MultipleParameterList {

  // a syntactic sugar to the principle of currying
  def sum(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f)(a + 1, b)     //> sum: (f: Int => Int)(a: Int, b: Int)Int

  // product is a function that calculates a product
  // of the values of a function for the points
  // in the given interval
  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1 else f(a) * product(f)(a + 1, b) //> product: (f: Int => Int)(a: Int, b: Int)Int
  product(x => x * x)(3, 4)                       //> res0: Int = 144

  // the product applied to factorial
  def factorial(n: Int) = product(x => x)(1, n)   //> factorial: (n: Int)Int

  factorial(5)                                    //> res1: Int = 120

  // a function that generalizes both a sum and a product
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
  
  // with a new abstraction in place, let's redefine the product function
  def product2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
                                                  //> product2: (f: Int => Int)(a: Int, b: Int)Int
  product2(x => x * x)(3, 4)                      //> res2: Int = 144

}