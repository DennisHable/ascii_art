package image.pixel

/**
 * Reprezentuje jeden RGB pixel
 * Veřejné immutable (díky case class syntaxy) atributy
 *
 * @param red - červená barva
 * @param green - zelená barva
 * @param blue - modrá barva
 */
case class RGBPixel private (red: Int, green: Int, blue: Int) extends IPixel

/**
 * Validace hodnot jednotlivých pixelů
 */
object RGBPixel {
  /*
    Pro vytváření instancí se využije tato metoda,
    která bude volat privátní kontruktor RGBPixel
   */
  def apply(red: Int, green: Int, blue: Int): RGBPixel = {
    // validní rgb pixel má každou hodnotu v rozsahu od 0 do 255 (obě hodnoty včetně)
    def isValid(value: Int): Boolean = value >= 0 && value <= 255

    // Pokud je hodnota dané složky nižší nebo vyšší, tak se vyhodí výjimka
    if (!isValid(red)) {
      throw new IllegalArgumentException(s"Hodnota red = ($red), ale hodnota musí být v rozsahu <0-255>.")
    }
    if (!isValid(green)) {
      throw new IllegalArgumentException(s"Hodnota green = ($green), ale hodnota musí být v rozsahu <0-255>.")
    }
    if (!isValid(blue)) {
      throw new IllegalArgumentException(s"Hodnota blue = ($blue), ale hodnota musí být v rozsahu <0-255>.")
    }

    // volání privátního konstruktoru, pokud prošla validace
    new RGBPixel(red, green, blue)
  }
}