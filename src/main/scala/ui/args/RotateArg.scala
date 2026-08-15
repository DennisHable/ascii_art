package ui.args

import filters.RotateFilter
import ui.args.IArgs
import ui.args.context.ContextBuilder

class RotateArg(angle: Int) extends IArgs {
  override def execute(ctxBuilder: ContextBuilder): Unit = {
    ctxBuilder.addAsciiOp(RotateFilter(angle));
  }
}
