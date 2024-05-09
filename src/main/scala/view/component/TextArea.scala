package view.component

import com.formdev.flatlaf.ui.FlatBorder

import java.awt.{Color, Dimension}
import java.util.Comparator
import scala.swing
import com.formdev.flatlaf.FlatLightLaf

class TextArea(text: String, color: Option[Color] = None)
    extends swing.TextArea(text):

  color match
    case None        => ()
    case Some(color) => foreground = color

  maximumSize = Dimension(columns, rows)
  editable = false

  border = FlatBorder()
