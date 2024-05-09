package update

import java.io.{BufferedReader, InputStreamReader}
import java.util
import java.util.stream.Collectors

trait Translater(source: String, config: model.Config):
  def translate(): String

object Translater:
  def apply(source: String, config: model.Config): String =
    config.server match
      case model.Server.TranslationShell =>
        TranslateShell(source, config).translate()

case class TranslateShell(source: String, config: model.Config)
    extends Translater(source, config):

  private val preprocessedSource = PDFInputPreprocessor(source)

  def translate(): String =
    PDFOutputPreprocessor(
      helper.CommandExecutor(
        Array(
          "trans",
          "--brief",
          "-no-ansi",
          "-no-theme",
          ":zh",
          preprocessedSource
        )
      )
    )
