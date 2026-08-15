package ui.args

import filters.{Axis, FlipFilter, RotateFilter}
import ui.args.IArgs
import ui.args.context.ContextBuilder

class FlipArg(axis: Axis) extends IArgs {
  override def execute(ctxBuilder: ContextBuilder): Unit = {
    ctxBuilder.addAsciiOp(FlipFilter(axis));
  }
}
