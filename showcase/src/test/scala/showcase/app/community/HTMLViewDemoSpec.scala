package showcase.app.community

import scommons.react.{FunctionComponent, ReactElement}
import scommons.react.test._
import scommons.react.navigation._
import scommons.reactnative._
import scommons.reactnative.htmlview._
import showcase.app.community.HTMLViewDemo._
import showcase.app.community.HTMLViewDemoSpec.HTMLViewNodeMock

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportAll

class HTMLViewDemoSpec extends TestSpec with ShallowRendererUtils {

  it should "return custom text component if custom node when renderNode" in {
    //given
    val textNode = new HTMLViewNodeMock(
      dataMock = "custom node text"
    )
    val specialStyle = js.Dynamic.literal(
      "style" -> js.Dynamic.literal(
        "width" -> "123"
      )
    )
    val customNode = new HTMLViewNodeMock(
      nameMock = "custom",
      attribsMock = specialStyle,
      childrenMock = js.Array(textNode.asInstanceOf[HTMLViewNode])
    )
    
    //when
    val resultComp = HTMLViewDemo.renderNode(
      node = customNode.asInstanceOf[HTMLViewNode],
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
      <.Text(
        ^.key := "1",
        ^.rnStyle := js.Array(specialStyle.style.asInstanceOf[Style], styles.customText)
      )(
        "custom node text"
      )
    )
  }
  
  it should "return undefined for all other nodes when renderNode" in {
    //given
    val node = new HTMLViewNodeMock(
      nameMock = "div"
    )
    
    //when
    val result = HTMLViewDemo.renderNode(
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
    val component = <(HTMLViewDemo())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    implicit val theme: Theme = DefaultTheme
    val textProps = ^.textComponentProps := {
      val attrs = new js.Object {
        val style = themeTextStyle
      }
      attrs
    }

    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.Text(themeStyle(styles.title, themeTextStyle))("Simple Html:"),
        <.HTMLView(
          textProps,
          ^.value := "<h1>Rendered from html!</h1>"
        )(),

        <.Text(themeStyle(styles.title, themeTextStyle))("Html with custom styles/tags:"),
        <.HTMLView(
          textProps,
          ^.stylesheet := htmlStyles,
          ^.value :=
            """<h1>Custom style example</h1>
              |Some custom <b>&lt;tag&gt;</b> style:
              |<div>
              |  <custom>Rendered with &lt;custom&gt; tag/style</custom>
              |</div>
              |""".stripMargin
        )()
      )
    )
  }
}

object HTMLViewDemoSpec {

  @JSExportAll
  class HTMLViewNodeMock(
                          typeMock: String = null,
                          nameMock: js.UndefOr[String] = js.undefined,
                          attribsMock: js.Dynamic = null,
                          dataMock: js.UndefOr[String] = js.undefined,
                          parentMock: js.UndefOr[HTMLViewNode] = js.undefined,
                          childrenMock: js.Array[HTMLViewNode] = null
                        ) {

    def `type`: String = typeMock
    def name: js.UndefOr[String] = nameMock
    def attribs: js.Dynamic = attribsMock
    def data: js.UndefOr[String] = dataMock

    def parent: js.UndefOr[HTMLViewNode] = parentMock
    def children: js.Array[HTMLViewNode] = childrenMock
  }
}
