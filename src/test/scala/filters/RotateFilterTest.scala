package filters

import image.Image
import image.pixel.ASCIIPixel
import org.scalatest.funsuite.AnyFunSuite

class RotateFilterTest extends AnyFunSuite {
  test("RotateFilter - validity check - positive angle") {
    val pixels = Vector(Vector(ASCIIPixel('A'), ASCIIPixel('B')),
      Vector(ASCIIPixel('C'), ASCIIPixel('D')));

    val img = Image[ASCIIPixel](2, 2, pixels);

    val angle = 90;

    val rotateFilter = RotateFilter(angle);
    val rotatedImg = rotateFilter.apply(img);

    assert(rotatedImg.getPixel(0, 0).char == 'B')
    assert(rotatedImg.getPixel(0, 1).char == 'D')
    assert(rotatedImg.getPixel(1, 0).char == 'A')
    assert(rotatedImg.getPixel(1, 1).char == 'C')
  }

  test("RotateFilter - validity check - positive angle 2") {
    val pixels = Vector(Vector(ASCIIPixel('A'), ASCIIPixel('B')),
      Vector(ASCIIPixel('C'), ASCIIPixel('D')));

    val img = Image[ASCIIPixel](2, 2, pixels);

    val angle = 900;

    val rotateFilter = RotateFilter(angle);
    val rotatedImg = rotateFilter.apply(img);

    assert(rotatedImg.getPixel(0, 0).char == 'D')
    assert(rotatedImg.getPixel(0, 1).char == 'C')
    assert(rotatedImg.getPixel(1, 0).char == 'B')
    assert(rotatedImg.getPixel(1, 1).char == 'A')
  }

  test("RotateFilter - validity check - negative angle") {
    val pixels = Vector(Vector(ASCIIPixel('A'), ASCIIPixel('B')),
      Vector(ASCIIPixel('C'), ASCIIPixel('D')));

    val img = Image[ASCIIPixel](2, 2, pixels);

    val angle = -90;

    val rotateFilter = RotateFilter(angle);
    val rotatedImg = rotateFilter.apply(img);

    assert(rotatedImg.getPixel(0, 0).char == 'C')
    assert(rotatedImg.getPixel(0, 1).char == 'A')
    assert(rotatedImg.getPixel(1, 0).char == 'D')
    assert(rotatedImg.getPixel(1, 1).char == 'B')
  }


  test("RotateFilter - validity check - two rotate filter") {
    val pixels = Vector(Vector(ASCIIPixel('A'), ASCIIPixel('B')),
      Vector(ASCIIPixel('C'), ASCIIPixel('D')));

    val img = Image[ASCIIPixel](2, 2, pixels);

    val angle = 90;

    val rotateFilter1 = RotateFilter(angle);
    val rotateFilter2 = RotateFilter(-angle);
    val rotatedImg1 = rotateFilter1.apply(img);
    val rotatedImg2 = rotateFilter2.apply(rotatedImg1);

    assert(rotatedImg1.getPixel(0, 0).char == 'B')
    assert(rotatedImg1.getPixel(0, 1).char == 'D')
    assert(rotatedImg1.getPixel(1, 0).char == 'A')
    assert(rotatedImg1.getPixel(1, 1).char == 'C')

    assert(rotatedImg2.getPixel(0, 0).char == 'A')
    assert(rotatedImg2.getPixel(0, 1).char == 'B')
    assert(rotatedImg2.getPixel(1, 0).char == 'C')
    assert(rotatedImg2.getPixel(1, 1).char == 'D')
  }

  test("RotateFilter - validity check - double rotate filer") {
    val pixels = Vector(Vector(ASCIIPixel('A'), ASCIIPixel('B')),
      Vector(ASCIIPixel('C'), ASCIIPixel('D')));

    val img = Image[ASCIIPixel](2, 2, pixels);

    val angle = 90;

    val rotateFilter1 = RotateFilter(angle);
    val rotateFilter2 = RotateFilter(angle);
    val rotatedImg1 = rotateFilter1.apply(img);
    val rotatedImg2 = rotateFilter2.apply(rotatedImg1);

    assert(rotatedImg1.getPixel(0, 0).char == 'B')
    assert(rotatedImg1.getPixel(0, 1).char == 'D')
    assert(rotatedImg1.getPixel(1, 0).char == 'A')
    assert(rotatedImg1.getPixel(1, 1).char == 'C')


    assert(rotatedImg2.getPixel(0, 0).char == 'D')
    assert(rotatedImg2.getPixel(0, 1).char == 'C')
    assert(rotatedImg2.getPixel(1, 0).char == 'B')
    assert(rotatedImg2.getPixel(1, 1).char == 'A')
  }


}
