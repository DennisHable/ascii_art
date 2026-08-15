package ascii

import image.pixel.{ASCIIPixel, GrayScalePixel}

/** Lineární převod
 *  Stupeň šedi na ASCII znak podle dané tabulky
 *  */
class LinearTable (chars: String) extends ITable {

  /**
   * @param grayScalePixel GrayScalePixel - hodnota od 0 do 255 (oba včetně); určuje stupeň šedi
   * @return převod stupně šedi na znak - ASCIIPixel
   */
  override def charFor(grayScalePixel: GrayScalePixel): ASCIIPixel = {
    ASCIIPixel(chars((grayScalePixel.grayScale.toDouble / 255 * (chars.length - 1)).toInt))
  }
}

