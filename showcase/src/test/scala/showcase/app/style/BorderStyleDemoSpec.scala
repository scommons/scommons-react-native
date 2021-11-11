package showcase.app.style

import scommons.react.test._
import scommons.reactnative.Style._
import scommons.reactnative._
import showcase.app.style.BorderStyleDemo._

import scala.scalajs.js

class BorderStyleDemoSpec extends TestSpec with TestRendererUtils {

  BorderStyleDemo.exampleComp = mockUiComponent("Example")

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
  
  it should "render main component" in {
    //given
    val component = <(BorderStyleDemo())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <(exampleComp())(^.rnStyle := new Style {
          override val borderWidth = 1
        })(
          <.Text()("borderWidth: 1")
        ),
        <(exampleComp())(^.rnStyle := new Style {
          override val borderWidth = 3
          override val borderLeftWidth = 0
        })(
          <.Text()("borderWidth: 3, borderLeftWidth: 0")
        ),
        <(exampleComp())(^.rnStyle := new Style {
          override val borderWidth = 3
          override val borderLeftColor = Color.red
        })(
          <.Text()("borderWidth: 3, borderLeftColor: 'red'")
        ),
        <(exampleComp())(^.rnStyle := new Style {
          override val borderLeftWidth = 3
        })(
          <.Text()("borderLeftWidth: 3")
        ),
        <(exampleComp())(^.rnStyle := new Style {
          override val borderWidth = 1
          override val borderStyle = BorderStyle.dashed
        })(
          <.Text()("borderWidth: 1, borderStyle: 'dashed'")
        )
      )
    )
  }
}
