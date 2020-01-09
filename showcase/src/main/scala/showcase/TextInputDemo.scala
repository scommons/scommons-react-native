package showcase

import scommons.react._
import scommons.reactnative.Style._
import scommons.reactnative.TextInput._
import scommons.reactnative.TextStyle._
import scommons.reactnative._

import scala.scalajs.js

case class TextInputDemoProps(onChangeText: String => Unit)

object TextInputDemo extends FunctionComponent[TextInputDemoProps] {

  protected def render(compProps: Props): ReactElement = {
    val props = compProps.wrapped
    
    <.TextInput(
      ^.rnStyle := styles.input,
      ^.value := "Some text",
      ^.placeholderTextColor := Color.red,
      ^.selectionColor := Color.blue,
      ^.secureTextEntry := true,
      ^.keyboardType := KeyboardType.`email-address`,
      ^.onChangeText := props.onChangeText
    )()
  }

  private[showcase] lazy val styles = StyleSheet.create(new Styles)
  private[showcase] class Styles extends js.Object {
    
    val input: Style = new TextStyle {
      override val textAlign = TextAlign.center
      override val margin = 10
    }
  }
}
