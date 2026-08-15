package constants

object Constants {
  // stringy pro převod gray scale na ascii znak
  val CHARS_LINEAR_TABLE_SMALL: String = " .:-=+*#%@"
  val CHARS_LINEAR_TABLE_LARGE: String = """ .'`^",:;Il!i><~+_-?][}{1)(|\/tfjrxnuvczMW&8%B@$#"""

  // výchozí rozměry pro RandomImageGenerator
  val DEFAULT_WIDTH: Int = 30
  val DEFAULT_HEIGHT: Int = 20

  // seed pro random generátory
  val SEED = 42;
}
