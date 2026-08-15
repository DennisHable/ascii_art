package ui.args

import filters.{BrightnessFilter, InvertFilter}
import ui.args.IArgs
import ui.args.context.ContextBuilder

class BrightnessArg(delta: Int) extends IArgs {
  override def execute(ctxBuilder: ContextBuilder): Unit = {
    ctxBuilder.addGrayOp(BrightnessFilter(delta))
  }
}
