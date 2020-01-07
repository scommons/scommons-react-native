package scommons.reactnative.showcase

import scommons.react._
import scommons.reactnative.AndroidTextStyle._
import scommons.reactnative.IOSTextStyle._
import scommons.reactnative.Style._
import scommons.reactnative.TextStyle._
import scommons.reactnative._

import scala.scalajs.js

object TextStyleDemo extends FunctionComponent[Unit] {

  protected def render(compProps: Props): ReactElement = {
    <.Text(
      ^.rnStyle := styles.text
    )()
  }

  private lazy val styles = StyleSheet.create(new Styles)
  private class Styles extends js.Object {
    
    val text: Style = new TextStyle with AndroidTextStyle with IOSTextStyle {
      override val fontFamily = Platform.select {
        case Platform.ios => "American Typewriter"
        case Platform.android => "monospace"
      }
      override val fontSize = 14
      override val fontStyle = FontStyle.italic
      override val fontWeight = FontWeight.`100`
      override val lineHeight = 12
      override val textAlign = TextAlign.center
      override val textDecorationLine = TextDecorationLine.underline
      override val textShadowColor = Color.red
      override val textShadowOffset = new ShadowOffset {
        override val width = 1
        override val height = 2
      }
      override val textShadowRadius = 11
      // android
      override val textAlignVertical = TextAlignVertical.center
      // ios
      override val letterSpacing = 2
      override val textDecorationColor = Color.blue
      override val textDecorationStyle = TextDecorationStyle.dashed
      override val writingDirection = WritingDirection.auto
    }
  }
}
