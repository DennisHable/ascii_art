package image

import image.pixel.RGBPixel
import org.scalatest.funsuite.AnyFunSuite

import scala.util.Random

class ImageTest extends AnyFunSuite {
  test("Image - validity check #1") {
    val width = 10;
    val height = 10;
    val seed = 42;
    val rnd = new Random(seed);
    val pixels = Vector.tabulate(width, height) { (_, _) =>
      RGBPixel(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    val img = Image[RGBPixel](width, height, pixels);

    val rnd2 = new Random(seed);
    for(x <- 0 until width) {
      for (y <- 0 until height) {
        val rgbPixel = img.getPixel(x, y);
        assert(rgbPixel.red == pixels(x)(y).red &&
          rgbPixel.green == pixels(x)(y).green &&
          rgbPixel.blue == pixels(x)(y).blue);
      }
    }
  }

  test("Image - validity check #2") {
    val width = 20;
    val height = 20;
    val seed = 42;
    val rnd = new Random(seed);
    val pixels = Vector.tabulate(width, height) { (_, _) =>
      RGBPixel(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    val img = Image[RGBPixel](width / 2, height / 3, pixels);

    for (x <- 0 until width / 2) {
      for (y <- 0 until height / 3) {
        val rgbPixel = img.getPixel(x, y);
        assert(rgbPixel.red == pixels(x)(y).red &&
               rgbPixel.green == pixels(x)(y).green &&
               rgbPixel.blue == pixels(x)(y).blue);
      }
    }
  }

  test("Image - invalid tests check #1") {
    val width = 5;
    val height = 5;
    val seed = 42;
    val rnd = new Random(seed);
    val pixels = Vector.tabulate(width, height) { (_, _) =>
      RGBPixel(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    assertThrows[IllegalArgumentException](Image[RGBPixel](width + 1, height, pixels))
  }

  test("Image - invalid tests check #2") {
    val width = 5;
    val height = 5;
    val seed = 42;
    val rnd = new Random(seed);
    val pixels = Vector.tabulate(width, height) { (_, _) =>
      RGBPixel(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    assertThrows[IllegalArgumentException](Image[RGBPixel](width, height + 1, pixels))
  }

  test("Image - empty") {
    val width = 0;
    val height = 0;

    val img = Image[RGBPixel](width, height, Vector());

    assert(img.width == width);
    assert(img.height == height);

    assert(img.pixels.length == width)
  }
}
