package ascii

import constants.Constants.{CHARS_LINEAR_TABLE_LARGE, CHARS_LINEAR_TABLE_SMALL}

object AsciiTables {
  private val tables: Map[String, ITable] = Map(
    "bourke-small" -> new LinearTable(CHARS_LINEAR_TABLE_SMALL),
    "bourke-large" -> new LinearTable(CHARS_LINEAR_TABLE_LARGE));

  val default: ITable = tables("bourke-small")

  def get(name: String): Option[ITable] =
    tables.get(name)
}
