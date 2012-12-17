package org.zezutom.scala.fpp.sandbox

object Pascal {
  def main(args: Array[String]) {    
    printTriangle(10);
  }

  def printTriangle(rows: Int) {
    if (rows < 1 || rows > 25) {
      println("Please enter a number between 0 and 25.");
    } else {
      println("Pascal's Triangle");
      val START: Long = System.nanoTime();
      val SPACE_FACTOR: Int = 4;
      
      for (row <- 0 to rows) {
        if (row < rows)
          print(("%" + (rows - row) * SPACE_FACTOR + "s").format(""));
        var maxSpace: Int = SPACE_FACTOR * 2;
        for (col <- 0 to row)
          print(("%" + maxSpace + "d").format(pascal(col, row)));
        println()
      }
      val STOP: Long = System.nanoTime();
      println();
      println("Elapsed time: " + ((STOP - START) / 1000000) + " ms");
    }
  }

  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || r == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1);
  }
}