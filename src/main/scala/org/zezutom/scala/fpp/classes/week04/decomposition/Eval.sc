
object Eval {
  
  trait Expr {
  	def eval: Int
  }
  
  class Number(n: Int) {
  	def eval: Int = n
  }
  
  class Sum(e1: Expr, e2: Expr) {
  	def eval: Int = e1.eval + e2.eval
  }
  
  // Cool, clean and tidy compared to the solution presented
  // in the Decomposition worksheet
  
  // But .. what if we want to display expressions now?
  // Well, we have to define a new method in every single subclass.
  // And that's tedious again.
  
  // To make things worse, we want to be able to simplify expressions:
  // a * b + a * c -> a * (b + c)
  // This is a non-local simplification, it cannot be encapsulated in the
  // method of a single object. We would have to add test and access methods
  // for all of the different subclasses. Once again, we face the square problem.
  
  // To conclude, we hit the limitation of the OO Decomposition.
  // The problem can be elegantly solved by the Functional Decomposition, the approach
  // is called Pattern Matching. See the PatternMatching worksheet.
  
  
  
  
}