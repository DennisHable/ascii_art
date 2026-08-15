package filters

import filters.Axis.{X, Y}
import image.Image
import image.pixel.ASCIIPixel
import org.scalatest.funsuite.AnyFunSuite

import scala.util.Random

class FlipFilterTest extends AnyFunSuite {
  test("FlipFilter - validity check - x axis") {
    val pixels = Vector(Vector(ASCIIPixel('A'), ASCIIPixel('B')),
      Vector(ASCIIPixel('C'), ASCIIPixel('D')));

    val img = Image[ASCIIPixel](2, 2, pixels);

    val xFlipFilter = FlipFilter(Axis.X);
    val flippedImg = xFlipFilter.apply(img);

    assert(flippedImg.getPixel(0, 0).char == 'C')
    assert(flippedImg.getPixel(0, 1).char == 'D')
    assert(flippedImg.getPixel(1, 0).char == 'A')
    assert(flippedImg.getPixel(1, 1).char == 'B')

  }

  test("FlipFilter - validity check - y axis") {
    val pixels = Vector(Vector(ASCIIPixel('A'), ASCIIPixel('B')),
      Vector(ASCIIPixel('C'), ASCIIPixel('D')));

    val img = Image[ASCIIPixel](2, 2, pixels);

    val xFlipFilter = FlipFilter(Axis.Y);
    val flippedImg = xFlipFilter.apply(img);

    assert(flippedImg.getPixel(0, 0).char == 'B')
    assert(flippedImg.getPixel(0, 1).char == 'A')
    assert(flippedImg.getPixel(1, 0).char == 'D')
    assert(flippedImg.getPixel(1, 1).char == 'C')
  }

  test("FlipFilter - validity check - two flips") {
    val pixels = Vector(Vector(ASCIIPixel('A'), ASCIIPixel('B')),
      Vector(ASCIIPixel('C'), ASCIIPixel('D')));

    val img = Image[ASCIIPixel](2, 2, pixels);

    val xFlipFilter1 = FlipFilter(Axis.Y);
    val xFlipFilter2 = FlipFilter(Axis.Y);
    val flippedImg1 = xFlipFilter1.apply(img);
    val flippedImg2 = xFlipFilter2.apply(flippedImg1);

    assert(flippedImg1.getPixel(0, 0).char == 'B')
    assert(flippedImg1.getPixel(0, 1).char == 'A')
    assert(flippedImg1.getPixel(1, 0).char == 'D')
    assert(flippedImg1.getPixel(1, 1).char == 'C')

    assert(flippedImg2.getPixel(0, 0).char == 'A')
    assert(flippedImg2.getPixel(0, 1).char == 'B')
    assert(flippedImg2.getPixel(1, 0).char == 'C')
    assert(flippedImg2.getPixel(1, 1).char == 'D')
  }

  test("FlipFilter - validity check - double flip") {
    val pixels = Vector(Vector(ASCIIPixel('A'), ASCIIPixel('B')),
      Vector(ASCIIPixel('C'), ASCIIPixel('D')));

    val img = Image[ASCIIPixel](2, 2, pixels);

    val xFlipFilter1 = FlipFilter(Axis.Y);
    val xFlipFilter2 = FlipFilter(Axis.X);
    val flippedImg1 = xFlipFilter1.apply(img);
    val flippedImg2 = xFlipFilter2.apply(flippedImg1);

    assert(flippedImg1.getPixel(0, 0).char == 'B')
    assert(flippedImg1.getPixel(0, 1).char == 'A')
    assert(flippedImg1.getPixel(1, 0).char == 'D')
    assert(flippedImg1.getPixel(1, 1).char == 'C')

    assert(flippedImg2.getPixel(0, 0).char == 'D')
    assert(flippedImg2.getPixel(0, 1).char == 'C')
    assert(flippedImg2.getPixel(1, 0).char == 'B')
    assert(flippedImg2.getPixel(1, 1).char == 'A')
  }


  test("FlipFilter - validity check") {
    val width = 9;
    val height = 17;
    val seed = 42;
    val rnd = new Random(seed);
    val pixels = Vector.tabulate(width, height) { (_, _) =>
      ASCIIPixel((rnd.nextInt(95) + 32).toChar);
    }

    val img = Image[ASCIIPixel](width, height, pixels);

    val xFlipFilter = FlipFilter(Axis.Y);
    val flippedImg = xFlipFilter.apply(img);

    for (x <- 0 until img.width) {
      for (y <- 0 until img.height) {
        assert(flippedImg.getPixel(x, y) == img.getPixel(x, img.height - y - 1))
      }
    }

  }
}
