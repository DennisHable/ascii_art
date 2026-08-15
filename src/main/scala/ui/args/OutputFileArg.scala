package ui.args

import image.pixel.ASCIIPixel
import image.{AsciiRenderer, Image}
import output.FileOutput
import ui.args.context.ContextBuilder

  class OutputFileArg(path: String) extends IArgs {
    override def execute(ctxBuilder: ContextBuilder): Unit = {
      ctxBuilder.addOutput(new FileOutput(path))
    }
  }