package update

import java.awt.Point
import java.awt.MouseInfo

object CursorPosition:
  def apply() : Point =
    val location = MouseInfo.getPointerInfo.getLocation
    Point(location.x, location.y)