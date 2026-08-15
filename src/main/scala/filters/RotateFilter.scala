package filters

import image.pixel.{ASCIIPixel, IPixel}
import image.Image

/**
 * Rotace obrázku o násobky 90°
 * @param angle násobek 90°
 */
class RotateFilter(angle: Int) extends IFilter[ASCIIPixel] {
  require(angle % 90 == 0) // není násobek 90°

  override def apply(img: Image[ASCIIPixel]): Image[ASCIIPixel] = {
    val times = ((angle % 360) + 360) % 360 / 90 // kolikrát se bude rotovat

    // jedna rotace "doleva"
    def rotateOnce(a: Image[ASCIIPixel]): Image[ASCIIPixel] = {
      val rotated = Vector.tabulate(a.height, a.width) { (y, x) =>
        a.pixels(x)(a.height - 1 - y)
      }
      Image[ASCIIPixel](a.height, a.width, rotated)
    }

    // opakuje se "times" krát
    (0 until times).foldLeft(img)((acc, _) => rotateOnce(acc))
  }
}
