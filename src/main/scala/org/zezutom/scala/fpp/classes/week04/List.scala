package org.zezutom.scala.fpp.classes.week04

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

// The methods 'head' and 'tail' are implemented by the parameters 
class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false 
}

class Nil[T] extends List[T] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nill.head") 
  def tail: Nothing = throw new NoSuchElementException("Nill.tail")
}

object List {
  // List(1, 2) = List.apply(1, 2)
  def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, new Nil))
  
  // List(1)
  def apply[T](x: T): List[T] = new Cons(x, new Nil)
  
  // List()
  def apply[T](): List[T] = new Nil
}
