package image.pixel

/**
 * Reprezentuje jeden ASCII pixel
 * Veřejné immutable (díky case class syntaxy) atributy
 *
 * @param char - 1 ASCII znak
 */
case class ASCIIPixel private (char: Char) extends IPixel

/**
 * Validace hodnot jednotlivých pixelů
 */
object ASCIIPixel {
  /*
    Pro vytváření instancí se využije tato metoda,
    která bude volat privátní kontruktor ASCIIPixel
   */
  def apply(char: Char): ASCIIPixel = {
    // validní ascii pixel má hodnotu v rozsahu od 32 do 126 (obě hodnoty včetně) - tisknutelné hodnoty
    def isValid(value: Int): Boolean = value >= 32 && value <= 126

    // Pokud je hodnota dané složky nižší nebo vyšší, tak se vyhodí výjimka
    if (!isValid(char)) {
      throw new IllegalArgumentException(s"Hodnota char = ($char), ale hodnota musí být v rozsahu <32-126>.")
    }

    // volání privátního konstruktoru, pokud prošla validace
    new ASCIIPixel(char)
  }
}