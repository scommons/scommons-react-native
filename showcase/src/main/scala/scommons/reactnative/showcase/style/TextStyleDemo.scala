package scommons.reactnative.showcase.style

import scommons.react._
import scommons.reactnative._

import scala.scalajs.js

object TextStyleDemo extends FunctionComponent[Unit] {

  protected def render(props: Props): ReactElement = {
    <.View(^.rnStyle := styles.container)(
      <(LeftText())(^.rnStyle := new TextStyle {
        override val fontStyle = "italic"
      })(
        "A) Italic"
      ),
      <(LeftText())(^.rnStyle := new TextStyle {
        override val textDecorationLine = "underline line-through"
      })(
        "B) Underline and Line Through"
      ),
      <(LeftText())(^.rnStyle := new IOSTextStyle {
        override val textDecorationLine = "underline line-through"
        override val textDecorationColor = "red"
        override val textDecorationStyle = "dotted"
      })(
        "C) Underline and Line Through"
      ),
      <(LeftText())(^.rnStyle := new TextStyle {
        override val textShadowColor = "red"
        override val textShadowOffset = new Style.ShadowOffset {
          override val width = -2
          override val height = -2
        }
        override val textShadowRadius = 4
      })(
        "D) Text Shadow"
      ),
      <(LeftText())(^.rnStyle := new IOSTextStyle {
        override val letterSpacing = 5
      })(
        "E) Letter Spacing"
      ),
      <(LeftText())(^.rnStyle := new TextStyle {
        override val textAlign = "center"
        override val fontWeight = "bold"
      })(
        s"${Platform.OS}"
      )
    )
  }

  private[style] val LeftText = new FunctionComponent[Unit] {

    protected def render(props: Props): ReactElement = {
      <.Text(^.rnStyle := js.Array(
        styles.leftText,
        props.native.style.asInstanceOf[Style]
      ))(
        props.children
      )
    }
  }

  private[style] lazy val styles = StyleSheet.create(new Styles)
  private[style] class Styles extends js.Object {
    val container: Style = new ViewStyle {
      override val width = 300
      override val marginLeft = 40
      override val marginBottom = 20
    }
    val leftText: Style = new TextStyle {
      override val fontSize = 20
      override val paddingBottom = 10
    }
  }
}
