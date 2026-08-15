package filters

import image.pixel.{GrayScalePixel, IPixel}
import image.Image

/**
 * Invertuje jas pixelu.
 */
class InvertFilter extends IFilter[GrayScalePixel] {
  /**
   * Mapuje 0 -> 255, ..., 255 -> 0
   * @param img - vstupní obrázek pro aplikaci filteru
   * @return obrázek po mapování
   */
  override def apply(img: Image[GrayScalePixel]): Image[GrayScalePixel] =
    img.copy(pixels = img.pixels.map(_.map(v => GrayScalePixel(255 - v.grayScale))))
}