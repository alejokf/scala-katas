package clockwisespiral

case class Position(row: Int, col: Int, direction: Direction)

sealed trait Direction {
  def next: Direction = {
    this match {
      case Left => Up
      case Right => Down
      case Up => Right
      case Down => Left
    }
  }
}

case object Up extends Direction

case object Down extends Direction

case object Right extends Direction

case object Left extends Direction
