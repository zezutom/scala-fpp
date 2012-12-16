package org.zezutom.scala.fpp.assignments.week01
import org.zezutom.scala.fpp.common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || r == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1);
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def balance(chars: List[Char], openCount: Int): Boolean = {

      if (chars.isEmpty) openCount == 0;
      else {
        val head: Char = chars.head;
        val tail: List[Char] = chars.tail;

        var result = head match {
          case '(' => openCount + 1;
          case ')' => openCount - 1;
          case whatever => openCount;
        }

        if (result >= 0) balance(tail, result) else false;
      }
    };

    balance(chars, 0);
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (money < 0 || coins.isEmpty) 0
    else {
      countChange(money - coins.head, coins) +
        countChange(money, coins.tail)
    }

  }
}