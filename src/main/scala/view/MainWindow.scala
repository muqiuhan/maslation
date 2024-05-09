package view

import scala.swing.{Frame, GridPanel}
import java.awt.SystemTray
import component.TextArea

class MainWindow(config: model.Config, origin: String, translation: String)
    extends Frame:

  if !SystemTray.isSupported() then Error("System tray is not supported")
  else ()

  contents = new GridPanel(1, 2):
    config.server match
      case model.Server.TranslationShell => ()
      // case _                             => contents += TextArea(origin)

    contents += component.TextArea(translation)

  title = s"maslation (${config.sourceLang} -> ${config.targetLang})"
  location = update.CursorPosition()
  resizable = false
