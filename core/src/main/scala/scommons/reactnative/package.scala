package scommons

import io.github.shogowada.scalajs.reactjs.VirtualDOM.VirtualDOMElements.ReactClassElementSpec
import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._
import scommons.reactnative.raw.{Timeout, Globals => g}

import scala.scalajs.js

package object reactnative {
  
  type StaticResource = raw.StaticResource
  type UriResource = raw.UriResource

  implicit class ReactNativeVirtualDOMElements(elements: VirtualDOMElements) {
    lazy val ActivityIndicator: ReactClassElementSpec = elements(raw.ActivityIndicator)
    lazy val Button: ReactClassElementSpec = elements(raw.Button)
    lazy val FlatList: ReactClassElementSpec = elements(raw.FlatList)
    lazy val Image: ReactClassElementSpec = elements(raw.Image)
    lazy val KeyboardAvoidingView: ReactClassElementSpec = elements(raw.KeyboardAvoidingView)
    lazy val Modal: ReactClassElementSpec = elements(raw.Modal)
    lazy val ScrollView: ReactClassElementSpec = elements(raw.ScrollView)
    lazy val StatusBar: ReactClassElementSpec = elements(raw.StatusBar)
    lazy val Switch: ReactClassElementSpec = elements(raw.Switch)
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
    
    case class ReactNativeSizeAttributeSpec(name: String) extends AttributeSpec {
      def :=(style: Int): Attribute[Int] = Attribute(name, style, AS_IS)
    }
  }

  implicit class ReactNativeVirtualDOMAttributes(attributes: VirtualDOMAttributes)
    extends ActivityIndicator.ActivityIndicatorAttributes
    with Button.ButtonAttributes
    with FlatList.FlatListAttributes
    with Image.ImageAttributes
    with KeyboardAvoidingView.KeyboardAvoidingViewAttributes
    with Modal.ModalAttributes
    with ScrollView.ScrollViewAttributes
    with StatusBar.StatusBarAttributes
    with Switch.SwitchAttributes
    with TextInput.TextInputAttributes
    with Touchable.TouchableAttributes
    with TouchableHighlight.TouchableHighlightAttributes
    with TouchableOpacity.TouchableOpacityAttributes {

    import ReactNativeVirtualDOMAttributes._

    lazy val contentContainerStyle = ReactNativeStyleAttributeSpec("contentContainerStyle")
    lazy val rnStyle = ReactNativeStyleAttributeSpec("style")
    lazy val rnSize = ReactNativeSizeAttributeSpec("size")
    lazy val color = StringAttributeSpec("color")
  }

  //////////////////////////////////////////////////////////////////////////////
  // global APIs
  
  def setInterval(callback: js.Function0[Any], delay: Double): Timeout = g.setInterval(callback, delay)
  def setTimeout(callback: js.Function0[Any], delay: Double): Timeout = g.setTimeout(callback, delay)
  def clearInterval(timeout: Timeout): Unit = g.clearInterval(timeout)
  def clearTimeout(timeout: Timeout): Unit = g.clearTimeout(timeout)
}
