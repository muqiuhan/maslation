package model

case class Config(sourceLang: Lang, targetLang: Lang, server: Server)

object Config:
  def DEFAULT: Config =
    Config(Lang.English, Lang.Chinese, Server.TranslationShell)
