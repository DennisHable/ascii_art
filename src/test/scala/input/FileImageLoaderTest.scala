package input

import org.scalatest.funsuite.AnyFunSuite

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import scala.util.Random

class FileImageLoaderTest extends AnyFunSuite {
  test("FileImageLoader - load image") {
    val width = 7
    val height = 9
    val seed = 42;
    // vytvoření "náhodného" obrázku
    val img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
    val rnd = new Random(seed);
    for (x <- 0 until width) {
      for (y <- 0 until height) {
        img.setRGB(x, y, new Color(rnd.nextInt(256),
          rnd.nextInt(256),
          rnd.nextInt(256)).getRGB)
      }
    }

    // uložení do souboru; png je bezztrátové
    val file = File.createTempFile("test_img1", ".png")
    ImageIO.write(img, "png", file)

    // načtení
    val rgbImg = FileImageLoader(file.getAbsolutePath).load();

    // validace rozměrů; width a height mám prohozené
    assert(rgbImg.width == height)
    assert(rgbImg.height == width)

    // kontrola jednotlivých pixelů
    for (x <- 0 until rgbImg.width) {
      for (y <- 0 until rgbImg.height) {
        val color = img.getRGB(y, x);
        assert(rgbImg.getPixel(x, y).red == ((color >> 16) & 0xff) &&
               rgbImg.getPixel(x, y).green == ((color >> 8) & 0xff) &&
               rgbImg.getPixel(x, y).blue == (color & 0xff))
      }
    }

  }
}
