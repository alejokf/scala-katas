package lists

import org.scalatest.FunSuite

class ListExercisesTest extends FunSuite {

  test("pack of List('a','a','a','b','c','c','a')") {
    val expected = List(List("a", "a", "a"), List("b"), List("c", "c"), List("a"))
    assertResult(expected)(ListExercises.pack(List("a", "a", "a", "b", "c", "c", "a")))
  }
}
