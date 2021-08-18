package showcase.app.style

import scommons.react._
import scommons.react.test._
import scommons.reactnative._
import showcase.app.style.PositionStyleDemo._

import scala.scalajs.js

class PositionStyleDemoSpec extends TestSpec with TestRendererUtils {

  PositionStyleDemo.exampleComp = () => "Example".asInstanceOf[ReactClass]
  PositionStyleDemo.centeredTextComp = () => "CenteredText".asInstanceOf[ReactClass]

  it should "render Example component" in {
    //given
    val style = new Style {
      override val borderWidth = 1
    }
    val component = <(Example())(^.rnStyle := style)(
      <.Text()("borderWidth: 1")
    )
    
    //when
    val result = testRender(component)
    
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
    val result = testRender(component)

    //then
    assertNativeComponent(result,
      <.Text(^.rnStyle := js.Array(styles.centeredText, style))(
        "Example 1:\n4 Rounded Corners"
      )
    )
  }

  it should "render main component" in {
    //given
    val component = <(PositionStyleDemo())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.screen)(
        <.View(^.rnStyle := styles.container)(
          <.View(^.rnStyle := styles.row)(
            <(exampleComp())()(
              <(centeredTextComp())()("A")
            ),
            <(exampleComp())()(
              <(centeredTextComp())()("B"),
              <.View(^.rnStyle := js.Array(styles.tinyExample, styles.positionAbsolute))(
                <(centeredTextComp())()("E")
              )
            ),
            <(exampleComp())()(
              <(centeredTextComp())()("C")
            )
          ),
          <(exampleComp())(^.rnStyle := styles.positionAbsolute)(
            <(centeredTextComp())()("D")
          )
        )
      )
    )
  }
}
