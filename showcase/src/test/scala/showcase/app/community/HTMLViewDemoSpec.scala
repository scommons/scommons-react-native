package showcase.app.community

import scommons.react.{FunctionComponent, ReactElement}
import scommons.react.test._
import scommons.reactnative._
import scommons.reactnative.htmlview._
import showcase.app.community.HTMLViewDemo._
import showcase.app.community.HTMLViewDemoSpec._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportAll

class HTMLViewDemoSpec extends TestSpec
  with BaseTestSpec
  with ShallowRendererUtils {

  it should "return custom text component if custom node when renderNode" in {
    //given
    val node = mock[HTMLViewNodeMock]
    val specialStyle = js.Dynamic.literal(
      "style" -> js.Dynamic.literal(
        "width" -> "123"
      )
    )
    
    (node.name _).expects().returning("custom")
    (node.attribs _).expects().returning(specialStyle)
    (node.children _).expects().returning(js.Array[HTMLViewNode]())
    
    //when
    val resultComp = HTMLViewDemo.renderNode(
      node = node.asInstanceOf[HTMLViewNode],
      index = 1,
      siblings = js.Array[HTMLViewNode](),
      parent = js.undefined,
      defaultRenderer = { (_, _) =>
        "test".asInstanceOf[ReactElement]
      }
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
        "test"
      )
    )
  }
  
  it should "return undefined for all other nodes when renderNode" in {
    //given
    val node = mock[HTMLViewNodeMock]
    
    (node.name _).expects().returning("div")
    
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
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.Text(^.rnStyle := styles.title)("Simple Html:"),
        <.HTMLView(
          ^.value := "<h1>Rendered from html!</h1>"
        )(),

        <.Text(^.rnStyle := styles.title)("Html with custom styles/tags:"),
        <.HTMLView(
          ^.stylesheet := htmlStyles,
          ^.value :=
            """<h1>Custom style example</h1>
              |<div>
              |  <custom>Rendered with custom tag/style</custom>
              |</div>
              |""".stripMargin
        )()
      )
    )
  }
}

object HTMLViewDemoSpec {

  @JSExportAll
  trait HTMLViewNodeMock {

    def `type`: String
    def name: js.UndefOr[String]
    def attribs: js.Dynamic
    def data: js.UndefOr[String]

    def parent: js.UndefOr[HTMLViewNode]
    def children: js.Array[HTMLViewNode]
  }
}
