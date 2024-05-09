import com.formdev.flatlaf.FlatLightLaf
import com.formdev.flatlaf.util.SystemInfo
import view.MainWindow
import javax.swing.{JDialog, JFrame, UIManager}
import java.awt.Insets

@main def hello(): Unit =
  FlatLightLaf.setup()
  UIManager.put("TextArea.margin", Insets(10, 10, 10, 10))
  UIManager.put("TextComponent.arc", 5)
  System.setProperty("flatlaf.animation", "true")
  System.setProperty("flatlaf.updateUIOn­SystemFontChange", "true")

  // Enable custom window decorations
  if SystemInfo.isLinux then
    JFrame.setDefaultLookAndFeelDecorated(true)
    JDialog.setDefaultLookAndFeelDecorated(true)

  val source = update.Selection()
  val target = update.Transaction(source, model.Config.DEFAULT)
  MainWindow(model.Config.DEFAULT, source, target)
    .pack()
    .open()
