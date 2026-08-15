package image

import image.pixel.{ASCIIPixel, RGBPixel}
import org.scalatest.funsuite.AnyFunSuite

import scala.util.Random

class AsciiRendererTest extends AnyFunSuite {
  test("AsciiRenderer - render test") {
    val width = 7;
    val height = 11;
    val seed = 42;
    val rnd = new Random(seed);
    val pixels = Vector.tabulate(width, height) { (_, _) =>
      ASCIIPixel((rnd.nextInt(95) + 32).toChar);
    }

    val img = Image[ASCIIPixel](width, height, pixels);

    val str = AsciiRenderer.render(img);

    val arr = str.split("\n");

    assert(arr.length == img.width)

    for (y <- 0 until img.width) {
      val row = arr(y)
      assert(row.length == img.height)

      for (x <- 0 until img.height) {
        assert(row.charAt(x) == img.pixels(y)(x).char)
      }
    }
  }
}
