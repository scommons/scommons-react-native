package scommons.reactnative.showcase.style

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative._
import scommons.reactnative.showcase.style.BorderStyleDemo._

import scala.scalajs.js

class BorderStyleDemoSpec extends TestSpec with ShallowRendererUtils {

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
  
  it should "render main component" in {
    //given
    val component = <(BorderStyleDemo())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <(Example())(^.rnStyle := new Style {
          override val borderWidth = 1
        })(
          <.Text()("borderWidth: 1")
        ),
        <(Example())(^.rnStyle := new Style {
          override val borderWidth = 3
          override val borderLeftWidth = 0
        })(
          <.Text()("borderWidth: 3, borderLeftWidth: 0")
        ),
        <(Example())(^.rnStyle := new Style {
          override val borderWidth = 3
          override val borderLeftColor = "red"
        })(
          <.Text()("borderWidth: 3, borderLeftColor: 'red'")
        ),
        <(Example())(^.rnStyle := new Style {
          override val borderLeftWidth = 3
        })(
          <.Text()("borderLeftWidth: 3")
        ),
        <(Example())(^.rnStyle := new Style {
          override val borderWidth = 1
          override val borderStyle = "dashed"
        })(
          <.Text()("borderWidth: 1, borderStyle: 'dashed'")
        )
      )
    )
  }
}