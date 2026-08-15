package image

import ascii.LinearTable
import constants.Constants.CHARS_LINEAR_TABLE_SMALL
import image.pixel.{GrayScalePixel, RGBPixel}
import org.scalatest.funsuite.AnyFunSuite

import scala.util.Random

class AsciiConvertorTest extends AnyFunSuite {
  test("AsciiConvertor - convertToGrayScale") {
    val width = 15;
    val height = 11;
    val seed = 42;
    val rnd = new Random(seed);
    val pixels = Vector.tabulate(width, height) { (_, _) =>
      RGBPixel(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    val img = Image[RGBPixel](width, height, pixels);

    val imgGrayScale = AsciiConvertor.convertToGrayScale(img);

    assert(imgGrayScale.width == img.width)
    assert(imgGrayScale.height == img.height)

    for (x <- 0 until width) {
      for (y <- 0 until height) {
        val grayPixel = AsciiConvertor.toGray(img.getPixel(x, y));
        assert(imgGrayScale.getPixel(x, y).grayScale == grayPixel);
      }
    }
  }

  test("AsciiConvertor - convertToAsciiImage") {
    val width = 15;
    val height = 11;
    val seed = 42;
    val rnd = new Random(seed);
    val pixels = Vector.tabulate(width, height) { (_, _) =>
      GrayScalePixel(rnd.nextInt(256));
    }

    val img = Image[GrayScalePixel](width, height, pixels);

    val tbl = LinearTable(CHARS_LINEAR_TABLE_SMALL);

    val imgAscii = AsciiConvertor.convertToAsciiImage(img, tbl);

    assert(imgAscii.width == img.width)
    assert(imgAscii.height == img.height)

    for (x <- 0 until width) {
      for (y <- 0 until height) {
        val asciiPixel = tbl.charFor(img.getPixel(x, y));
        assert(imgAscii.getPixel(x, y).char == asciiPixel.char);
      }
    }
  }
}
