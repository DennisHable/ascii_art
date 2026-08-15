package image

import image.pixel.IPixel

/**
 * Reprezentuje obrázek; využívám genericitu - Pixel nebo libovolný typ který dědí z Pixel
 *
 * @param width chápáno jako počet řádků obrázku (přípaadně lze uvažovat jen část z obrázku, ale vždy začínající v bodě (0,0))
 * @param height chápáno jako počet sloupců obrázku (přípaadně lze uvažovat jen část z obrázku, ale vždy začínající v bodě (0,0))
 * @param pixels 2d matice, samotný obrázek jednotlivých pixelů, privátní a immutable
 */
case class Image[T <: IPixel](width: Int, height: Int, pixels: Seq[Seq[T]]) {

  require(pixels.length >= width)
  require(pixels.forall(_.length >= height))

  /**
   * @param x pozice v obrázku - řádky
   * @param y pozice v obrázku - sloupce
   * @return Vrací pixel na pozici (x, y)
   */
  def getPixel(x: Int, y: Int): T = pixels(x)(y)
}
