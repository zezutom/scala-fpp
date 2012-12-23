package org.zezutom.scala.fpp.sandbox

object CurriedPascal {

  def combine(calc: (Int, Int) => Int, spaceFmt: Int => String, valueFmt: Int => String)(rows: Int) {
    def handleRow(row: Int) {
      if (row <= rows) {
        if (row < rows) print(spaceFmt(rows - row))
        for (col <- 0 to row) print(valueFmt(calc(col, row)))
        println()
        handleRow(row + 1)
      }
    }
    handleRow(0)
  }

  def calculate(c: Int, r: Int): Int =
    if (c == 0 || r == 0 || c == r) 1
    else calculate(c - 1, r - 1) + calculate(c, r - 1)

  def pascal(rows: Int) {
    if (rows < 1 || rows > 25) println("Please enter a number between 1 and 25.")  
    else combine(calculate, gap => ("%" + (gap * 4) + "s").format(""), value => ("%8d").format(value))(rows)
  }

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
    heading(measure(pascal(10)))
  }

}