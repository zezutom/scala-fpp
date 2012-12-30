package org.zezutom.scala.fpp.sandbox

object CurriedPascal {

  // A general way of how the triangle is printed
  def printTriangle 
    (spaceFmt: Int => String = (x:Int) => "")
    (valueFmt: Int => String = (x:Int) => x + " ")
    (rows: Int) = {
    def iterate(row: Int) {
      if (row <= rows) {
        if (row < rows) print(spaceFmt(rows - row))
        for (col <- 0 to row) print(valueFmt(pascal(col, row)))
        println()
        iterate(row + 1)
      }
    }
    iterate(0)
  }
    
  // The default (unformatted) print
  def defaultPrint = printTriangle()()_
  
  // A pretty-printed triangle 
  def prettyPrint = printTriangle(prettySpace)(prettyValue)_
  
  
  // Aligns the space around values 
  def prettySpace(x: Int) = ("%" + (x * 4) + "s").format("") 
  
  // Ensures the value has enough space
  def prettyValue(x: Int) = ("%8d").format(x)
    
  def pascal(c: Int, r: Int): Int = 
    if (c == 0 || r == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  def measure(f: => Unit) {
    val START: Long = System.nanoTime(); 
    f
    println("\nElapsed time: " + ((System.nanoTime() - START) / 1000000) + " ms");
  }
  
  def heading(f: => Unit) {
    println("Pascal's Triangle\n")
    f
  }
  
  def main(args: Array[String]) {
    heading(measure(prettyPrint(10)))
  }

}