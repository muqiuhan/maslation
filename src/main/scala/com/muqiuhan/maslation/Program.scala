package com.muqiuhan.maslation

import com.formdev.flatlaf.util.SystemInfo
import helper.Selection
import view.{MainWindow, Tray}

import javax.swing.{JDialog, JFrame, UIManager}
import java.awt.Insets
import model.Theme
import com.formdev.flatlaf.themes.FlatMacDarkLaf
import com.formdev.flatlaf.FlatDarkLaf
import com.formdev.flatlaf.themes.FlatMacLightLaf
import com.formdev.flatlaf.FlatLightLaf
import com.github.kwhat.jnativehook.GlobalScreen
import com.github.kwhat.jnativehook.keyboard.{NativeKeyEvent, NativeKeyListener}
import java.awt.SystemTray

enum Error extends errors.Error:
    case Unknown
    case SystemTrayIsNotSupport

object Program:
    private val config = model.Config.DEFAULT

    // Initialize the system tray
    if !SystemTray.isSupported then Error.SystemTrayIsNotSupport.reportAndExit(message = "SystemTrayIsNotSupport")

    // Initialize properties
    UIManager.put("TextArea.margin", Insets(10, 10, 10, 10))
    UIManager.put("TextComponent.arc", 5)
    System.setProperty("flatlaf.animation", "true")
    System.setProperty("flatlaf.updateUIOnSystemFontChange", "true")
    System.setProperty("flatlaf.menuBarEmbedded", "true")

    // Enable custom window decorations on linux
    if SystemInfo.isLinux then
        JFrame.setDefaultLookAndFeelDecorated(true)
        JDialog.setDefaultLookAndFeelDecorated(true)

    // Initialize theme
    config.theme match
        case Theme.Dark  => if SystemInfo.isMacOS then FlatMacDarkLaf.setup() else FlatDarkLaf.setup()
        case Theme.Light => if SystemInfo.isMacOS then FlatMacLightLaf.setup() else FlatLightLaf.setup()

    private def exec(): Unit =
        Selection().foreach(source =>
            MainWindow(
                source = source,
                target = update.Translater(
                    source = source
                )
            ).pack().open()
        )
    end exec

    @main
    def main(): Unit =
        val keyboardListener = new update.KeyboardListener(model.Config.DEFAULT.shortcuts, exec)
        try Tray()
        catch case e: Exception => Error.Unknown.report(e)
        finally keyboardListener.close()
    end main
end Program
