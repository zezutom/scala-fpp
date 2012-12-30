object Rationals {
	val x = new Rational(1, 3)                //> x  : Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : Rational = 3/2
  
  x.numer                                         //> res0: Int = 1
  x.denom                                         //> res1: Int = 3
  x.add(y)                                        //> res2: Rational = 22/21
  x.sub(y).sub(z)                                 //> res3: Rational = -79/42
	y.add(y)                                  //> res4: Rational = 10/7
	x.less(y)                                 //> res5: Boolean = true
  x.max(y)                                        //> res6: Rational = 5/7
  new Rational(10)                                //> res7: Rational = 10/1
  
  new Rational(1, 2).numer                        //> res8: Int = 1
	new Rational(1, 2).less(new Rational(2, 3))
                                                  //> res9: Boolean = true
	
	// in Scala, any method with a parameter can be used as an infix operator, as in: x + y
	
	// x.add(y) works but doesn't feel natural, instead one could say:
	x add y                                   //> res10: Rational = 22/21
	
	// on the same note
	x sub y sub z                             //> res11: Rational = -79/42
	x max y                                   //> res12: Rational = 5/7
}

class Rational(x: Int, y: Int) {
	require(y != 0, "denominator must be non-zero")
	
	def this(x: Int) = this(x, 1)
	
	private def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)
	
	def numer = x
	def denom = y
	
	def add(that: Rational) =
		new Rational(numer * that.denom + that.numer * denom,
								 denom * that.denom)

	def neg: Rational = new Rational(-numer, denom)
	
	def sub(that: Rational) = add(that.neg)
	
	def less(that: Rational) = this.numer * that.denom < that.numer * this.denom
	
	def max(that: Rational) = if (this.less(that)) that else this
	
	override def toString = {
	  val g = gcd(numer, denom)
		numer / g + "/" + denom / g
	}
}