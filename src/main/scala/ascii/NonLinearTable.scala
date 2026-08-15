package ascii

import image.pixel.{ASCIIPixel, GrayScalePixel}

/**
 * Příklad nelineárního převodu
 * Světlé pixely -> mezera
 * Zbytek pixelů -> {_, +, *, $, #}
 */
class NonLinearTable extends ITable {
  override def charFor(grayScalePixel: GrayScalePixel): ASCIIPixel =
    if (grayScalePixel.grayScale < 200)
      ASCIIPixel(' ') 
    else if(grayScalePixel.grayScale < 210)
      ASCIIPixel('_')
    else if(grayScalePixel.grayScale < 220)
      ASCIIPixel('+')
    else if (grayScalePixel.grayScale < 230)
      ASCIIPixel('*')
    else if (grayScalePixel.grayScale < 240)
      ASCIIPixel('$')
    else
      ASCIIPixel('#')
}