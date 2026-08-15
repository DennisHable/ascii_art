package image.pixel

case class GrayScalePixel private (grayScale: Int) extends IPixel

object GrayScalePixel {
  /*
    Pro vytváření instancí se využije tato metoda,
    která bude volat privátní kontruktor GrayScalePixel
   */
  def apply(grayScale: Int): GrayScalePixel = {
    // validní grayScale pixel má hodnotu v rozsahu od 0 do 255 (obě hodnoty včetně)
    def isValid(value: Int): Boolean = value >= 0 && value <= 255

    // Pokud je hodnota grayScale nižší nebo vyšší, tak se vyhodí výjimka
    if (!isValid(grayScale)) {
      throw new IllegalArgumentException(s"Hodnota grayScale = ($grayScale), ale hodnota musí být v rozsahu <0-255>.")
    }

    // volání privátního konstruktoru, pokud prošla validace
    new GrayScalePixel(grayScale)
  }
}
