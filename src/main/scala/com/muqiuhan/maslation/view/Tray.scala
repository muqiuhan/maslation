package com.muqiuhan.maslation.view

import java.awt.{MenuItem, PopupMenu, SystemTray, Toolkit, TrayIcon}
import java.awt.event.{ActionEvent, ActionListener, MouseAdapter, MouseEvent}
import scala.swing.Frame

class Tray extends Frame:
  visible = false

  // Initialize the system tray
  if !SystemTray.isSupported then Error("System tray is not supported")
  else
    val tray = new TrayIcon(
      Toolkit.getDefaultToolkit.getImage(classOf[MainWindow].getResource("/logo.png")),
      "maslation", {
        val menu = new PopupMenu()
        val exitItem = new MenuItem("exit")

        exitItem.addActionListener(
          new ActionListener():
            override def actionPerformed(e: ActionEvent): Unit = System.exit(0)
        )

        menu.add(exitItem)
        menu
      }
    )

    tray.setImageAutoSize(true)
    SystemTray.getSystemTray.add(tray)
