package showcase.app.style

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative._
import showcase.app.style.BorderRadiusDemo._

import scala.scalajs.js

class BorderRadiusDemoSpec extends TestSpec with ShallowRendererUtils {

  it should "render Example component" in {
    //given
    val style = new Style {
      override val borderWidth = 1
    }
    val component = <(Example())(^.rnStyle := style)(
      <.Text()("borderWidth: 1")
    )

    //when
    val result = shallowRender(component)

    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := js.Array(styles.example, style))(
        <.Text()("borderWidth: 1")
      )
    )
  }

  it should "render CenteredText component" in {
    //given
    val style = new Style {
      override val borderWidth = 1
    }
    val component = <(CenteredText())(^.rnStyle := style)(
      "Example 1:\n4 Rounded Corners"
    )

    //when
    val result = shallowRender(component)

    //then
    assertNativeComponent(result,
      <.Text(^.rnStyle := js.Array(styles.centeredText, style))(
        "Example 1:\n4 Rounded Corners"
      )
    )
  }

  it should "render main component" in {
    //given
    val component = <(BorderRadiusDemo())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <(Example())(^.rnStyle := new Style {
          override val borderRadius = 20
        })(
          <(CenteredText())()("Example 1:\n4 Rounded Corners")
        ),
        <(Example())(^.rnStyle := new Style {
          override val borderTopRightRadius = 60
          override val borderBottomRightRadius = 60
        })(
          <(CenteredText())()("Example 2:\nD Shape")
        ),
        <(Example())(^.rnStyle := new Style {
          override val borderTopLeftRadius = 30
          override val borderBottomRightRadius = 30
        })(
          <(CenteredText())()("Example 3:\nLeaf Shape")
        ),
        <(Example())(^.rnStyle := new Style {
          override val borderRadius = 60
        })(
          <(CenteredText())()("Example 4:\nCircle")
        )
      )
    )
  }
}
