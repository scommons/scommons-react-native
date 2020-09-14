package showcase.app.community

import scommons.react.test._
import scommons.react.{FunctionComponent, ReactElement}
import scommons.reactnative._
import scommons.reactnative.highlighter._
import scommons.reactnative.htmlview._
import showcase.app.community.SyntaxHighlighterDemo._
import showcase.app.community.SyntaxHighlighterDemoSpec._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportAll

class SyntaxHighlighterDemoSpec extends TestSpec
  with BaseTestSpec
  with ShallowRendererUtils {

  it should "return custom SyntaxHighlighter for pre.code tag when renderNode" in {
    //given
    val preNode = mock[HTMLViewNodeMock]
    val codeNode = mock[HTMLViewNodeMock]
    val textNode = mock[HTMLViewNodeMock]
    val code = "some code text"
    
    (preNode.name _).expects().returning("pre")
    (preNode.children _).expects().returning(js.Array(codeNode.asInstanceOf[HTMLViewNode]))
    (codeNode.name _).expects().returning("code")
    (codeNode.children _).expects().returning(js.Array(textNode.asInstanceOf[HTMLViewNode]))
    (textNode.data _).expects().returning(code)
    
    //when
    val resultComp = SyntaxHighlighterDemo.renderNode(
      node = preNode.asInstanceOf[HTMLViewNode],
      index = 1,
      siblings = js.Array[HTMLViewNode](),
      parent = js.undefined,
      defaultRenderer = null
    )
    
    //then
    val wrapper = new FunctionComponent[Unit] {
      protected def render(props: Props): ReactElement = {
        resultComp.asInstanceOf[ReactElement]
      }
    }.apply()
    val result = shallowRender(<(wrapper)()())
    assertNativeComponent(result,
      <.SyntaxHighlighter(
        ^.key := "1",
        ^.customStyle := customStyle,
        ^.highlighter := "hljs",
        ^.highlighterStyle := HighlightJsStyles.defaultStyle
      )(code)
    )
  }
  
  it should "return undefined for all other nodes when renderNode" in {
    //given
    val node = mock[HTMLViewNodeMock]
    
    (node.name _).expects().returning("div")
    
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
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.Text(^.rnStyle := styles.title)("SyntaxHighlighter:"),
        <.SyntaxHighlighter(
          ^.language := "javascript",
          ^.highlighter := "hljs",
          ^.highlighterStyle := getHighlightJsStyle("github")
            .getOrElse(HighlightJsStyles.defaultStyle)
        )(
          """(num) => num + 1"""
        ),

        <.Text(^.rnStyle := styles.title)("HtmlView with SyntaxHighlighter:"),
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
  trait HTMLViewNodeMock {

    def name: js.UndefOr[String]
    def data: js.UndefOr[String]
    def children: js.Array[HTMLViewNode]
  }
}
