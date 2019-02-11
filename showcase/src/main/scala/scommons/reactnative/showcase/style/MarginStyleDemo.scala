package scommons.reactnative.showcase.style

import io.github.shogowada.scalajs.reactjs.React
import io.github.shogowada.scalajs.reactjs.classes.ReactClass
import scommons.react.UiComponent
import scommons.reactnative._

import scala.scalajs.js

object MarginStyleDemo extends UiComponent[Unit] {

  protected def create(): ReactClass = React.createClass[PropsType, Unit] { _ =>
    <.View(^.rnStyle := styles.container)(
      <.View(^.rnStyle := styles.exampleContainer)(
        <(Example)()(
          <(CenteredText)()("A")
        )
      ),
      <.View(^.rnStyle := styles.exampleContainer)(
        <(Example)(^.rnStyle := new Style {
          override val marginTop = 50
        })(
          <(CenteredText)()("B")
        )
      ),
      <.View(^.rnStyle := styles.exampleContainer)(
        <(Example)(^.rnStyle := new Style {
          override val marginTop = 50
          override val marginLeft = 10
        })(
          <(CenteredText)()("C")
        )
      ),
      <.View(^.rnStyle := styles.exampleContainer)(
        <(Example)(^.rnStyle := new Style {
          override val marginLeft = -10
          override val marginTop = -10
        })(
          <(CenteredText)()("D")
        )
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

  private[style] val CenteredText: ReactClass = React.createClass[PropsType, Unit] { self =>
    <.Text(^.rnStyle := js.Array(
      styles.centeredText,
      self.props.native.style.asInstanceOf[Style]
    ))(
      self.props.children
    )
  }

  private[style] lazy val styles = StyleSheet.create(Styles)
  
  private[style] object Styles extends js.Object {
    val container: Style = new Style {
      override val alignItems = "center"
      override val flex = 1
      override val flexDirection = "row"
      override val flexWrap = "wrap"
      override val justifyContent = "center"
    }
    val exampleContainer: Style = new Style {
      override val borderWidth = 1
      override val width = 120
      override val height = 120
      override val marginLeft = 20
      override val marginBottom = 20
    }
    val example: Style = new Style {
      override val width = 50
      override val height = 50
      override val backgroundColor = "grey"
      override val borderWidth = 1
      override val justifyContent = "center"
    }
    val centeredText: Style = new Style {
      override val textAlign = "center"
      override val margin = 10
    }
  }
}
