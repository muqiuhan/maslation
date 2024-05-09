package model

case class Config(sourceLang: Lang, targetLang: Lang)

object Config:
  def apply(): Config = Config(Lang.English, Lang.Chinese)