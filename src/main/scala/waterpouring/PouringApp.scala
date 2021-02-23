package waterpouring

object PouringApp extends App {

  val problem = new Pouring(Vector(4, 9))
  println(problem.moves)

  println(problem.solutions(6))
}