package input

import constants.Constants.{DEFAULT_HEIGHT, DEFAULT_WIDTH}
import image.Image
import image.pixel.RGBPixel
import org.scalatest.funsuite.AnyFunSuite

import scala.util.Random

class RandomImageLoaderTest extends AnyFunSuite{

  test("RandomImageLoader - validity check #1") {
    val seed = 42;
    val img1 = RandomImageLoader(seed).load();
    val rnd = new Random(seed)
    for(x <- 0 until img1.width) {
      for (y <- 0 until img1.height) {
        val r = img1.getPixel(x, y).red;
        val g = img1.getPixel(x, y).green;
        val b = img1.getPixel(x, y).blue;
        assert(r == rnd.nextInt(256) &&
               g == rnd.nextInt(256) &&
               b == rnd.nextInt(256))
      }
    }
  }

  test("RandomImageLoader - validity check #2") {
    val seed = 911;
    val img1 = RandomImageLoader(seed).load();
    val rnd = new Random(seed)
    for(x <- 0 until img1.width) {
      for (y <- 0 until img1.height) {
        val r = img1.getPixel(x, y).red;
        val g = img1.getPixel(x, y).green;
        val b = img1.getPixel(x, y).blue;
        assert(r == rnd.nextInt(256) &&
               g == rnd.nextInt(256) &&
               b == rnd.nextInt(256))
      }
    }
  }

  test("RandomImageLoader - validity check #3") {
    val seed = 42;
    val img1 = RandomImageLoader(seed).load();
    val rnd = new Random(seed)
    for(x <- 0 until img1.width) {
      for (y <- 0 until img1.height) {
        val r = img1.getPixel(x, y).red;
        val g = img1.getPixel(x, y).green;
        val b = img1.getPixel(x, y).blue;
        assert(r == rnd.nextInt(256) &&
               g == rnd.nextInt(256) &&
               b == rnd.nextInt(256))
      }
    }
  }
}
