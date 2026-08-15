package ui.args.context

import ascii.{AsciiTables, ITable, LinearTable}
import filters.IFilter
import image.*
import image.pixel.{ASCIIPixel, GrayScalePixel, RGBPixel}
import input.IImageLoader
import output.IOutputTarget
import ui.args.context.Context

/**
 * Builder pro vytváření kontextu pro parser
 */
class ContextBuilder {
    // zdroj obrázku
    private var imageSource: Option[IImageLoader[RGBPixel]] = None
    // Podle jaké tabulky se bude dělat transformace z grayScale na ASCII znaky
    private var table:  Option[ITable] = None
    // filtry aplikované na grayScale obrázek
    private val grayOps = Vector.newBuilder[IFilter[GrayScalePixel]]
    // filtry aplikované na ascii obrázek
    private val asciiOps = Vector.newBuilder[IFilter[ASCIIPixel]]
    // požadované výstupy/zápisy
    private val outputs = Vector.newBuilder[Image[ASCIIPixel] => Unit]

    // nastavování zdroje obrázku, přidávání filtrů, výstupů

    def setImageSource(src: IImageLoader[RGBPixel]): Unit = {
      if(imageSource.isDefined)
        throw new IllegalArgumentException("Only one --image argument allowed!")
      imageSource = Some(src)
    }

    def addGrayOp(op: IFilter[GrayScalePixel]): Unit =
      grayOps += op

    def addAsciiOp(op: IFilter[ASCIIPixel]): Unit =
      asciiOps += op

    def setTable(t: ITable): Unit = {
      if(table.isDefined)
        throw new IllegalArgumentException("Only one ASCII table can be specified");
      table = Some(t)
    }

    def addOutput(out: IOutputTarget): Unit =
      outputs += (img => out.write(img))

    // konstukce Contextu pro pozdější zpracování obrázku, provádí se validace,
    // pokud by zadán jen jeden zdroj a alespoň jeden výstup
    def build(): Context = {
      if (imageSource.isEmpty)
        throw new IllegalArgumentException("Exactly one image source must be specified!")

      if (outputs.result().isEmpty)
        throw new IllegalArgumentException("At least one output must be specified!")

      Context(
        imageSource.fold(throw new IllegalStateException("Image is not set"))(identity),
        grayOps.result(),
        asciiOps.result(),
        table = table.getOrElse(AsciiTables.default),
        outputs.result()
      )
    }
  }

