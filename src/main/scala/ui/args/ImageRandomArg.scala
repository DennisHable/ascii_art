package ui.args

import constants.Constants.SEED
import input.RandomImageLoader
import ui.args.context.ContextBuilder

class ImageRandomArg extends IArgs {
  override def execute(ctxBuilder: ContextBuilder): Unit = {
    ctxBuilder.setImageSource(RandomImageLoader(SEED))
  }
}