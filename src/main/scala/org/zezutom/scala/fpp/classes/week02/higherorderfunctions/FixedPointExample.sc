package org.zezutom.scala.fpp.classes.week02.higherorderfunctions
import math.abs

object FixedPointExample {
  
  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4
    
  def isCloseEnough(x: Double, y: Double) =
  	abs((x - y) / x) / x < tolerance          //> isCloseEnough: (x: Double, y: Double)Boolean
  	
	def fixedPoint(f: Double => Double)(firstGuess: Double) = {
		def iterate(guess: Double): Double = {
			println("guess = " + guess)
			val next = f(guess)
			if (isCloseEnough(guess, next)) next
			else iterate(next)
		}
		iterate(firstGuess)
	}                                         //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double
	
	fixedPoint(x => 1 + x/2)(1)               //> guess = 1.0
                                                  //| guess = 1.5
                                                  //| guess = 1.75
                                                  //| guess = 1.875
                                                  //| guess = 1.9375
                                                  //| guess = 1.96875
                                                  //| guess = 1.984375
                                                  //| guess = 1.9921875
                                                  //| guess = 1.99609375
                                                  //| guess = 1.998046875
                                                  //| guess = 1.9990234375
                                                  //| guess = 1.99951171875
                                                  //| res0: Double = 1.999755859375
	
	// sqrt(x) is a fixed point of the function (y => x / y)
	// but we need to prevent the values from oscilating too much
	// therefore we apply averages of successive values
	def sqrt(x: Double) =
		fixedPoint(y => (y + x / y) / 2)(1)
                                                  //> sqrt: (x: Double)Double
	
	sqrt(2)                                   //> guess = 1.0
                                                  //| guess = 1.5
                                                  //| guess = 1.4166666666666665
                                                  //| guess = 1.4142156862745097
                                                  //| res1: Double = 1.4142135623746899
	// we confirmed that averaging of successive values works
	// let's make this approach abstract
	
	def avg(f: Double => Double)(x: Double) = (x + f(x)) / 2
                                                  //> avg: (f: Double => Double)(x: Double)Double
	
	// now we can write the sqrt function in a much cleaner way
	def sqrt1(x: Double) = fixedPoint(avg(y => x / y))(1)
                                                  //> sqrt1: (x: Double)Double
  sqrt1(2)                                        //> guess = 1.0
                                                  //| guess = 1.5
                                                  //| guess = 1.4166666666666665
                                                  //| guess = 1.4142156862745097
                                                  //| res2: Double = 1.4142135623746899
}