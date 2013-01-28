
object ListMap {

  def squareList(xs: List[Int]): List[Int] = xs match {
  	case Nil => xs
  	case y :: ys => y * y :: squareList(ys)
  }                                               //> squareList: (xs: List[Int])List[Int]
  
  def squareList2(xs: List[Int]): List[Int] =
    xs map (x => x * x)                           //> squareList2: (xs: List[Int])List[Int]
    
  squareList(List(2, 3, 4))                       //> res0: List[Int] = List(4, 9, 16)
  
  squareList2(List(2, 3, 4))                      //> res1: List[Int] = List(4, 9, 16)
}