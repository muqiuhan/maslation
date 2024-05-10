package com.muqiuhan.maslation.helper

import java.awt.Toolkit
import scala.swing.Label

object BestDimension:
    private val screenSize = Toolkit.getDefaultToolkit.getScreenSize
    private val defaultSize = new Label().font.getSize

    inline def height(itemSize: Int = defaultSize, h: Int): Int =
        if h * itemSize > screenSize.height then screenSize.height / 5 / defaultSize else h + 1

    inline def width(itemSize: Int = defaultSize, w: Int): Int =
        val bestWidth = screenSize.width / 5 / defaultSize
        if w > bestWidth then bestWidth else w + 1
