package filters

import image.Image
import image.pixel.IPixel

trait IFilter[T <: IPixel] {
  def apply(img: Image[T]): Image[T]
}
