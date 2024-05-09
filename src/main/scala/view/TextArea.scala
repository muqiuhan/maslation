package view

import com.formdev.flatlaf.ui.FlatBorder

import java.awt.{Color, Dimension}
import java.util.Comparator
import scala.swing

class TextArea(text: String) extends swing.TextArea(text):

  maximumSize = Dimension(columns, rows)
  editable = false

  border = FlatBorder()
