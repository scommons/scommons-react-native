package scommons.reactnative

import io.github.shogowada.scalajs.reactjs.VirtualDOM.VirtualDOMElements.ReactClassElementSpec
import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._

import scala.scalajs.js

/** @see https://github.com/react-native-community/react-native-webview
  */
package object webview {

  type HtmlResource = webview.raw.HtmlResource

  implicit class WebViewVirtualDOMElements(elements: VirtualDOMElements) {
    lazy val WebView: ReactClassElementSpec = elements(webview.raw.WebView)
  }

  implicit class WebViewVirtualDOMAttributes(attributes: VirtualDOMAttributes) {
    
    import WebViewVirtualDOMAttributes._

    lazy val htmlSource = HtmlSourceAttribute("source")
    lazy val originWhiteList = OriginWhiteListAttribute("originWhiteList")
  }

  object WebViewVirtualDOMAttributes {

    import VirtualDOMAttributes.Type._

    case class HtmlSourceAttribute(name: String) extends AttributeSpec {
      def :=(value: HtmlResource): Attribute[HtmlResource] = Attribute(name, value, AS_IS)
    }
    
    case class OriginWhiteListAttribute(name: String) extends AttributeSpec {
      def :=(value: Seq[String]): Attribute[js.Array[String]] = Attribute(name, js.Array(value: _*), AS_IS)
    }
  }

}
