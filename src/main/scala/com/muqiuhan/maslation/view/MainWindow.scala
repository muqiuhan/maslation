package com.muqiuhan.maslation.view

import com.muqiuhan.maslation.model
import com.muqiuhan.maslation.update
import com.muqiuhan.maslation.view

import scala.swing.{Frame, GridPanel}
import java.awt.SystemTray
import component.TextArea

import java.awt.{Toolkit, TrayIcon}
import java.awt.PopupMenu
import java.awt.MenuItem
import java.awt.event.{ActionEvent, ActionListener, MouseAdapter, MouseEvent}

class MainWindow(config: model.Config, origin: String, translation: String)
    extends Frame:

  if !SystemTray.isSupported then Error("System tray is not supported")
  else
    val tray = new TrayIcon(
      Toolkit.getDefaultToolkit
        .getImage(classOf[MainWindow].getResource("/logo.png")),
      "maslation", {
        val menu = new PopupMenu()
        val exitItem = new MenuItem("exit")

        exitItem.addActionListener(
          new ActionListener():
            override def actionPerformed(e: ActionEvent): Unit =
              System.exit(0)
        )

        menu.add(exitItem)
        menu
      }
    )

    tray.setImageAutoSize(true)
    tray.addMouseListener(
      new MouseAdapter:
        override def mouseClicked(e: MouseEvent): Unit =
          if e.getClickCount == 2 then visible = true
    )

    SystemTray.getSystemTray.add(tray)

  contents = new GridPanel(1, 2):
    config.server match
      case model.Server.TranslationShell => ()
      // case _                             => contents += TextArea(origin)

    contents += component.TextArea(translation)

  title = s"maslation (${config.sourceLang} -> ${config.targetLang})"
  location = update.CursorPosition()
  resizable = false
