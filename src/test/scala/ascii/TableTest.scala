package ascii

import constants.Constants.{CHARS_LINEAR_TABLE_LARGE, CHARS_LINEAR_TABLE_SMALL}
import image.pixel.GrayScalePixel
import org.scalatest.funsuite.AnyFunSuite

class TableTest extends AnyFunSuite {
  test("LinearTable - validity check") {
    val tbl = LinearTable(CHARS_LINEAR_TABLE_SMALL);
    assert(tbl.charFor(GrayScalePixel(0)).char == ' ');
    assert(tbl.charFor(GrayScalePixel(255)).char == '@');
    assert(tbl.charFor(GrayScalePixel(10)).char == ' ');
    assert(tbl.charFor(GrayScalePixel(29)).char == '.');

    val tbl2 = LinearTable(CHARS_LINEAR_TABLE_LARGE);
    assert(tbl2.charFor(GrayScalePixel(0)).char == ' ');
    assert(tbl2.charFor(GrayScalePixel(255)).char == '#');
  }

  test("NonLinearTable - validity check") {
    val tbl = NonLinearTable();
    assert(tbl.charFor(GrayScalePixel(0)).char == ' ');
    assert(tbl.charFor(GrayScalePixel(10)).char == ' ');
    assert(tbl.charFor(GrayScalePixel(30)).char == ' ');
    assert(tbl.charFor(GrayScalePixel(100)).char == ' ');
    assert(tbl.charFor(GrayScalePixel(199)).char == ' ');
    assert(tbl.charFor(GrayScalePixel(200)).char == '_');
    assert(tbl.charFor(GrayScalePixel(205)).char == '_');
    assert(tbl.charFor(GrayScalePixel(209)).char == '_');
    assert(tbl.charFor(GrayScalePixel(210)).char == '+');
    assert(tbl.charFor(GrayScalePixel(217)).char == '+');
    assert(tbl.charFor(GrayScalePixel(219)).char == '+');
    assert(tbl.charFor(GrayScalePixel(220)).char == '*');
    assert(tbl.charFor(GrayScalePixel(229)).char == '*');
    assert(tbl.charFor(GrayScalePixel(230)).char == '$');
    assert(tbl.charFor(GrayScalePixel(239)).char == '$');
    assert(tbl.charFor(GrayScalePixel(240)).char == '#');
    assert(tbl.charFor(GrayScalePixel(242)).char == '#');
    assert(tbl.charFor(GrayScalePixel(250)).char == '#');
    assert(tbl.charFor(GrayScalePixel(255)).char == '#');
  }
}
