
object RelaxedIdentifiers {
	val x = new RelaxedRational(1, 3)         //> x  : RelaxedRational = 1/3
	val y = new RelaxedRational(5, 7)         //> y  : RelaxedRational = 5/7
	val z = new RelaxedRational(3, 2)         //> z  : RelaxedRational = 3/2

	x.numer                                   //> res0: Int = 1
	x.denom                                   //> res1: Int = 3
	
	x + y                                     //> res2: RelaxedRational = 22/21
	x < y                                     //> res3: Boolean = true
	x max y                                   //> res4: RelaxedRational = 5/7
	x - y - z                                 //> res5: RelaxedRational = -79/42
	-x                                        //> res6: RelaxedRational = 1/-3
}

class RelaxedRational(x: Int, y: Int) {
	require(y != 0, "denominator must be non-zero")
	
	def this(x: Int) = this(x, 1)
	
	private def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)
	val g = gcd(x, y)
	
	def numer = x / g
	def denom = y / g
	
	def + (that: RelaxedRational) =
		new RelaxedRational(numer * that.denom + that.numer * denom,
								 denom * that.denom)

	def unary_- : RelaxedRational = new RelaxedRational(-numer, denom)
	
	def - (that: RelaxedRational) = this + -that
	
	def < (that: RelaxedRational) = this.numer * that.denom < that.numer * this.denom
	
	def max(that: RelaxedRational) = if (this < that) that else this
	
	override def toString = numer + "/" + denom


}