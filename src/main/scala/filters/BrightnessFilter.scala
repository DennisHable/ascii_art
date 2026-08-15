package filters

import image.pixel.{GrayScalePixel, IPixel}
import image.Image

/**
 * Změní jas pixelu o delta (daná konstanta).
 */
class BrightnessFilter(delta: Int) extends IFilter[GrayScalePixel]{
  /**
   * Ke každé hodnotě je přidána delta a
   * současně je oříznuta na hodnoty z intervalu/množiny <0, 255> (pouze přirozená čísla).
   * @param img - obrázek pro aplikaci filteru
   * @return modifikovaný obrázek
   */
  override def apply(img: Image[GrayScalePixel]): Image[GrayScalePixel] = {
    img.copy(pixels = img.pixels.map(_.map(v =>
      GrayScalePixel((v.grayScale + delta).max(0).min(255)))))
  }
}
