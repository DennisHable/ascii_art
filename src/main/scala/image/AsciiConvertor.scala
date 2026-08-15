package image

import ascii.ITable
import image.pixel.{ASCIIPixel, GrayScalePixel, IPixel, RGBPixel}
import image.Image

/**
 * Převádí Image na gray scale a Image[ASCIIPixel]
 */
object AsciiConvertor {
  /** Výpočet stupně šedi na základě hodnot r,g,b daného pixelu */
  def toGray(p: RGBPixel): Int =
    (0.3*p.red + 0.59*p.green + 0.11*p.blue).toInt
  
  def convertToGrayScale(img: Image[RGBPixel]): Image[GrayScalePixel] = {
    /**
     * Vytvoření matice gray scale pixelů
     */
    val chars = Vector.tabulate(img.width, img.height) { (x, y) =>
      GrayScalePixel(toGray(img.getPixel(x, y)))
    }

    // vytvoření gray scale obrázku
    Image[GrayScalePixel](img.width, img.height, chars)
  }
  
  def convertToAsciiImage(img: Image[GrayScalePixel], table: ITable): Image[ASCIIPixel] = {
    /**
     * Vytvoření matice ASCII Pixelů
     */
    val chars = Vector.tabulate(img.width, img.height) { (x, y) =>
      table.charFor(img.getPixel(x, y))
    }

    // vytvoření ASCII obrázku
    Image[ASCIIPixel](img.width, img.height, chars)
  }
}