import org.zezutom.scala.fpp.classes.week04._

/*
	Write a function nth that takes an integer n and a list
	and selects the n'th element in the list.
	
	Elements are indexed from 0.
	
	If the index is outside of range an IndexOutOfBoundsException
	should be thrown.
*/
object nth {

  def nth[T](n: Int, xs:List[T]): T =
    if (xs.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) xs.head
    else nth(n - 1, xs.tail)                      //> nth: [T](n: Int, xs: org.zezutom.scala.fpp.classes.week04.List[T])T

	List(1, 2)                                //> res0: org.zezutom.scala.fpp.classes.week04.List[Int] = org.zezutom.scala.fpp
                                                  //| .classes.week04.Cons@6f0f4d89
  List(2)                                         //> res1: org.zezutom.scala.fpp.classes.week04.List[Int] = org.zezutom.scala.fpp
                                                  //| .classes.week04.Cons@55ab9655
  List()                                          //> res2: org.zezutom.scala.fpp.classes.week04.List[Nothing] = org.zezutom.scala
                                                  //| .fpp.classes.week04.Nil@741ad263

	val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
                                                  //> list  : org.zezutom.scala.fpp.classes.week04.Cons[Int] = org.zezutom.scala.f
                                                  //| pp.classes.week04.Cons@cea9d22
  nth(2, list)                                    //> res3: Int = 3
  nth(-1, list)                                   //> java.lang.IndexOutOfBoundsException
                                                  //| 	at nth$$anonfun$main$1.nth$1(nth.scala:15)
                                                  //| 	at nth$$anonfun$main$1.apply$mcV$sp(nth.scala:25)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at nth$.main(nth.scala:12)
                                                  //| 	at nth.main(nth.scala)
 	nth(4, list)
}