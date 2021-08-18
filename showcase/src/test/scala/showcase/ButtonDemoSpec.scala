package showcase

import scommons.react.test._
import scommons.reactnative._
import showcase.ButtonDemo.styles

import scala.scalajs.js

class ButtonDemoSpec extends TestSpec with TestRendererUtils {

  it should "render component" in {
    //given
    val component = <(ButtonDemo())()()

    //when
    val result = testRender(component)

    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := js.Array(styles.container, styles.horizontal))(
        <.Button(^.title := "Press me", ^.color := "#0000ff")(),
        <.Button(^.title := "Press me", ^.color := "#00ff00")()
      )
    )
  }
}
