package com.muqiuhan.maslation.model

case class Config(
    sourceLang: Lang,
    targetLang: Lang,
    server: Server,
    theme: Theme
)

object Config:
  def DEFAULT: Config =
    Config(
      sourceLang = Lang.English,
      targetLang = Lang.Chinese,
      server = Server.TranslationShell,
      theme = Theme.Light
    )
