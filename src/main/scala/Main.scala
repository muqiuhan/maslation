import com.formdev.flatlaf.FlatLightLaf
import com.formdev.flatlaf.util.SystemInfo
import view.MainWindow

import javax.swing.{JDialog, JFrame}
import scala.swing.*

@main def hello(): Unit =
  FlatLightLaf.setup()

  // Enable custom window decorations
  if SystemInfo.isLinux then
    JFrame.setDefaultLookAndFeelDecorated(true)
    JDialog.setDefaultLookAndFeelDecorated(true)

  MainWindow(update.Selection(), "").pack().open()