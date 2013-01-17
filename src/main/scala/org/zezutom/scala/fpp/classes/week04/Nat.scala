package org.zezutom.scala.fpp.classes.week04

// The goal is to represent Natural Numbers in
// purely in the object-oriented manner.
// For the sake of the exercise, primitive numeric types 
// from the package scala.lang are NOT allowed to be used

// so called Peano Numbers: 
// a simple representation of natural numbers
// using only a zero value and a successor function
abstract class Nat {
  
  def isZero: Boolean
  def predecessor: Nat
  def successor = new Succ(this)
  def +(that: Nat): Nat
  def -(that: Nat): Nat
  
}

object Zero extends Nat {
  def isZero = true  
  def predecessor: Nothing = throw new Error("0.predecessor")
  def +(that: Nat) = that
  def -(that: Nat) = if (that.isZero) this else throw new Error("negative number")
}

class Succ(n: Nat) extends Nat {
  def isZero = false
  def predecessor = n
  def +(that: Nat) = new Succ(n + that)		// n + that gives a number one step smaller, 
  											// so we need to pass it to a new successor
  											// to arrive at sth like 'this + that'
  
  def -(that: Nat) = if (that.isZero) this else  n - that.predecessor	
  											// this is a clever trick of how to avoid
  											// the 'negative number' exception. 
  											// it's tempting to say new Succ(n - that)
  											// but 'n - that' can actually fall into negative numbers.
  
  
}