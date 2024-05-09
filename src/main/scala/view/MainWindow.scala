package view

import scala.swing.event.{Key, KeyPressed, KeyReleased}
import scala.swing.{Component, FlowPanel, Frame, GridPanel}

class MainWindow(config: model.Config, origin: String, translation: String)
    extends Frame:

  contents = new GridPanel(1, 2):
    contents += TextArea(origin)
    contents += TextArea(translation)

  title = s"maslation (${config.sourceLang} -> ${config.targetLang})"
  location = update.CursorPosition()
  resizable = false