package showcase.app.style

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative._
import showcase.app.style.PaddingStyleDemo._

import scala.scalajs.js

class PaddingStyleDemoSpec extends TestSpec with ShallowRendererUtils {

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
    val component = <(PaddingStyleDemo())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.View(^.rnStyle := styles.exampleContainer)(
          <(Example())()(
            <(CenteredText())()("A")
          )
        ),
        <.View(^.rnStyle := styles.exampleContainer)(
          <(Example())(^.rnStyle := new Style {
            override val paddingTop = 50
          })(
            <(CenteredText())()("B")
          )
        ),
        <.View(^.rnStyle := styles.exampleContainer)(
          <(Example())(^.rnStyle := new Style {
            override val paddingTop = 50
            override val paddingLeft = 10
          })(
            <(CenteredText())()("C")
          )
        ),
        <.View(^.rnStyle := styles.exampleContainer)(
          <(Example())(^.rnStyle := new Style {
            override val paddingLeft = -10
            override val paddingTop = -10
          })(
            <(CenteredText())()("D")
          )
        )
      )
    )
  }
}
