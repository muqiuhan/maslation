package com.muqiuhan.maslation.Main

import com.muqiuhan.maslation.model
import com.muqiuhan.maslation.helper
import com.muqiuhan.maslation.view
import com.muqiuhan.maslation.update

import com.formdev.flatlaf.util.SystemInfo
import helper.Selection
import view.MainWindow

import javax.swing.{JDialog, JFrame, UIManager}
import java.awt.Insets
import model.Theme
import com.formdev.flatlaf.themes.FlatMacDarkLaf
import com.formdev.flatlaf.FlatDarkLaf
import com.formdev.flatlaf.themes.FlatMacLightLaf
import com.formdev.flatlaf.FlatLightLaf

object Main:
  val config = model.Config.DEFAULT

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
    case Theme.Dark =>
      if SystemInfo.isMacOS then FlatMacDarkLaf.setup()
      else FlatDarkLaf.setup()
    case Theme.Light =>
      if SystemInfo.isMacOS then FlatMacLightLaf.setup()
      else FlatLightLaf.setup()

  @main def hello(): Unit =
    val source = Selection()
    val target = update.Translater(source, model.Config.DEFAULT)

    MainWindow(config, source, target)
      .pack()
      .open()
