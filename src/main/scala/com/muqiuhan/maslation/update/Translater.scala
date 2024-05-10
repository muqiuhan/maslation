package com.muqiuhan.maslation.update

import com.muqiuhan.maslation.model
import com.muqiuhan.maslation.helper

trait Translater(source: String, config: model.Config):
    def translate(): String

object Translater:
    def apply(source: String, config: model.Config): String = config.server match
        case model.Server.TranslationShell => TranslateShell(source, config).translate()

case class TranslateShell(source: String, config: model.Config) extends Translater(source, config):

    private val preprocessedSource = helper.PDFInputPreprocessor(source)

    def translate(): String = helper.PDFOutputPreprocessor(
      helper.CommandExecutor(Array("trans", "--brief", "-no-ansi", "-no-theme", ":zh", preprocessedSource))
    )
