package showcase.app.community

import scommons.react._
import scommons.reactnative._
import scommons.reactnative.safearea.SafeArea._
import scommons.reactnative.safearea._
import scommons.reactnative.webview._

import scala.scalajs.js

/** @see https://github.com/react-native-community/react-native-webview/blob/master/docs/Getting-Started.md
  */
object WebViewDemo extends FunctionComponent[Unit] {

  protected def render(props: Props): ReactElement = {
    <.SafeAreaView(
      ^.mode := SafeAreaMode.padding, //default
      ^.edges := List(SafeAreaEdge.left, SafeAreaEdge.bottom, SafeAreaEdge.right),
      ^.rnStyle := styles.container
    )(
      <.Text(^.rnStyle := styles.title)("InlineWeb:"),
      <.WebView(
        ^.originWhiteList := Seq("*"),
        ^.htmlSource := new HtmlResource {
          override val html = "<h1>Hello world</h1>"
        }
      )(),
      
      <.Text(^.rnStyle := styles.title)("WebView:"),
      <.WebView(
        ^.source := new UriResource {
          override val uri = "https://scommons.org/"
        }
      )()
    )
  }

  private[community] lazy val styles = StyleSheet.create(new Styles)
  private[community] class Styles extends js.Object {

    val container: Style = new ViewStyle {
      override val flex = 1
    }
    val title: Style = new TextStyle {
      override val marginTop = 15
      override val marginBottom = 5
    }
  }
}
