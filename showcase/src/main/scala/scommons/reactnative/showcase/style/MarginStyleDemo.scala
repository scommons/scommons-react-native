package scommons.reactnative.showcase.style

import scommons.react._
import scommons.reactnative._

import scala.scalajs.js

object MarginStyleDemo extends FunctionComponent[Unit] {

  protected def render(props: Props): ReactElement = {
    <.View(^.rnStyle := styles.container)(
      <.View(^.rnStyle := styles.exampleContainer)(
        <(Example())()(
          <(CenteredText())()("A")
        )
      ),
      <.View(^.rnStyle := styles.exampleContainer)(
        <(Example())(^.rnStyle := new Style {
          override val marginTop = 50
        })(
          <(CenteredText())()("B")
        )
      ),
      <.View(^.rnStyle := styles.exampleContainer)(
        <(Example())(^.rnStyle := new Style {
          override val marginTop = 50
          override val marginLeft = 10
        })(
          <(CenteredText())()("C")
        )
      ),
      <.View(^.rnStyle := styles.exampleContainer)(
        <(Example())(^.rnStyle := new Style {
          override val marginLeft = -10
          override val marginTop = -10
        })(
          <(CenteredText())()("D")
        )
      )
    )
  }

  private[style] val Example = new FunctionComponent[Unit] {

    protected def render(props: Props): ReactElement = {
      <.View(^.rnStyle := js.Array(
        styles.example,
        props.native.style.asInstanceOf[Style]
      ))(
        props.children
      )
    }
  }

  private[style] val CenteredText = new FunctionComponent[Unit] {

    protected def render(props: Props): ReactElement = {
      <.Text(^.rnStyle := js.Array(
        styles.centeredText,
        props.native.style.asInstanceOf[Style]
      ))(
        props.children
      )
    }
  }

  private[style] lazy val styles = StyleSheet.create(Styles)
  
  private[style] object Styles extends js.Object {
    val container: Style = new ViewStyle {
      override val alignItems = "center"
      override val flex = 1
      override val flexDirection = "row"
      override val flexWrap = "wrap"
      override val justifyContent = "center"
    }
    val exampleContainer: Style = new ViewStyle {
      override val borderWidth = 1
      override val width = 120
      override val height = 120
      override val marginLeft = 20
      override val marginBottom = 20
    }
    val example: Style = new ViewStyle {
      override val width = 50
      override val height = 50
      override val backgroundColor = "grey"
      override val borderWidth = 1
      override val justifyContent = "center"
    }
    val centeredText: Style = new ViewStyle {
      override val textAlign = "center"
      override val margin = 10
    }
  }
}
