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
   * Exercise 1: Pascal's Triangle
   * 
   * The numbers at the edge of the triangle are all 1, and each number inside the triangle 
   * is the sum of the two numbers above it. Write a function that computes the elements of 
   * Pascal’s triangle by means of a recursive process.
   * 
   * Do this exercise by implementing the pascal function in Main.scala, which takes a column c 
   * and a row r, counting from 0 and returns the number at that spot in the triangle. 
   * 
   * For example, pascal(0,2)=1, pascal(1,2)=2 and pascal(1,3)=3.
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || r == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1);
  }

  /**
   * Exercise 2: Parentheses Balancing
   * 
   * Write a recursive function which verifies the balancing of parentheses in a string, 
   * which we represent as a List[Char] not a String. For example, the function should 
   * return true for the following strings:
   * 
   * (if (zero? x) max (/ 1 x))
   * I told him (that it’s not (yet) done). (But he wasn’t listening)
   * 
   * The function should return false for the following strings:
   * 
   * :-)
   * ())(
   *
   * The last example shows that it’s not enough to verify that a string contains the same 
   * number of opening and closing parentheses.
   * 
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
   * Exercise 3: Counting Change
   * 
   * Write a recursive function that counts how many different ways you can make 
   * change for an amount, given a list of coin denominations. For example, there 
   * are 3 ways to give change for 4 if you have coins with denomiation 1 and 2: 1+1+1+1, 1+1+2, 2+2.
   * 
   * Do this exercise by implementing the countChange function in Main.scala. This function takes 
   * an amount to change, and a list of unique denominations for the coins. 
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