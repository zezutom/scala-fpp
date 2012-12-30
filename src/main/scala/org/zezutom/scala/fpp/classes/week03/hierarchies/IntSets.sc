object IntSets {
  // It comes as no surprise that an abstract class cannot be instantiated
  // new IntSet()		// This wouldn't compile
  
  val t1 = new NonEmpty(3, Empty, Empty)          //> t1  : NonEmpty = {.3.}
  val t2 = t1 incl 4                              //> t2  : IntSet = {.3{.4.}}
  
  
  val t3 = new NonEmpty(2, Empty, Empty)          //> t3  : NonEmpty = {.2.}
  val u1 = t2 union t3                            //> u1  : IntSet = {.2{{.3.}4.}}
  
  t2 incl 2                                       //> res0: IntSet = {{.2.}3{.4.}}
  
  
  
}

abstract class IntSet {
	def incl(x: Int): IntSet
	def contains(x: Int): Boolean
	def union(other: IntSet): IntSet
}

// To cater for an easy implementation of the two methods
// we make use of binary trees

// Since the empty object looks always the same,
// instantiating it more than once is an overkill.
// What follows is a singleton. Note, that no new instance is / can ever be created.
object Empty extends IntSet {
	def contains(x: Int): Boolean = false
	def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
	def union(other: IntSet) = other
	override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
	
	// Now, we know the structure is sorted
	// Whatever on the left is of a lesser value than the current element
	// Whatever on the right is of a greater value compared to the current element
	
	def contains(x: Int): Boolean =
		if (x < elem) left contains x
		else if (x > elem) right contains x
		else true

	def incl(x: Int): IntSet =
		if (x < elem) new NonEmpty(elem, left incl x, right)
		else if (x > elem) new NonEmpty(elem, left, right incl x)
		else this
	def union(other: IntSet) = ((left union right) union other) incl elem
	override def toString = "{" + left + elem + right + "}"

}