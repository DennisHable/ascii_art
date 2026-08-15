package ui.args

import ascii.AsciiTables
import ui.args.context.ContextBuilder

class TableArg(name: String) extends IArgs {

  override def execute(ctxBuilder: ContextBuilder): Unit = {
    ctxBuilder.setTable(AsciiTables.get(name)
      .getOrElse(
        throw new IllegalArgumentException(s"Unknown table: $name")))
  }
}
