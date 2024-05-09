import com.formdev.flatlaf.FlatLightLaf

import scala.swing.*

@main def hello(): Unit =
  FlatLightLaf.setup()

  new Frame:
    title = "Hello world"
    location = helper.CursorPosition()

    contents = new FlowPanel:
      contents += new Label("Launch rainbows:")
      contents += new Button("Click me"):
        reactions += { case event.ButtonClicked(_) =>
          println("All the colours!")
        }
    
    pack()
    open()
