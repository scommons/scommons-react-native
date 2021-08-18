package showcase.app.community

import scommons.react.navigation._
import scommons.react.test._
import scommons.reactnative._
import scommons.reactnative.safearea.SafeArea._
import scommons.reactnative.safearea._
import scommons.reactnative.webview._
import showcase.app.community.WebViewDemo._

class WebViewDemoSpec extends TestSpec with TestRendererUtils {

  it should "render component" in {
    //given
    val component = <(WebViewDemo())()()
    
    //when
    val result = testRender(component)
    
    //then
    implicit val theme: Theme = DefaultTheme
    assertNativeComponent(result,
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
            override val uri = "https://scommons.org/"
          }
        )()
      )
    )
  }
}
