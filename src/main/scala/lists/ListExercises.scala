package lists

object ListExercises {

  /**
   * Packs consecutive duplicates of list elements into sublists
   * @param xs a list of elements
   * @tparam T the type of the element
   * @return a list of lists
   */
  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs span (y => y == x)
      first :: pack(rest)
  }

  /**
   * Produces run-length encoding of a list
   * @param xs a list of elements
   * @tparam T the type of the element
   * @return a pair (x, n) with each element and the number of times it is repeated consecutively
   */
  def encode[T](xs: List[T]): List[(T, Int)] =
    pack(xs) map (ys => (ys.head, ys.length))

  // avg = list.sum / list.length traverses the list twice bc length is not stored in list
  def average(xs: List[Int]): Double = {
    val (s, l) = xs.foldLeft(0.0, 0)((t, v) => (t._1 + v, t._2 + 1))
    //val (s, l) = (xs foldLeft (0.0, 0))((t, v) => (t._1 + v, t._2 + 1))
    s / l
  }

  def reverse[T](xs: List[T]): List[T] = xs.foldLeft(List[T]())((xs, x) => x :: xs)

}
