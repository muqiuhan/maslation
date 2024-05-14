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

import java.util.Scanner

enum Error extends errors.Error:
    case Unknown

object Program:
    private val config = model.Config.DEFAULT

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
        try
            Tray()
            GlobalScreen.registerNativeHook()
            GlobalScreen.addNativeKeyListener(
                new NativeKeyListener:
                    override def nativeKeyPressed(nativeEvent: NativeKeyEvent): Unit =
                        if nativeEvent.getKeyCode == NativeKeyEvent.VC_F9 then
                            exec()
            )

            new Scanner(System.in).next()
        catch case e: Exception => Error.Unknown.report(e)
        end try
    end main
end Program
