package scommons.reactnative.showcase

import io.github.shogowada.scalajs.reactjs.React
import io.github.shogowada.scalajs.reactjs.classes.ReactClass
import scommons.react.UiComponent
import scommons.reactnative._

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel(name = "ShowcaseApp")
object ShowcaseApp extends UiComponent[Unit] {

  @JSExport("apply")
  override def apply(): ReactClass = super.apply()

  protected def create(): ReactClass = React.createClass[PropsType, Unit] { _ =>
    <.View(^.rnStyle := styles.container)(
      <.Text()("ShowcaseApp")
    )
  }

  private lazy val styles = StyleSheet.create(Styles)
  
  private object Styles extends js.Object {
    val container: Style = new Style {
      override val flex = 1
      override val backgroundColor = "#f5f5f5"
      override val alignItems = "center"
      override val justifyContent = "center"
    }
  }
}
