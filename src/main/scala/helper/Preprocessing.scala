package update

trait Preprocessor:
  def apply(source: String): String

object PaperPreprocessor extends Preprocessor:

  override def apply(source: String): String =
    source
      .replaceAll("-\\R", "")
      .replaceAll("\\R", "")
      .trim