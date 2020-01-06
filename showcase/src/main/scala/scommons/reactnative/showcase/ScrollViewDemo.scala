package scommons.reactnative.showcase

import scommons.react._
import scommons.reactnative.ScrollView._
import scommons.reactnative._

import scala.scalajs.js

object ScrollViewDemo extends FunctionComponent[Unit] {

  protected def render(compProps: Props): ReactElement = {
    <.ScrollView(
      ^.rnStyle := styles.scrollView,
      ^.keyboardShouldPersistTaps := KeyboardShouldPersistTaps.always
    )()
  }

  private[showcase] lazy val styles = StyleSheet.create(new Styles)
  private[showcase] class Styles extends js.Object {
    
    val scrollView: Style = new ViewStyle {
      override val margin = 10
    }
  }
}
