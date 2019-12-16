package scommons.reactnative.showcase.style

import scommons.react._
import scommons.reactnative._

import scala.scalajs.js

object PositionStyleDemo extends FunctionComponent[Unit] {

  protected def render(props: Props): ReactElement = {
    <.View(^.rnStyle := styles.container)(
      <.View(^.rnStyle := styles.row)(
        <(Example())()(
          <(CenteredText())()("A")
        ),
        <(Example())()(
          <(CenteredText())()("B"),
          <.View(^.rnStyle := js.Array(styles.tinyExample, styles.positionAbsolute))(
            <(CenteredText())()("E")
          )
        ),
        <(Example())()(
          <(CenteredText())()("C")
        )
      ),
      <(Example())(^.rnStyle := styles.positionAbsolute)(
        <(CenteredText())()("D")
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
      override val width = 300
      override val height = 300
      override val marginLeft = 40
      override val marginBottom = 20
      override val borderWidth = 1
    }
    val row: Style = new ViewStyle {
      override val flex = 1
      override val flexDirection = "row"
    }
    val example: Style = new ViewStyle {
      override val width = 100
      override val height = 100
      override val backgroundColor = "grey"
      override val borderWidth = 1
      override val justifyContent = "center"
    }
    val tinyExample: Style = new ViewStyle {
      override val width = 30
      override val height = 30
      override val borderWidth = 1
      override val justifyContent = "center"
      override val backgroundColor = "lightgrey"
    }
    val centeredText: Style = new TextStyle {
      override val textAlign = "center"
      override val margin = 10
    }
    val positionAbsolute: Style = new ViewStyle {
      override val position = "absolute"
      override val right = 0
      override val bottom = 0
    }
  }
}
