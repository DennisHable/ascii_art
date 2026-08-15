package filters

import image.Image
import image.pixel.GrayScalePixel
import org.scalatest.funsuite.AnyFunSuite

import scala.util.Random

class InvertFilterTest extends AnyFunSuite {
  test("InvertFilter - validity check #1") {
    val pixels = Vector(Vector(GrayScalePixel(10), GrayScalePixel(0)),
                        Vector(GrayScalePixel(125), GrayScalePixel(255)));

    val img = Image[GrayScalePixel](2, 2, pixels);

    val invertFilter = InvertFilter();
    val invertedImg = invertFilter.apply(img);

    assert((255 - img.getPixel(0, 0).grayScale) ==
      invertedImg.getPixel(0, 0).grayScale)
    assert((255 - img.getPixel(0, 1).grayScale) ==
      invertedImg.getPixel(0, 1).grayScale)
    assert((255 - img.getPixel(1, 0).grayScale) ==
      invertedImg.getPixel(1, 0).grayScale)
    assert((255 - img.getPixel(1, 1).grayScale) ==
      invertedImg.getPixel(1, 1).grayScale)
  }

  test("InvertFilter - validity check #2 - two invert filters") {
    val pixels = Vector(Vector(GrayScalePixel(10), GrayScalePixel(0)),
      Vector(GrayScalePixel(125), GrayScalePixel(255)));

    val img = Image[GrayScalePixel](2, 2, pixels);

    val invertFilter1 = InvertFilter();
    val invertedImg1 = invertFilter1.apply(img);

    val invertFilter2 = InvertFilter();
    val invertedImg2 = invertFilter2.apply(invertedImg1);

    assert(invertedImg1.getPixel(0, 0).grayScale == 245)
    assert(invertedImg1.getPixel(0, 1).grayScale == 255)
    assert(invertedImg1.getPixel(1, 0).grayScale == 130)
    assert(invertedImg1.getPixel(1, 1).grayScale == 0)

    assert(invertedImg2.getPixel(0, 0).grayScale == 10)
    assert(invertedImg2.getPixel(0, 1).grayScale == 0)
    assert(invertedImg2.getPixel(1, 0).grayScale == 125)
    assert(invertedImg2.getPixel(1, 1).grayScale == 255)
  }

  test("InvertFilter - validity check #3") {
    val width = 20;
    val height = 17;
    val seed = 42;
    val rnd = new Random(seed);
    val pixels = Vector.tabulate(width, height) { (_, _) =>
      GrayScalePixel(rnd.nextInt(256));
    }

    val img = Image[GrayScalePixel](width, height, pixels);

    val invertFilter = InvertFilter();
    val invertedImg = invertFilter.apply(img);

    for (x <- 0 until img.width) {
      for (y <- 0 until img.height) {
        val gray = img.getPixel(x, y).grayScale;
        assert((255 - gray) == invertedImg.getPixel(x, y).grayScale)
      }
    }
  }
}
