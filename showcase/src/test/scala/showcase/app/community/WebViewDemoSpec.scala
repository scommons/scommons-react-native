package showcase.app.community

import scommons.react.test._
import scommons.reactnative._
import scommons.reactnative.safearea.SafeArea._
import scommons.reactnative.safearea._
import scommons.reactnative.webview._
import showcase.app.community.WebViewDemo._

class WebViewDemoSpec extends TestSpec
  with BaseTestSpec
  with ShallowRendererUtils {

  it should "render component" in {
    //given
    val component = <(WebViewDemo())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
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
    )
  }
}
