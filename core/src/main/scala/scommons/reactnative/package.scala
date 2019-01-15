package scommons

import io.github.shogowada.scalajs.reactjs.VirtualDOM
import io.github.shogowada.scalajs.reactjs.VirtualDOM.VirtualDOMElements.ReactClassElementSpec
import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.scalajs.reactjs.classes.ReactClass
import io.github.shogowada.statictags._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

package object reactnative {

  @js.native
  @JSImport("react-native", "ScrollView")
  object NativeScrollView extends ReactClass

  @js.native
  @JSImport("react-native", "Text")
  object NativeText extends ReactClass

  @js.native
  @JSImport("react-native", "TextInput")
  object NativeTextInput extends ReactClass

  @js.native
  @JSImport("react-native", "TouchableHighlight")
  object NativeTouchableHighlight extends ReactClass

  @js.native
  @JSImport("react-native", "View")
  object NativeView extends ReactClass

  implicit class ReactNativeVirtualDOMElements(elements: VirtualDOMElements) {
    lazy val ScrollView: ReactClassElementSpec = elements(NativeScrollView)
    lazy val Text: ReactClassElementSpec = elements(NativeText)
    lazy val TextInput: ReactClassElementSpec = elements(NativeTextInput)
    lazy val TouchableHighlight: ReactClassElementSpec = elements(NativeTouchableHighlight)
    lazy val View: ReactClassElementSpec = elements(NativeView)
  }

  object ReactNativeVirtualDOMAttributes {

    import VirtualDOMAttributes.Type._

    case class ReactNativeStyleAttributeSpec(name: String) extends AttributeSpec {
      def :=(style: Style): Attribute[Style] = Attribute(name = name, value = style, AS_IS)
      def :=(style: js.Array[Style]): Attribute[js.Array[Style]] = Attribute(name = name, value = style, AS_IS)
    }

    type OnChangeTextEvent = js.Function1[String, Unit]
    case class OnChangeTextEventAttribute(name: String) extends AttributeSpec {
      def :=(onEvent: OnChangeTextEvent): Attribute[OnChangeTextEvent] =
        Attribute(name = name, value = onEvent, AS_IS)
    }
    
    type OnPressEvent = js.Function0[Unit]
    case class OnPressEventAttribute(name: String) extends AttributeSpec {
      def :=(onEvent: OnPressEvent): Attribute[OnPressEvent] =
        Attribute(name = name, value = onEvent, AS_IS)
    }
  }

  implicit class ReactNativeVirtualDOMAttributes(attributes: VirtualDOMAttributes) {

    import ReactNativeVirtualDOMAttributes._

    lazy val rnStyle = ReactNativeStyleAttributeSpec("style")
    lazy val keyboardShouldPersistTaps = StringAttributeSpec("keyboardShouldPersistTaps")
    lazy val placeholderTextColor = StringAttributeSpec("placeholderTextColor")
    lazy val selectionColor = StringAttributeSpec("selectionColor")
    lazy val underlayColor = StringAttributeSpec("underlayColor")
    
    lazy val onChangeText = OnChangeTextEventAttribute("onChangeText")
    lazy val onPress = OnPressEventAttribute("onPress")
  }

  lazy val < : VirtualDOM.VirtualDOMElements = VirtualDOM.<
  lazy val ^ : VirtualDOM.VirtualDOMAttributes = VirtualDOM.^
}
