package image.pixel

import image.pixel.{ASCIIPixel, GrayScalePixel, RGBPixel}
import org.scalatest.funsuite.AnyFunSuite

import scala.util.Random

/**
 * Testy "Pixel tříd"; vždy se testují validní a nevalidní vstupy
 */
class PixelTest extends AnyFunSuite {
  test("RGBPixel - validity check") {
    var pixel1 = RGBPixel(0, 0, 0)
    assert(pixel1.red == 0 && pixel1.green == 0 && pixel1.blue == 0)
    pixel1 = RGBPixel(255, 0, 0)
    assert(pixel1.red == 255 && pixel1.green == 0 && pixel1.blue == 0)
    pixel1 = RGBPixel(0, 255, 0)
    assert(pixel1.red == 0 && pixel1.green == 255 && pixel1.blue == 0)
    pixel1 = RGBPixel(0, 0, 255)
    assert(pixel1.red == 0 && pixel1.green == 0 && pixel1.blue == 255)
    pixel1 = RGBPixel(255, 255, 255)
    assert(pixel1.red == 255 && pixel1.green == 255 && pixel1.blue == 255)
    pixel1 = RGBPixel(42, 32, 15)
    assert(pixel1.red == 42 && pixel1.green == 32 && pixel1.blue == 15)
  }

  test("RGBPixel - invalid tests check") {
    assertThrows[IllegalArgumentException](RGBPixel(256, 0, 0))
    assertThrows[IllegalArgumentException](RGBPixel(0, 256, 0))
    assertThrows[IllegalArgumentException](RGBPixel(0, 0, 256))
    assertThrows[IllegalArgumentException](RGBPixel(-1, 0, 0))
    assertThrows[IllegalArgumentException](RGBPixel(0, -1, 0))
    assertThrows[IllegalArgumentException](RGBPixel(0, 0, -1))
    assertThrows[IllegalArgumentException](RGBPixel(10, 12, 360))
  }

  test("RGBPixel - random validity check") {
    val rnd = new Random(42);
    for(i <- 0 until 10) {
      val r = rnd.nextInt(256);
      val g = rnd.nextInt(256);
      val b = rnd.nextInt(256);
      val pixel1 = RGBPixel(r, g, b)
      assert(pixel1.red == r && pixel1.green == g && pixel1.blue == b)
    }
  }

  test("GrayScalePixel - validity check") {
    assert(GrayScalePixel(0).grayScale == 0)
    assert(GrayScalePixel(255).grayScale == 255)
    assert(GrayScalePixel(124).grayScale == 124)
    assert(GrayScalePixel(10).grayScale == 10)
  }

  test("GrayScalePixel - random validity check") {
    val rnd = new Random(42);
    for (i <- 0 until 10) {
      val gray = rnd.nextInt(256);
      val pixel1 = GrayScalePixel(gray)
      assert(pixel1.grayScale == gray)
    }
  }

  test("GrayScalePixel - invalid tests check") {
    assertThrows[IllegalArgumentException](GrayScalePixel(256))
    assertThrows[IllegalArgumentException](GrayScalePixel(-1))
    assertThrows[IllegalArgumentException](GrayScalePixel(260))
    assertThrows[IllegalArgumentException](GrayScalePixel(-60))
  }

  test("ASCIIPixel - validity check") {
    assert(ASCIIPixel(' ').char == ' ')
    assert(ASCIIPixel('A').char == 'A')
    assert(ASCIIPixel('#').char == '#')
    assert(ASCIIPixel('\"').char == '\"')
  }

  test("ASCIIPixel - random validity check") {
    val rnd = new Random(42);
    for (i <- 0 until 10) {
      val ascii = (rnd.nextInt(95) + 32).toChar;
      val pixel1 = ASCIIPixel(ascii)
      assert(pixel1.char == ascii)
    }
  }

  test("ASCIIPixel - invalid tests check") {
    assertThrows[IllegalArgumentException](ASCIIPixel('\n'))
    assertThrows[IllegalArgumentException](ASCIIPixel('\u0000'))
    assertThrows[IllegalArgumentException](ASCIIPixel('\u0008'))
    assertThrows[IllegalArgumentException](ASCIIPixel('\u00ff'))
  }

}
