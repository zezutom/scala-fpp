
/*
	Playing with Pattern Matching, examples by:
	http://kerflyn.wordpress.com/2011/02/14/playing-with-scalas-pattern-matching/
*/

object PatternMatchingSandBox {

	def toYesOrNo(choice: Int):String = choice match {
		case 1 | 2 | 3 => "yes"
		case 0 => "no"
		case _ => "error"
	}                                         //> toYesOrNo: (choice: Int)String
	
	toYesOrNo(0)                              //> res0: String = no
	toYesOrNo(1)                              //> res1: String = yes
	toYesOrNo(2)                              //> res2: String = yes
	toYesOrNo(3)                              //> res3: String = yes
	toYesOrNo(4)                              //> res4: String = error
	
	def checkType(x: Any) = x match {
		case i:Int => "an integer:" + i
		case _:Double => "a double"
		case s:String => "a string:" + s
	}                                         //> checkType: (x: Any)java.lang.String
	
	checkType(1)                              //> res5: java.lang.String = an integer:1
	checkType(1.0)                            //> res6: java.lang.String = a double
	checkType("hello world")                  //> res7: java.lang.String = a string:hello world
	
	def fact(n: Int): Int = n match {
		case 0 => 1
		case n => n * fact(n - 1)
	}                                         //> fact: (n: Int)Int
	
	fact(5)                                   //> res8: Int = 120
	
	// collection length - the classic approach
	def length[A](list: List[A]): Int = {
		if (list.isEmpty) 0
		else 1 + length(list.tail)
	}                                         //> length: [A](list: List[A])Int
	
	length(List("a", "b", "c"))               //> res9: Int = 3
	
	// reworked using PM
	def lengthPM[A](list: List[A]):Int = list match {
		// a list with whatever head followed by a tail
		case _ :: tail => 1 + lengthPM(tail)
		// an empty list
		case Nil => 0
	}                                         //> lengthPM: [A](list: List[A])Int
	
	lengthPM(List("a", "b", "c"))             //> res10: Int = 3
	
	// Advanced stuff - case classes
	
	sealed abstract class Expression
	case class X() extends Expression
	case class Const(value: Int) extends Expression
	case class Add(left: Expression, right: Expression) extends Expression
	case class Mult(left: Expression, right: Expression) extends Expression
	case class Neg(expr: Expression) extends Expression
	
	def eval(expr: Expression, value: Int): Int = expr match {
		case X() => value
		case Const(const) => const
		case Add(left, right) => eval(left, value) + eval(right, value)
		case Mult(left, right) => eval(left, value) * eval(right, value)
		case Neg(expr) => - eval(expr, value)
	}                                         //> eval: (expr: PatternMatchingSandBox.Expression, value: Int)Int
	
	// 1 + 2 * X*X
	val expr = Add(Const(1), Mult(Const(2), Mult(X(), X())))
                                                  //> expr  : PatternMatchingSandBox.Add = Add(Const(1),Mult(Const(2),Mult(X(),X(
                                                  //| ))))
  eval(expr, 3)                                   //> res11: Int = 19
}