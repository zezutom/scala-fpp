
object PairsAndTouples {

	val pair = ("answer", 42)                 //> pair  : (java.lang.String, Int) = (answer,42)
	
	// a template definition
	val (label, value) = pair                 //> label  : java.lang.String = answer
                                                  //| value  : Int = 42
  // the fields can also be directly accessed
  val x = pair._1                                 //> x  : java.lang.String = answer
  val y = pair._2                                 //> y  : Int = 42
  
  
                           
	
}