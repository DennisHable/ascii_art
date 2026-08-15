package ascii

import image.pixel.{ASCIIPixel, GrayScalePixel}

trait ITable {

  /**
   * @param grayScalePixel GrayScalePixel - hodnota od 0 do 255 (oba včetně); určuje stupeň šedi
   * @return převod stupně šedi na znak - ASCIIPixel
   */
  def charFor(grayScalePixel: GrayScalePixel): ASCIIPixel
}