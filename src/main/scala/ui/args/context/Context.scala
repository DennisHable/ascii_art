package ui.args.context

import ascii.ITable
import filters.IFilter
import image.*
import image.pixel.{ASCIIPixel, GrayScalePixel, RGBPixel}
import input.IImageLoader

/**
 * Kontext pro parser
 * @param imageSource zdroj obrázku
 * @param grayOps filtry na GrayScale obrázek
 * @param asciiOps filtry na ASCII obrázek
 * @param table tabulka pro převod gray scale na ASCII
 * @param outputs kam zapsat/vypsat výstupní obrázek
 */
case class Context(imageSource: IImageLoader[RGBPixel],
                   grayOps: Vector[IFilter[GrayScalePixel]],
                   asciiOps: Vector[IFilter[ASCIIPixel]],
                   table: ITable,
                   outputs: Vector[Image[ASCIIPixel] => Unit]) {}

