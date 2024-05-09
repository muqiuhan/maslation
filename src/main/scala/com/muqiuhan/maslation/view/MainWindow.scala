package com.muqiuhan.maslation.view

import com.muqiuhan.maslation.model
import com.muqiuhan.maslation.update
import com.muqiuhan.maslation.view

import scala.swing.{Frame, GridPanel}
import component.TextArea

class MainWindow(config: model.Config, origin: String, translation: String) extends Frame:

  contents = new GridPanel(1, 2):
    config.server match
      case model.Server.TranslationShell => ()
      // case _                          => contents += TextArea(origin)

    contents += component.TextArea(translation)

  title = s"maslation (${config.sourceLang} -> ${config.targetLang})"
  location = update.CursorPosition()
  resizable = true