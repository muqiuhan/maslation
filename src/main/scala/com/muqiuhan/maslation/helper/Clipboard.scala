package com.muqiuhan.maslation.helper

import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor

object Clipboard:

    def apply(): String = Toolkit.getDefaultToolkit.getSystemClipboard.getData(DataFlavor.stringFlavor).toString
