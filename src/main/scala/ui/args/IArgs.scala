package ui.args

import ui.args.context.ContextBuilder

/**
 * Společné rozhraní pro argumenty z konzole
 */
trait IArgs {
  // provádí změny v ctxBuilder (v jednotlivých implementacích)  
  def execute(ctxBuilder: ContextBuilder): Unit
}
