package scommons.reactnative.showcase.style

import io.github.shogowada.scalajs.reactjs.React
import io.github.shogowada.scalajs.reactjs.classes.ReactClass
import scommons.react.UiComponent
import scommons.reactnative._

import scala.scalajs.js

object BorderStyleDemo extends UiComponent[Unit] {

  protected def create(): ReactClass = React.createClass[PropsType, Unit] { _ =>
    <.View(^.rnStyle := styles.container)(
      <(Example)(^.rnStyle := new Style {
        override val borderWidth = 1
      })(
        <.Text()("borderWidth: 1")
      ),
      <(Example)(^.rnStyle := new Style {
        override val borderWidth = 3
        override val borderLeftWidth = 0
      })(
        <.Text()("borderWidth: 3, borderLeftWidth: 0")
      ),
      <(Example)(^.rnStyle := new Style {
        override val borderWidth = 3
        override val borderLeftColor = "red"
      })(
        <.Text()("borderWidth: 3, borderLeftColor: 'red'")
      ),
      <(Example)(^.rnStyle := new Style {
        override val borderLeftWidth = 3
      })(
        <.Text()("borderLeftWidth: 3")
      ),
      <(Example)(^.rnStyle := new Style {
        override val borderWidth = 1
        override val borderStyle = "dashed"
      })(
        <.Text()("borderWidth: 1, borderStyle: 'dashed'")
      )
    )
  }

  private[style] val Example: ReactClass = React.createClass[PropsType, Unit] { self =>
    <.View(^.rnStyle := js.Array(
      styles.example,
      self.props.native.style.asInstanceOf[Style]
    ))(
      self.props.children
    )
  }

  private[style] lazy val styles = StyleSheet.create(Styles)
  
  private[style] object Styles extends js.Object {
    val container: Style = new Style {
      override val flex = 1
      override val justifyContent = "center"
      override val alignItems = "center"
    }
    val example: Style = new Style {
      override val marginBottom = 15
    }
  }
}
