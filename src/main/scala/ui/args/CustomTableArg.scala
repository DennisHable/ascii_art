package ui.args

import ascii.LinearTable
import ui.args.context.ContextBuilder

class CustomTableArg(chars: String) extends IArgs {

  override def execute(ctxBuilder: ContextBuilder): Unit =
    ctxBuilder.setTable(new LinearTable(chars))
}
