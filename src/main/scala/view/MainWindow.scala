package view

import scala.swing.{Frame, GridPanel}

class MainWindow(config: model.Config, origin: String, translation: String)
    extends Frame:

  contents = new GridPanel(1, 2):
    config.server match
      case model.Server.TranslationShell => ()
      case _                             => contents += TextArea(origin)

    contents += TextArea(translation)

  title = s"maslation (${config.sourceLang} -> ${config.targetLang})"
  location = update.CursorPosition()
  resizable = false
