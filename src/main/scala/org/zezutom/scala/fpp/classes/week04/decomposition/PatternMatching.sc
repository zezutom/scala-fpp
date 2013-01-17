
/*
	The purpose of the Pattern Matching is to reverse the construction process:
	- Which subclass was used?
	- What were the arguments of the constructor?
	
	This situation is so common, that many functional languages,
	including Scala, automate it.
	
*/
object PatternMatching {

  trait Expr
  
  case class Number(n: Int) extends Expr
  
  case class Sum(e1: Expr, e2: Expr) extends Expr
 
  // Number(2) -> Number.apply(2) -> new Number(2)
 	// As a syntactic convenience, we no longer have to use the 'new' keyword
 	// when constructing new objects
 	Number(2)                                 //> res0: PatternMatching.Number = Number(2)
 
  // But there is no logic yet. Let's let the actual
  // pattern matching kick in:
 
  def eval(e: Expr): Int = e match {
  	case Number(n) => n
  	case Sum(e1, e2) => eval(e1) + eval(e2)
  }                                               //> eval: (e: PatternMatching.Expr)Int
  
  eval(Number(2))                                 //> res1: Int = 2
 	
 	eval(Sum(Number(1), Number(2)))           //> res2: Int = 3
 	
 	
}