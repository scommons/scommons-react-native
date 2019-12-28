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
    lazy val TouchableOpacity: ReactClassElementSpec = elements(raw.TouchableOpacity)
    lazy val View: ReactClassElementSpec = elements(raw.View)
  }

  object ReactNativeVirtualDOMAttributes {

    import VirtualDOMAttributes.Type._

    case class ReactNativeStyleAttributeSpec(name: String) extends AttributeSpec {
      def :=(style: Style): Attribute[Style] = Attribute(name, style, AS_IS)
      def :=(style: js.Array[Style]): Attribute[js.Array[Style]] = Attribute(name, style, AS_IS)
    }
  }

  implicit class ReactNativeVirtualDOMAttributes(attributes: VirtualDOMAttributes)
    extends TextInput.TextInputAttributes
    with Touchable.TouchableAttributes
    with TouchableHighlight.TouchableHighlightAttributes
    with ScrollView.ScrollViewAttributes
    with Image.ImageAttributes {

    import ReactNativeVirtualDOMAttributes._

    lazy val rnStyle = ReactNativeStyleAttributeSpec("style")
  }
}
