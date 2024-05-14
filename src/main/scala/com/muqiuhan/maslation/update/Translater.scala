package com.muqiuhan.maslation.update

import com.muqiuhan.maslation.model
import com.muqiuhan.maslation.helper
import com.muqiuhan.maslation.model.Lang

trait Translater(source: String, config: model.Config):
    def translate(): String

object Translater:
    def apply(source: String, config: model.Config = model.Config.DEFAULT): String =
        config.server match
            case model.Server.TranslationShell =>
                TranslateShell(source, config).translate()
    end apply
end Translater

case class TranslateShell(source: String, config: model.Config) extends Translater(source, config):
    private val preprocessedSource = helper.PDFInputPreprocessor(source)

    def translate(): String =
        val lang = config.targetLang match
            case Lang.Chinese => ":zh"
            case Lang.English => ":en"

        helper.PDFOutputPreprocessor(
            helper.CommandExecutor(
                Array("trans", "--brief", "-no-ansi", "-no-theme", lang, preprocessedSource)
            )
        )
    end translate

end TranslateShell
