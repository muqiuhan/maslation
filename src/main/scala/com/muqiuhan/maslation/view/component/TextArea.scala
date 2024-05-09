package com.muqiuhan.maslation.view.component

import com.formdev.flatlaf.ui.FlatBorder

import java.awt.{Color, Dimension}
import java.util.Comparator
import scala.swing

class TextArea(text: String, color: Option[Color] = None) extends swing.TextArea(text):

  color match
    case None        => ()
    case Some(color) => foreground = color

  editable = false
  lineWrap = true
  wordWrap = true
  border = FlatBorder()
