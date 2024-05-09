package update

import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor

object Selection:

  def apply(): String =
    Toolkit.getDefaultToolkit.getSystemSelection
      .getData(DataFlavor.stringFlavor)
      .toString