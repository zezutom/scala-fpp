
object Decomposition {
	
	trait Expr {
		// classification methods
		def isNumber: Boolean
		def isSum: Boolean
		
		// accessor methods
		def numValue: Int
		def leftOp: Expr
		def rightOp: Expr
	}
	
	class Number(n: Int) extends Expr {
		def isNumber: Boolean = true
		def isSum: Boolean = false
		def numValue: Int = n
		def leftOp: Nothing = throw new Error("Number.leftOp")
		def rightOp: Nothing = throw new Error("Number.rightOp")
	}
	
	class Sum(e1: Expr, e2: Expr) extends Expr {
		def isNumber: Boolean = false
		def isSum: Boolean = true
		def numValue: Int = throw new Error("Sum.numValue")
		def leftOp: Expr = e1
		def rightOp: Expr = e2
	}
	
	// now we want to make use of these types
	def eval(e: Expr): Int = {
		if (e.isNumber) e.numValue
		else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
		else throw new Error("Unknown expression " + e)
	}                                         //> eval: (e: Decomposition.Expr)Int
	
	eval(new Sum(new Number(1), new Number(2)))
                                                  //> res0: Int = 3
	
	// works, but adding of classification and accessor methods quickly becomes tedious
  // if we wanted to add 2 new subtypes as detailed below, we would need 25 new methods
  // to be added to the whole hierarchy in total. It shows this approach is not sustainable
  // since the method additions grow quadratically.
  
  // e1 * e2
	//class Product(e1: Expr, e2: Expr) extends Expr
	
	// variable 'x'
	//class Var(x: String) extends Expr
	
	// How do we go about it? We could use type tests and casts similar to the ones
	// made in Java: def isInstanceOf[T]: Boolean, def asInstanceOf[T]: T
	// But Scala has better means of doing it.
	
	// The solution is shown in the Eval worksheet
	
	
	
	
}