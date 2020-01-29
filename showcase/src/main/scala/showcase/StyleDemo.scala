package showcase

import scommons.react._
import scommons.reactnative.Style._
import scommons.reactnative._

import scala.scalajs.js

/** @see https://facebook.github.io/react-native/docs/view-style-props
  * @see https://facebook.github.io/react-native/docs/text-style-props
  * @see https://facebook.github.io/react-native/docs/layout-props
  */
object StyleDemo extends FunctionComponent[Unit] {

  protected def render(compProps: Props): ReactElement = {
    <.Text(
      ^.rnStyle := styles.common
    )()
  }

  private lazy val styles = StyleSheet.create(new Styles)
  private class Styles extends js.Object {
    
    val common: Style = new Style {
      override val borderBottomRightRadius = 1
      override val borderBottomWidth = 2
      override val borderColor = Color.red
      override val borderLeftColor = Color.blue
      override val borderLeftWidth = 3
      override val borderRadius = 4
      override val borderRightWidth = 5
      override val borderStyle = BorderStyle.dashed
      override val borderTopColor = Color.yellow
      override val borderTopLeftRadius = 6
      override val borderTopRightRadius = 7
      override val borderTopWidth = 8
      override val borderWidth = 9
      override val margin = 10
      override val marginBottom = 11
      override val marginEnd = 12
      override val marginHorizontal = 13
      override val marginLeft = 14
      override val marginRight = 15
      override val marginStart = 16
      override val marginTop = 17
      override val marginVertical = 18
      override val padding = 19
      override val paddingBottom = 20
      override val paddingEnd = 21
      override val paddingHorizontal = 22
      override val paddingLeft = 23
      override val paddingRight = 24
      override val paddingStart = 25
      override val paddingTop = 26
      override val paddingVertical = 27
      override val shadowColor = Color.gray
      override val shadowOffset = new ShadowOffset {
        override val width = 1
        override val height = 2
      }
      override val shadowOpacity = 0.2
      override val shadowRadius = 28
      override val backgroundColor = Color.white
      override val color = Color.black
      override val position = Position.absolute
      override val width = 30
      override val height = 31
      override val left = 32
      override val right = 33
      override val top = 34
      override val bottom = 35
      override val elevation = 40
    }
  }
}
