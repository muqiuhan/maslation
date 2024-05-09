package com.muqiuhan.maslation.view

import scala.swing.Dialog
import java.awt.Color
import scala.swing.FlowPanel

object Error extends Dialog:
  title = s"maslation error"
  resizable = false
  visible = true

  def stackTraceElementsToString(exn: Exception): String = exn.getStackTrace.map(_.toString())
    .reduce((s1: String, s2: String) => s1.concat("\n").concat(s2))

  def apply(info: String, details: Option[String] = None): Unit =
    val exn = RuntimeException(info)
    contents = new FlowPanel():
      contents += component.TextArea(info, Some(Color.RED))
      contents += component.TextArea(details.getOrElse(stackTraceElementsToString(exn)), Some(Color.GRAY))

    centerOnScreen()
    pack()
    open()
