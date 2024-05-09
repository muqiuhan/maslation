package com.muqiuhan.maslation.view

import scala.swing.Dialog
import scala.swing.GridPanel
import java.awt.Color
import scala.swing.FlowPanel

object Error extends Dialog:
  title = s"maslation error"
  resizable = false

  def apply(info: String): Unit =
    val exn = RuntimeException(info)
    contents = new FlowPanel():
      contents += component.TextArea(info, Some(Color.RED))
      contents += component.TextArea(
        exn
          .getStackTrace()
          .map(_.toString())
          .reduce((s1: String, s2: String) => s1.concat("\n").concat(s2)),
        Some(Color.GRAY)
      )

    centerOnScreen()
    pack()
    open()
    throw exn
