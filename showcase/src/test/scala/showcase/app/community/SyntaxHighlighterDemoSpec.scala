package showcase.app.community

import scommons.react._
import scommons.react.navigation._
import scommons.react.test._
import scommons.reactnative._
import scommons.reactnative.highlighter._
import scommons.reactnative.htmlview._
import showcase.app.community.SyntaxHighlighterDemo._
import showcase.app.community.SyntaxHighlighterDemoSpec._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportAll

class SyntaxHighlighterDemoSpec extends TestSpec with TestRendererUtils {

  it should "return custom SyntaxHighlighter for pre.code tag when renderNode" in {
    //given
    val code = "some code text"
    val textNode = new HTMLViewNodeMock(
      dataMock = code
    )
    val codeNode = new HTMLViewNodeMock(
      nameMock = "code",
      childrenMock = js.Array(textNode.asInstanceOf[HTMLViewNode])
    )
    val preNode = new HTMLViewNodeMock(
      nameMock = "pre",
      childrenMock = js.Array(codeNode.asInstanceOf[HTMLViewNode])
    )
    
    //when
    val resultComp = SyntaxHighlighterDemo.renderNode(
      node = preNode.asInstanceOf[HTMLViewNode],
      index = 1,
      siblings = js.Array[HTMLViewNode](),
      parent = js.undefined,
      defaultRenderer = null
    )
    resultComp should not be js.undefined
    
    //then
    val result = createTestRenderer(resultComp.asInstanceOf[ReactElement]).root
    assertNativeComponent(result,
      <.SyntaxHighlighter(
        ^.PreTag := <.Text.reactClass,
        ^.CodeTag := <.Text.reactClass,
        ^.customStyle := customStyle,
        ^.highlighter := "hljs",
        ^.highlighterStyle := HighlightJsStyles.defaultStyle
      )(code)
    )
  }
  
  it should "return undefined for all other nodes when renderNode" in {
    //given
    val node = new HTMLViewNodeMock(
      nameMock = "div"
    )
    
    //when
    val result = SyntaxHighlighterDemo.renderNode(
      node = node.asInstanceOf[HTMLViewNode],
      index = 0,
      siblings = js.Array[HTMLViewNode](),
      parent = js.undefined,
      defaultRenderer = null
    )
    
    //then
    result shouldBe js.undefined
  }
  
  it should "render component" in {
    //given
    val component = <(SyntaxHighlighterDemo())()()
    
    //when
    val result = testRender(component)
    
    //then
    implicit val theme: Theme = DefaultTheme
    
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.Text(themeStyle(styles.title, themeTextStyle))("SyntaxHighlighter:"),
        <.SyntaxHighlighter(
          ^.language := "javascript",
          ^.highlighter := "hljs",
          ^.highlighterStyle := getHighlightJsStyle("github")
            .getOrElse(HighlightJsStyles.defaultStyle)
        )(
          """(num) => num + 1"""
        ),

        <.Text(themeStyle(styles.title, themeTextStyle))("HtmlView with SyntaxHighlighter:"),
        <.HTMLView(
          ^.value :=
            """<pre>
              |  <code>val test = 1 + 2;</code>
              |</pre>
              |""".stripMargin
        )()
      )
    )
  }
}

object SyntaxHighlighterDemoSpec {

  @JSExportAll
  class HTMLViewNodeMock(
                          nameMock: js.UndefOr[String] = js.undefined,
                          dataMock: js.UndefOr[String] = js.undefined,
                          childrenMock: js.Array[HTMLViewNode] = null
                        ) {

    def name: js.UndefOr[String] = nameMock
    def data: js.UndefOr[String] = dataMock
    def children: js.Array[HTMLViewNode] = childrenMock
  }
}
