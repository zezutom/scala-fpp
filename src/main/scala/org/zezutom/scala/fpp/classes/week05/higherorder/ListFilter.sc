package org.zezutom.scala.fpp.classes.week05.higherorder

object ListFilter {
  
  def posElems(xs: List[Int]): List[Int] = xs match {
  	case Nil => xs
  	case y :: ys => if (y > 0) y :: posElems(ys) else posElems(ys)
  }                                               //> posElems: (xs: List[Int])List[Int]
  
  posElems(List(-2, -1, 0, 1, 2))                 //> res0: List[Int] = List(1, 2)
  
  def posElems2(xs: List[Int]): List[Int] =
    xs filter (x => x > 0)                        //> posElems2: (xs: List[Int])List[Int]
    
  posElems2(List(-2, -1, 0, 1, 2))                //> res1: List[Int] = List(1, 2)
  
  
}