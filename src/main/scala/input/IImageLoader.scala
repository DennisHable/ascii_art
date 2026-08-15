package input

import image.Image
import image.pixel.IPixel

/**
 * Společné rozhraní (trait) pro načítání obrázků z libovolného zdroje
 */
trait IImageLoader[T <: IPixel] {
  def load(): Image[T]
}