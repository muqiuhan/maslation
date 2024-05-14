package com.muqiuhan.maslation.view.component

import com.formdev.flatlaf.ui.FlatBorder
import com.muqiuhan.maslation.helper

import java.awt.Color
import scala.swing
import scala.swing.ScrollPane

class BestDimensionTextArea(text: String, color: Option[Color]) extends swing.TextArea(
        text0 = text,
        rows0 = helper.BestDimension.height(h = text.split("\\R").length),
        columns0 = helper
            .BestDimension
            .width(
                w =
                    text.split("\\R")
                        .reduceLeft((s1, s2) =>
                            if s1.length > s2.length then
                                s1
                            else
                                s2
                        )
                        .length
            )
    ):

    color match
        case None        => ()
        case Some(color) => foreground = color

    editable = false
    lineWrap = true
    wordWrap = true
    border = FlatBorder()

end BestDimensionTextArea

class TextArea(text: String, color: Option[Color] = None) extends ScrollPane(new BestDimensionTextArea(text, color))
