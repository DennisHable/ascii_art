package output

import image.{AsciiRenderer, Image}
import image.pixel.ASCIIPixel

/**
 * Výstup na konzoli
 */
class ConsoleOutput extends IOutputTarget {
  override def write(img: Image[ASCIIPixel]): Unit =
    println(AsciiRenderer.render(img))
}
