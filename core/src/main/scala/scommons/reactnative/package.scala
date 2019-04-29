package scommons

import io.github.shogowada.scalajs.reactjs.VirtualDOM.VirtualDOMElements.ReactClassElementSpec
import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._

import scala.scalajs.js

package object reactnative {

  implicit class ReactNativeVirtualDOMElements(elements: VirtualDOMElements) {
    lazy val Image: ReactClassElementSpec = elements(raw.Image)
    lazy val ScrollView: ReactClassElementSpec = elements(raw.ScrollView)
    lazy val Text: ReactClassElementSpec = elements(raw.Text)
    lazy val TextInput: ReactClassElementSpec = elements(raw.TextInput)
    lazy val TouchableHighlight: ReactClassElementSpec = elements(raw.TouchableHighlight)
    lazy val View: ReactClassElementSpec = elements(raw.View)
  }

  object ReactNativeVirtualDOMAttributes {

    import VirtualDOMAttributes.Type._

    case class ImageSourceAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: ImageSource): Attribute[ImageSource] = Attribute(name, value, AS_IS)
    }

    case class ReactNativeStyleAttributeSpec(name: String) extends AttributeSpec {
      def :=(style: Style): Attribute[Style] = Attribute(name, style, AS_IS)
      def :=(style: js.Array[Style]): Attribute[js.Array[Style]] = Attribute(name, style, AS_IS)
    }

    type OnChangeTextEvent = js.Function1[String, Unit]
    case class OnChangeTextEventAttribute(name: String) extends AttributeSpec {
      def :=(onEvent: OnChangeTextEvent): Attribute[OnChangeTextEvent] = Attribute(name, onEvent, AS_IS)
    }
    
    type OnPressEvent = js.Function0[Unit]
    case class OnPressEventAttribute(name: String) extends AttributeSpec {
      def :=(onEvent: OnPressEvent): Attribute[OnPressEvent] = Attribute(name, onEvent, AS_IS)
    }
  }

  implicit class ReactNativeVirtualDOMAttributes(attributes: VirtualDOMAttributes) {

    import ReactNativeVirtualDOMAttributes._

    lazy val rnStyle = ReactNativeStyleAttributeSpec("style")
    lazy val keyboardShouldPersistTaps = StringAttributeSpec("keyboardShouldPersistTaps")
    lazy val placeholderTextColor = StringAttributeSpec("placeholderTextColor")
    lazy val selectionColor = StringAttributeSpec("selectionColor")
    lazy val underlayColor = StringAttributeSpec("underlayColor")
    lazy val source = ImageSourceAttributeSpec("source")
    
    lazy val onChangeText = OnChangeTextEventAttribute("onChangeText")
    lazy val onPress = OnPressEventAttribute("onPress")
  }
}
