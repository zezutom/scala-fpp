package org.zezutom.scala.fpp.assignments.week02
import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {
  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)

    val union1 = union(s1, s2)
    val union2 = union(union1, s3)
  }

  test("singletonSet contains the expected single value") {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton 1")
      assert(contains(s2, 2), "Singleton 2")
      assert(contains(s3, 3), "Singleton 3")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  test("intersect contains all of the shared elements") {
    new TestSets {
      val s = intersect(union1, union2)
      assert(contains(s, 1), "Intersect 1")
      assert(contains(s, 2), "Intersect 2")
      assert(!contains(s, 3), "Intersect 3")
    }
  }

  test("diff contains only the difference between the two sets") {
    new TestSets {
      val s = diff(union2, union1)
      assert(!contains(s, 1), "Diff 1")
      assert(!contains(s, 2), "Diff 2")
      assert(contains(s, 3), "Diff 3")
    }
  }

  test("filter selects only the elements accepted by the given predicate") {
    new TestSets {
      val s = filter(union2, x => x < 3)
      assert(contains(s, 1), "Filter 1")
      assert(contains(s, 2), "Filter 2")
      assert(!contains(s, 3), "Filter 3")      
    }
  }
  
  test("forall tests whether the given predicate holds true for all elements") {
    new TestSets {
      assert(forall(union2, x => x <= 3), "Forall 1")
      assert(forall(union2, x => x >= 1 && x <= 3), "Forall 2")
      assert(!forall(union2, x => x < 3), "Forall 3")
    }
  }
  
  test("exists tests whether the given predicate holds true for at least one element") {
    new TestSets {
      assert(exists(union2, x => x < 3), "Exists 1")
      assert(exists(union2, x => x > 1), "Exists 2")
      assert(!exists(union2, x => x > 3), "Exists 3")
    }
  }  
  
  test("map transforms the given set according to the given function") {
    new TestSets {
      val s = map(union2, x => x * 2)
      assert(contains(s, 2), "Map 1")
      assert(contains(s, 4), "Map 2")
      assert(contains(s, 6), "Map 3")
      assert(!contains(s, 1), "Map 4")
      assert(!contains(s, 3), "Map 5")
    }
  }
}
