package view

import com.formdev.flatlaf.util.SystemInfo

import javax.swing.{JDialog, JFrame}
import scala.swing.{FlowPanel, Frame}

class MainWindow(origin: String, translation: String) extends Frame:

  title = "maslation"
  location = update.CursorPosition()

  contents = new FlowPanel:
    contents += OriginTextArea(origin)