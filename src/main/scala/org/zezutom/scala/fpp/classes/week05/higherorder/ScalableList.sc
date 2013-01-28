
object ScalableList {

	def scaleList(xs: List[Double], factor: Double): List[Double] = xs match {
		case Nil => xs
		case y :: ys => y * factor :: scaleList(ys, factor)
	}                                         //> scaleList: (xs: List[Double], factor: Double)List[Double]
	
	scaleList(List(2, 3, 4), 2)               //> res0: List[Double] = List(4.0, 6.0, 8.0)
	
	// Using map, scaleList can be kept nice and short
	def scaleList2(xs: List[Double], factor: Double) =
	  xs map (x => x * factor)                //> scaleList2: (xs: List[Double], factor: Double)List[Double]
	  
  scaleList2(List(2, 3, 4), 2)                    //> res1: List[Double] = List(4.0, 6.0, 8.0)
  
}