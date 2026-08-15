package ui

import ascii.{LinearTable, NonLinearTable}
import filters.{Axis, BrightnessFilter, FlipFilter, IFilter, InvertFilter, RotateFilter}
import image.pixel.{ASCIIPixel, GrayScalePixel}
import input.{FileImageLoader, RandomImageLoader}
import output.{ConsoleOutput, FileOutput}
import ui.args.{BrightnessArg, CustomTableArg, FlipArg, IArgs, ImageArg, ImageRandomArg, InvertArg, OutputConsoleArg, OutputFileArg, RotateArg, TableArg}

object CliParser {

  /**
   * Parsováné argumentů ze vstupu na konzoli
   * @param args argumenty z koznole
   * @return List argumentů, kterým se nastaví kontext a poté se budou volat jednotlivé filtry a operace na obrázku
   */
  def parse(args: Array[String]): List[IArgs] = {
    val result = scala.collection.mutable.ListBuffer[IArgs]()
    var i = 0

    while (i < args.length) {

      args(i) match {

        case "--image" =>
          val path = args(i + 1) // cesta k souboru
          result += new ImageArg(path) // přidání argumentu do listu
          i += 2 // posun o "--image" a o tu cestu

        case "--image-random" =>
          result += new ImageRandomArg()
          i += 1

        case "--invert" =>
          result += InvertArg
          i += 1

        case "--rotate" =>
          val deg = args(i + 1).toInt
          result += new RotateArg(deg)
          i += 2

        case "--brightness" =>
          val value = args(i + 1).toInt
          result += new BrightnessArg(value)
          i += 2

        case "--flip" =>
          val value = args(i + 1)
          if(value.toCharArray()(0) == 'x') result += new FlipArg(Axis.X)
          if(value.toCharArray()(0) == 'y') result += new FlipArg(Axis.Y)
          i += 2

        case "--table" =>
          val tableName = args(i + 1)
          result += new TableArg(tableName)
          i += 2

        case "--custom-table" =>
          val tableName = args(i + 1)
          result += new CustomTableArg(tableName)
          i += 2

        case "--output-console" =>
          result += OutputConsoleArg
          i += 1

        case "--output-file" =>
          val value = args(i + 1)
          result += OutputFileArg(value)
          i += 2

        case other =>
          throw new IllegalArgumentException(s"Unknown argument: $other")
      }
    }

    result.toList
  }
}
