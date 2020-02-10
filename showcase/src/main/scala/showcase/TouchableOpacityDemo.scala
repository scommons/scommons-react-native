package showcase

import scommons.react._
import scommons.reactnative._

import scala.scalajs.js

case class TouchableOpacityDemoProps(onPress: () => Unit)

/** @see https://facebook.github.io/react-native/docs/touchableopacity
  */
object TouchableOpacityDemo extends FunctionComponent[TouchableOpacityDemoProps] {

  protected def render(compProps: Props): ReactElement = {
    val props = compProps.wrapped
    
    <.TouchableOpacity(
      ^.rnStyle := styles.touchableOpacity,
      ^.activeOpacity := 0.5,
      ^.onPress := props.onPress
    )()
  }

  private[showcase] lazy val styles = StyleSheet.create(new Styles)
  private[showcase] class Styles extends js.Object {
    
    val touchableOpacity: Style = new ViewStyle {
      override val margin = 10
    }
  }
}
