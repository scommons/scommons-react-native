package scommons

import io.github.shogowada.scalajs.reactjs.VirtualDOM.VirtualDOMElements.ReactClassElementSpec
import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._
import scommons.reactnative.raw.{Timeout, Timers}

import scala.scalajs.js

package object reactnative {

  implicit class ReactNativeVirtualDOMElements(elements: VirtualDOMElements) {
    lazy val ActivityIndicator: ReactClassElementSpec = elements(raw.ActivityIndicator)
    lazy val Image: ReactClassElementSpec = elements(raw.Image)
    lazy val Modal: ReactClassElementSpec = elements(raw.Modal)
    lazy val ScrollView: ReactClassElementSpec = elements(raw.ScrollView)
    lazy val Text: ReactClassElementSpec = elements(raw.Text)
    lazy val TextInput: ReactClassElementSpec = elements(raw.TextInput)
    lazy val TouchableHighlight: ReactClassElementSpec = elements(raw.TouchableHighlight)
    lazy val TouchableOpacity: ReactClassElementSpec = elements(raw.TouchableOpacity)
    lazy val TouchableWithoutFeedback: ReactClassElementSpec = elements(raw.TouchableWithoutFeedback)
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
    extends ActivityIndicator.ActivityIndicatorAttributes
    with Image.ImageAttributes
    with Modal.ModalAttributes
    with ScrollView.ScrollViewAttributes
    with TextInput.TextInputAttributes
    with Touchable.TouchableAttributes
    with TouchableHighlight.TouchableHighlightAttributes {

    import ReactNativeVirtualDOMAttributes._

    lazy val rnStyle = ReactNativeStyleAttributeSpec("style")
  }

  //////////////////////////////////////////////////////////////////////////////
  // global APIs
  
  private lazy val global = js.Dynamic.global.asInstanceOf[Timers]
  
  def setInterval(callback: js.Function0[Any], delay: Double): Timeout = global.setInterval(callback, delay)
  def setTimeout(callback: js.Function0[Any], delay: Double): Timeout = global.setTimeout(callback, delay)
  def clearInterval(timeout: Timeout): Unit = global.clearInterval(timeout)
  def clearTimeout(timeout: Timeout): Unit = global.clearTimeout(timeout)
}
