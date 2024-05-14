package com.muqiuhan.maslation.view

import java.awt.{MenuItem, PopupMenu, SystemTray, Toolkit, TrayIcon}
import java.awt.event.{ActionEvent, ActionListener, MouseAdapter, MouseEvent}
import scala.swing.Frame
import java.util.Scanner
import com.formdev.flatlaf.FlatLaf
import java.awt.Font
import javax.swing.UIManager

/** NOTE: scala-swing currently does not have TrayIcon or SystemTray available, so the native swing components are used. */
class TrayMenu extends PopupMenu:
    add(new MenuItem("exit"):
        setFont(UIManager.getFont("h4.font"))
        addActionListener(
            new ActionListener():
                override def actionPerformed(e: ActionEvent): Unit = System.exit(0)
        )
    )
end TrayMenu

class Tray extends TrayIcon(
        Toolkit
            .getDefaultToolkit
            .getImage(classOf[MainWindow]
                    .getResource("/logo.png")),
        "maslation",
        new TrayMenu()
    ):
    setImageAutoSize(true)
    SystemTray.getSystemTray.add(this)
    new Scanner(System.in).next()
end Tray
