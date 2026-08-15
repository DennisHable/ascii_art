import ui.{AsciiArtApp, CliParser}
import ui.args.IArgs
import ui.args.context.ContextBuilder

object Main {

  def main(args: Array[String]): Unit = {
    val cliArgs: List[IArgs] = CliParser.parse(args) // parsování

    val builder = new ContextBuilder

    // "nastavení kontextu" pomocí ContextBuilder
    for (arg <- cliArgs) {
      arg.execute(builder)
    }

    // vytvoření kontextu (Context)
    val ctx = builder.build()

    // reálná aplikace - načtení obrázku, apliakce všech filtrů, uložení/výstup
    AsciiArtApp.run(ctx)
  }
}
