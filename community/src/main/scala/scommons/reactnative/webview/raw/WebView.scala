package scommons.reactnative.webview.raw

import scommons.react.ReactClass

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("react-native-webview", "WebView")
object WebView extends ReactClass

trait HtmlResource extends js.Object {

  val html: String
}
