package showcase

import scommons.react._
import scommons.reactnative.Style._
import scommons.reactnative._

import scala.scalajs.js

case class TouchableHighlightDemoProps(onPress: () => Unit)

object TouchableHighlightDemo extends FunctionComponent[TouchableHighlightDemoProps] {

  protected def render(compProps: Props): ReactElement = {
    val props = compProps.wrapped
    
    <.TouchableHighlight(
      ^.rnStyle := styles.touchableHighlight,
      ^.underlayColor := Color.red,
      ^.onPress := props.onPress
    )()
  }

  private[showcase] lazy val styles = StyleSheet.create(new Styles)
  private[showcase] class Styles extends js.Object {
    
    val touchableHighlight: Style = new ViewStyle {
      override val margin = 10
    }
  }
}
