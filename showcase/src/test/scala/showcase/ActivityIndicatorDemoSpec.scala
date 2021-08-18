package showcase

import scommons.react.test._
import scommons.reactnative.ActivityIndicator._
import scommons.reactnative._
import showcase.ActivityIndicatorDemo.styles

import scala.scalajs.js

class ActivityIndicatorDemoSpec extends TestSpec with TestRendererUtils {

  it should "render component" in {
    //given
    val component = <(ActivityIndicatorDemo())()()

    //when
    val result = testRender(component)

    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := js.Array(styles.container, styles.horizontal))(
        <.ActivityIndicator(^.aiSize := ActivityIndicatorSize.large, ^.color := "#0000ff")(),
        <.ActivityIndicator(^.aiSize := ActivityIndicatorSize.small, ^.color := "#00ff00")(),
        <.ActivityIndicator(^.aiSize := ActivityIndicatorSize.large, ^.color := "#0000ff")(),
        <.ActivityIndicator(^.aiSize := ActivityIndicatorSize.small, ^.color := "#00ff00")()
      )
    )
  }
}
