package showcase

import scommons.react._
import scommons.reactnative.ScrollView._
import scommons.reactnative._

import scala.scalajs.js

/** @see https://reactnative.dev/docs/scrollview
  */
object ScrollViewDemo extends FunctionComponent[Unit] {

  protected def render(compProps: Props): ReactElement = {
    <.ScrollView(
      ^.rnStyle := styles.scrollView,
      ^.contentContainerStyle := styles.content,
      ^.keyboardDismissMode := KeyboardDismissMode.`on-drag`,
      ^.keyboardShouldPersistTaps := KeyboardShouldPersistTaps.handled
    )()
  }

  private[showcase] lazy val styles = StyleSheet.create(new Styles)
  private[showcase] class Styles extends js.Object {
    
    val scrollView: Style = new ViewStyle {
      override val flex = 1
    }
    val content: Style = new ViewStyle {
      override val margin = 10
    }
  }
}
