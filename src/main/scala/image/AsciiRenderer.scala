package image

import image.pixel.ASCIIPixel

object AsciiRenderer {
  /**
   * Převede obrázek na String
   *
   * @return Stringová reprezentace obrázku
   */
  def render(img: Image[ASCIIPixel]): String = {
    val strBuilder = new StringBuilder();
    for (x <- 0 until img.width) {
      for (y <- 0 until img.height) {
        strBuilder.append(img.getPixel(x, y).char);
      }
      strBuilder.append("\n");
    }
    strBuilder.toString();
  }
}
