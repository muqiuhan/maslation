package update

trait Preprocessor:
  def apply(source: String): String

object PDFInputPreprocessor extends Preprocessor:

  override def apply(source: String): String =
    source
      .replaceAll("-\\R", "")
      .replaceAll("\\R", "")
      .trim

object PDFOutputPreprocessor extends Preprocessor:

  override def apply(source: String): String =
    println(source)
    source
      .replaceAll("。", "。\n")
      .replaceAll("\\.", ".\n")
