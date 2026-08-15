package output

import image.Image
import image.pixel.ASCIIPixel

/** Definuje metodu pro zápis/výstup */
trait IOutputTarget {
  def write(img: Image[ASCIIPixel]): Unit
}
