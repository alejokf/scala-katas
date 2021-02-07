package clockwisespiral

import org.scalatest.FunSuite

class SpiralTest extends FunSuite {

  test("Spiral with negative size") {
    val expected = Array.ofDim[Int](0, 0)
    assertResult(expected)(Spiral.createSpiral(-1))
  }

  test("Spiral with size of 1") {
    val expected = Array(Array(1))
    assertResult(expected)(Spiral.createSpiral(1))
  }

  test("Spiral with size of 2") {
    val expected = Array(Array(1, 2), Array(4, 3))
    assertResult(expected)(Spiral.createSpiral(2))
  }

  test("Spiral with size of 3") {
    val expected = Array(Array(1, 2, 3), Array(8, 9, 4), Array(7, 6, 5))
    assertResult(expected)(Spiral.createSpiral(3))
  }

  test("Spiral with size of 4") {
    val expected = Array(Array(1, 2, 3, 4), Array(12, 13, 14, 5), Array(11, 16, 15, 6), Array(10, 9, 8, 7))
    assertResult(expected)(Spiral.createSpiral(4))
  }

  test("Spiral with size of 5") {
    val expected = Array(Array(1, 2, 3, 4, 5), Array(16, 17, 18, 19, 6), Array(15, 24, 25, 20, 7), Array(14, 23, 22, 21, 8), Array(13, 12, 11, 10, 9))
    assertResult(expected)(Spiral.createSpiral(5))
  }

}
