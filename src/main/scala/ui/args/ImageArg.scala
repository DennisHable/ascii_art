package ui.args

import input.FileImageLoader
import ui.args.IArgs
import ui.args.context.ContextBuilder

/**
 * @param path cesta k souboru
 */
final class ImageArg(path: String) extends IArgs {
  override def execute(ctxBuilder: ContextBuilder): Unit = {
    ctxBuilder.setImageSource(FileImageLoader(path))
  }
}