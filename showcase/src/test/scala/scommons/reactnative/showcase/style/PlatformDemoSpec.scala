package scommons.reactnative.showcase.style

import scommons.react.test.TestSpec
import scommons.react.test.raw.ShallowInstance
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative._
import scommons.reactnative.showcase.style.PlatformDemo._
import scommons.reactnative.test.PlatformMock

class PlatformDemoSpec extends TestSpec with ShallowRendererUtils {

  it should "render ios component" in {
    //given
    PlatformMock.use(Platform.ios)
    val component = <(PlatformDemo())()()

    //when
    val result = shallowRender(component)

    //then
    assertPlatformDemo(result, "ios")
  }
  
  it should "render android component" in {
    //given
    PlatformMock.use(Platform.android)
    val component = <(PlatformDemo())()()

    //when
    val result = shallowRender(component)

    //then
    assertPlatformDemo(result, "android")
  }

  private def assertPlatformDemo(result: ShallowInstance, platform: String): Unit = {
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.Text(^.rnStyle := styles.info)(
          s"You are using $platform platform"
        )
      )
    )
  }
}
