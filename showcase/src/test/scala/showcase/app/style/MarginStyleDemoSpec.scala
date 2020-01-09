package showcase.app.style

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative._
import showcase.app.style.MarginStyleDemo._

import scala.scalajs.js

class MarginStyleDemoSpec extends TestSpec with ShallowRendererUtils {

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
    val component = <(MarginStyleDemo())()()
    
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
            override val marginTop = 50
          })(
            <(CenteredText())()("B")
          )
        ),
        <.View(^.rnStyle := styles.exampleContainer)(
          <(Example())(^.rnStyle := new Style {
            override val marginTop = 50
            override val marginLeft = 10
          })(
            <(CenteredText())()("C")
          )
        ),
        <.View(^.rnStyle := styles.exampleContainer)(
          <(Example())(^.rnStyle := new Style {
            override val marginLeft = -10
            override val marginTop = -10
          })(
            <(CenteredText())()("D")
          )
        )
      )
    )
  }
}
