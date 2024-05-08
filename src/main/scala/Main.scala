import java.awt.MouseInfo
import java.awt.Point
import scala.swing._

@main def hello(): Unit =
  new Frame:
    title = "Hello world"
    location =
      val location = MouseInfo.getPointerInfo.getLocation
      Point(location.x, location.y)

    contents = new FlowPanel:
      contents += new Label("Launch rainbows:")
      contents += new Button("Click me"):
        reactions += { case event.ButtonClicked(_) =>
          println("All the colours!")
        }
    
    pack()
    open()
