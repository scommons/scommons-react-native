package showcase.app.community

import scommons.react._
import scommons.react.navigation._
import scommons.reactnative._
import scommons.reactnative.safearea.SafeArea._
import scommons.reactnative.safearea._
import scommons.reactnative.webview._

import scala.scalajs.js

/** @see https://github.com/react-native-community/react-native-webview/blob/master/docs/Getting-Started.md
  */
object WebViewDemo extends FunctionComponent[Unit] {

  protected def render(props: Props): ReactElement = {
    implicit val theme: Theme = useTheme()
    
    <.SafeAreaView(
      ^.mode := SafeAreaMode.padding, //default
      ^.edges := List(SafeAreaEdge.left, SafeAreaEdge.bottom, SafeAreaEdge.right),
      ^.rnStyle := styles.container
    )(
      <.Text(themeStyle(styles.title, themeTextStyle))("InlineWeb:"),
      <.WebView(
        ^.originWhiteList := Seq("*"),
        ^.htmlSource := new HtmlResource {
          override val html = "<h1>Hello world</h1>"
        }
      )(),

      <.Text(themeStyle(styles.title, themeTextStyle))("WebView:"),
      <.WebView(
        ^.source := new UriResource {
          override val uri = "https://scommons.github.io/"
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
