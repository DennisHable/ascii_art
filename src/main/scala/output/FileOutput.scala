package output

import image.{AsciiRenderer, Image}
import image.pixel.ASCIIPixel

import java.io.PrintWriter

/**
 * zápis do souboru
 * @param path cesta k souboru
 */
class FileOutput(path: String) extends IOutputTarget {
  override def write(img: Image[ASCIIPixel]): Unit = {
    val pw = new PrintWriter(path)
    try pw.write(AsciiRenderer.render(img))
    finally pw.close()
  }
}
