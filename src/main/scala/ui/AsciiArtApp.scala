package ui

import image.{AsciiConvertor, Image}
import image.pixel.{ASCIIPixel, GrayScalePixel}
import ui.args.context.Context

object AsciiArtApp {

  def run(ctx: Context): Unit = {

    // načtení obrázku a převední a gray scale
    val grayInitial: Image[GrayScalePixel] =
      AsciiConvertor.convertToGrayScale(ctx.imageSource.load())

    // aplikace gray scale filterů
    val grayProcessed: Image[GrayScalePixel] =
      ctx.grayOps.foldLeft(grayInitial) { (img, op) =>
        op.apply(img)
      }

    // převod na ascii obrázek
    val asciiInitial: Image[ASCIIPixel] =
      AsciiConvertor.convertToAsciiImage(grayProcessed, ctx.table)

    // aplikace ascii filterů
    val asciiProcessed: Image[ASCIIPixel] =
      ctx.asciiOps.foldLeft(asciiInitial) { (img, op) =>
        op.apply(img)
      }

    // výstup
    ctx.outputs.foreach(out => out(asciiProcessed))
  }
}