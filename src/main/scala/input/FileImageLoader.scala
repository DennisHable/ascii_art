package input

import image.pixel.{IPixel, RGBPixel}
import image.Image

import java.io.File
import javax.imageio.ImageIO

/**
 * Načte obrázek ze souboru
 * @param path - cesta k souboru
 * */
class FileImageLoader(path: String) extends IImageLoader[RGBPixel] {
  private val supported = Set("png", "jpg", "jpeg")

  override def load(): Image[RGBPixel] = {
    // přípona souboru
    val format = path.split('.').lastOption
      .map(_.toLowerCase)
      .getOrElse("")

    if (!supported.contains(format))
      throw new IllegalArgumentException(s"Unsupported image format: .$format")

    val file = new File(path)
    if (!file.exists())
      throw new IllegalArgumentException(s"File not found: $path")


    // vrací BufferedImage - načtený obrázek nebo null
    val img = ImageIO.read(file)

    // 2d kolekce pixelů obrázku
    val pixels = Vector.tabulate(img.getHeight, img.getWidth) { (y, x) =>
      val rgb = img.getRGB(x, y)
      // Pro každou složku 8 bitů jde se postupně (red, green, blue) bit shiftem
      RGBPixel((rgb >> 16) & 0xFF,
               (rgb >> 8) & 0xFF,
               rgb & 0xFF)
    }

    Image(img.getHeight, img.getWidth, pixels)
  }
}
