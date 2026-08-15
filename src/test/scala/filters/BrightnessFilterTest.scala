package filters

import image.Image
import image.pixel.GrayScalePixel
import org.scalatest.funsuite.AnyFunSuite

import scala.util.Random

class BrightnessFilterTest extends AnyFunSuite {
  test("BrightnessFilter - validity check - negative delta") {
    val pixels = Vector(Vector(GrayScalePixel(10), GrayScalePixel(0)),
      Vector(GrayScalePixel(125), GrayScalePixel(255)));

    val img = Image[GrayScalePixel](2, 2, pixels);

    val delta = -5;

    val brightnessFilter = BrightnessFilter(delta);
    val brightnessImg = brightnessFilter.apply(img);

    assert(brightnessImg.getPixel(0, 0).grayScale == 5)
    assert(brightnessImg.getPixel(0, 1).grayScale == 0)
    assert(brightnessImg.getPixel(1, 0).grayScale == 120)
    assert(brightnessImg.getPixel(1, 1).grayScale == 250)
  }

  test("BrightnessFilter - validity check - positive delta") {
    val pixels = Vector(Vector(GrayScalePixel(10), GrayScalePixel(0)),
      Vector(GrayScalePixel(125), GrayScalePixel(255)));

    val img = Image[GrayScalePixel](2, 2, pixels);

    val delta = 15;

    val brightnessFilter = BrightnessFilter(delta);
    val brightnessImg = brightnessFilter.apply(img);

    assert(brightnessImg.getPixel(0, 0).grayScale == 25)
    assert(brightnessImg.getPixel(0, 1).grayScale == 15)
    assert(brightnessImg.getPixel(1, 0).grayScale == 140)
    assert(brightnessImg.getPixel(1, 1).grayScale == 255)
  }

  test("BrightnessFilter - validity check - delta is zero") {
    val pixels = Vector(Vector(GrayScalePixel(10), GrayScalePixel(0)),
      Vector(GrayScalePixel(125), GrayScalePixel(255)));

    val img = Image[GrayScalePixel](2, 2, pixels);

    val delta = 0;

    val brightnessFilter = BrightnessFilter(delta);
    val brightnessImg = brightnessFilter.apply(img);

    assert(brightnessImg.getPixel(0, 0).grayScale == 10)
    assert(brightnessImg.getPixel(0, 1).grayScale == 0)
    assert(brightnessImg.getPixel(1, 0).grayScale == 125)
    assert(brightnessImg.getPixel(1, 1).grayScale == 255)
  }

  test("BrightnessFilter - validity check - two brightness filters") {
    val pixels = Vector(Vector(GrayScalePixel(10), GrayScalePixel(0)),
      Vector(GrayScalePixel(125), GrayScalePixel(255)));

    val img = Image[GrayScalePixel](2, 2, pixels);

    val delta = 10;

    val brightnessFilter1 = BrightnessFilter(delta);
    val brightnessFilter2 = BrightnessFilter(-delta);
    val brightnessImg1 = brightnessFilter1.apply(img);
    val brightnessImg2 = brightnessFilter2.apply(brightnessImg1);

    assert(brightnessImg1.getPixel(0, 0).grayScale == 20)
    assert(brightnessImg1.getPixel(0, 1).grayScale == 10)
    assert(brightnessImg1.getPixel(1, 0).grayScale == 135)
    assert(brightnessImg1.getPixel(1, 1).grayScale == 255)

    assert(brightnessImg2.getPixel(0, 0).grayScale == 10)
    assert(brightnessImg2.getPixel(0, 1).grayScale == 0)
    assert(brightnessImg2.getPixel(1, 0).grayScale == 125)
    assert(brightnessImg2.getPixel(1, 1).grayScale == 245)
  }

  test("BrightnessFilter - validity check") {
    val width = 20;
    val height = 17;
    val seed = 42;
    val rnd = new Random(seed);

    val pixels = Vector.tabulate(width, height) { (_, _) =>
      GrayScalePixel(rnd.nextInt(256));
    }

    val img = Image[GrayScalePixel](width, height, pixels);

    val delta = rnd.nextInt(40) - 20;

    val brightnessFilter = BrightnessFilter(delta);
    val brightnessImg = brightnessFilter.apply(img);

    for (x <- 0 until img.width) {
      for (y <- 0 until img.height) {
        val gray = img.getPixel(x, y).grayScale;
        assert((gray + delta).max(0).min(255) == brightnessImg.getPixel(x, y).grayScale)
      }
    }
  }
}
