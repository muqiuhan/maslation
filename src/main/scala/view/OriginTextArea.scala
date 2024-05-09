package view

import java.util.regex.Pattern
import java.util.Comparator
import scala.swing.TextArea

class OriginTextArea(text: String)
    extends TextArea(
      text,
      rows0 = text.lines.count.toInt,
      columns0 = text.lines
        .max((s1, s2) => Integer.compare(s1.length, s2.length))
        .orElse("")
        .length
    ):

  editable = false