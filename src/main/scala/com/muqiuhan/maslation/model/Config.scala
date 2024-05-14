package com.muqiuhan.maslation.model

case class Config(
    sourceLang: Lang,
    targetLang: Lang,
    server: Server,
    theme: Theme,
    shortcuts: String
)

object Config:
    def DEFAULT: Config = Config(
        sourceLang = Lang.English,
        targetLang = Lang.Chinese,
        server = Server.TranslationShell,
        theme = Theme.Light,
        shortcuts = "Shift+F9"
    )
end Config
