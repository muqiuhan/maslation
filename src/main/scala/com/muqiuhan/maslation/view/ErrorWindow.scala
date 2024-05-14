package com.muqiuhan.maslation.view

import scala.swing.Dialog
import java.awt.Color
import scala.swing.FlowPanel

object ErrorWindow extends Dialog:
    title = s"maslation error"
    resizable = false
    visible = true

    def apply(info: String, details: String): Unit =
        val exn = RuntimeException(info)
        contents =
            new FlowPanel():
                contents += component.TextArea(info, Some(Color.RED))
                contents +=
                    component.TextArea(
                        details,
                        Some(Color.GRAY)
                    )

        centerOnScreen()
        pack()
        open()
    end apply
end ErrorWindow
