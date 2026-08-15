package input

import constants.Constants.{DEFAULT_HEIGHT, DEFAULT_WIDTH}
import image.Image
import image.pixel.RGBPixel

import scala.util.Random

/**
 * Deterministický generátor obrázků
 * @param seed počáteční hodnota pro generátor pseudo náhodných čísel
 */
class RandomImageLoader(seed: Int) extends IImageLoader[RGBPixel] {

  override def load(): Image[RGBPixel] = {
    val rnd = new Random(21*seed + 11) // náhodný generátor

    val width = rnd.nextInt(DEFAULT_WIDTH) + 4;
    val height = rnd.nextInt(DEFAULT_HEIGHT) + 5;

    val rnd2 = new Random(seed) // náhodný generátor pro pixely; nutný nový, se stejným seedem, kvůli testování

    // generování "náhodných" pixelů pro každou pozici
    val pixels = Vector.tabulate(width, height) { (_, _) =>
      RGBPixel(rnd2.nextInt(256), rnd2.nextInt(256), rnd2.nextInt(256))
    }

    Image(width, height, pixels)
  }
}
