package ui.args

import filters.InvertFilter
import ui.args.IArgs
import ui.args.context.ContextBuilder

object InvertArg extends IArgs {
  override def execute(ctxBuilder: ContextBuilder): Unit = {
    ctxBuilder.addGrayOp(InvertFilter())
  }
}
