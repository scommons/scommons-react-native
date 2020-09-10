package showcase.app.community

import scommons.nodejs.test.AsyncTestSpec
import scommons.react.test._
import scommons.reactnative._
import scommons.reactnative.webview._
import showcase.app.community.WebViewDemo._

class WebViewDemoSpec extends AsyncTestSpec
  with BaseTestSpec
  with ShallowRendererUtils {

  it should "render component" in {
    //given
    val component = <(WebViewDemo())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
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
