package ui.args

import image.pixel.ASCIIPixel
import image.{AsciiRenderer, Image}
import output.ConsoleOutput
import ui.args.context.ContextBuilder

object OutputConsoleArg extends IArgs {
  override def execute(ctxBuilder: ContextBuilder): Unit = {
    ctxBuilder.addOutput(new ConsoleOutput())
  }
}