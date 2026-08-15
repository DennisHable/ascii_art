package filters

import filters.Axis.{X, Y}
import image.pixel.{ASCIIPixel, IPixel}
import image.Image

/**
 * Převrátí obrázek podle osy:
 *  x = horizontální převrácení (nahoře/dole)
 *  y = vertikální převrácení (vlevo/vpravo)
 */
class FlipFilter(axis: Axis) extends IFilter[ASCIIPixel]{
  override def apply(img: Image[ASCIIPixel]): Image[ASCIIPixel] = axis match {
    case X => img.copy(pixels = img.pixels.reverse)
    case Y => img.copy(pixels = img.pixels.map(_.reverse))
  }
}
