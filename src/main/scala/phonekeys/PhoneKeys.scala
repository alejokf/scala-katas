package phonekeys

import scala.io.{BufferedSource, Source}

object PhoneKeys {

  val in: BufferedSource = Source.fromResource("phonekeys/words.txt")
  val words: Seq[String] = in.getLines.toList filter (word => word.forall(chr => chr.isLetter))

  // Phone keys have mnemonics assigned to them
  val mnemonics = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")

  val charCode: Map[Char, Char] =
    for {
      (digit, str) <- mnemonics
      letter <- str
    } yield letter -> digit

  def wordCode(word: String): String = {
    word.toUpperCase map charCode
  }

  /**
   * A map from digit strings to the words that represents them,
   * e.g. "5282" -> List("Java", "Kata", "Lava")
   */
  val wordsForNum: Map[String, Seq[String]] =
    words groupBy wordCode withDefaultValue Seq()

  /** Assume you are given a dictionary words as a list of words.
   * This method produces all phrases of words that can serve as mnemonics for the phone number.
   *
   * @param number the input phone number
   * @return all possible phrases for the given phone number
   */
  def encode(number: String): Set[List[String]] = {
    if (number.isEmpty) Set(List())
    else {
      for {
        split <- 1 to number.length
        word <- wordsForNum(number take split)
        rest <- encode(number drop split)
      } yield word :: rest
    }.toSet
  }

  def translate(number: String): Set[String] =
    encode(number) map (_ mkString " ")

}
