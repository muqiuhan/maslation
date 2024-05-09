package update

import java.io.{BufferedReader, InputStreamReader}
import java.util
import java.util.stream.Collectors

trait Translation(source: String, config: model.Config):
  def translate(): String

object Transaction:
  def apply(source: String, config: model.Config): String =
    config.server match
      case model.Server.TranslationShell =>
        TranslationShell(source, config).translate()

case class TranslationShell(source: String, config: model.Config)
    extends Translation(source, config):
  private val preprocessedSource =
    PaperPreprocessor.apply(source)

  def translate(): String =
    val result = new util.ArrayList[String]()
    val p = Runtime.getRuntime.exec(
      Array("trans", ":zh -no-ansi -no-them", preprocessedSource)
    )
    val inputStream = p.getInputStream
    val reader = new BufferedReader(new InputStreamReader(inputStream))
    val target = reader.lines.collect(Collectors.joining("\n"))

    p.waitFor()
    inputStream.close()
    reader.close()
    p.destroy()

    target
