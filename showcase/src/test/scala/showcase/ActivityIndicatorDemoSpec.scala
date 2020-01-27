package showcase

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative.ActivityIndicator._
import scommons.reactnative._
import showcase.ActivityIndicatorDemo.styles

import scala.scalajs.js

class ActivityIndicatorDemoSpec extends TestSpec with ShallowRendererUtils {

  it should "render component" in {
    //given
    val component = <(ActivityIndicatorDemo())()()

    //when
    val result = shallowRender(component)

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
