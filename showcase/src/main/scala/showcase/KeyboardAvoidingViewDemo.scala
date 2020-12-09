package showcase

import scommons.react._
import scommons.reactnative.KeyboardAvoidingView._
import scommons.reactnative._

import scala.scalajs.js

/** @see https://reactnative.dev/docs/keyboardavoidingview
  */
object KeyboardAvoidingViewDemo extends FunctionComponent[Unit] {

  protected def render(compProps: Props): ReactElement = {
    <.KeyboardAvoidingView(
      ^.rnStyle := styles.container,
      ^.contentContainerStyle := styles.content,
      ^.behavior := {
        if (Platform.OS == Platform.ios) Behavior.padding
        else Behavior.height
      }
    )()
  }

  private[showcase] lazy val styles = StyleSheet.create(new Styles)
  private[showcase] class Styles extends js.Object {
    
    val container: Style = new ViewStyle {
      override val flex = 1
    }
    val content: Style = new ViewStyle {
      override val margin = 10
    }
  }
}
