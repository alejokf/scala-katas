package clockwisespiral

object Spiral extends App {

  val n = 7
  val digits = String.valueOf(n * n).length
  val format = s"%0${digits}d"
  val spiral = createSpiral(n)
  print(spiral.map(row => row.map(format.format(_))).map(_.mkString(" ")).mkString("\n"))

  def createSpiral(n: Int): Array[Array[Int]] = {
    if (n < 0) {
      Array.ofDim(0, 0)
    } else {
      val spiral = Array.ofDim[Int](n, n)
      var currentPosition = Position(0, 0, Right)
      spiral(0)(0) = 1
      for (i <- 2 to n * n) {
        currentPosition = findNextPosition(currentPosition, n)
        spiral(currentPosition.row)(currentPosition.col) = i
      }

      spiral
    }
  }

  def findNextPosition(currentPosition: Position, spiralSize: Int): Position = {
    val direction = findIncreasingDirection(currentPosition, spiralSize)
    direction match {
      case Left => Position(currentPosition.row, currentPosition.col - 1, direction)
      case Right => Position(currentPosition.row, currentPosition.col + 1, direction)
      case Up => Position(currentPosition.row - 1, currentPosition.col, direction)
      case Down => Position(currentPosition.row + 1, currentPosition.col, direction)
    }
  }

  def findIncreasingDirection(currentPosition: Position, spiralSize: Int): Direction = {
    if (changeDirection(currentPosition, spiralSize)) {
      currentPosition.direction.next
    } else {
      currentPosition.direction
    }
  }

  def changeDirection(currentPosition: Position, spiralSize: Int): Boolean = {
    currentPosition.direction match {
      case Left | Right => currentPosition.col + currentPosition.row == spiralSize - 1
      case Down => currentPosition.col == currentPosition.row
      case Up => currentPosition.col == currentPosition.row - 1
    }
  }
}
