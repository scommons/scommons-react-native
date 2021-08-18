package showcase

import scommons.react.test._
import scommons.reactnative._
import scommons.reactnative.test.PlatformMock
import showcase.PlatformDemo.styles

class PlatformDemoSpec extends TestSpec with TestRendererUtils {

  it should "render ios component" in {
    //given
    PlatformMock.use(Platform.ios)
    val component = <(PlatformDemo())()()

    //when
    val result = testRender(component)

    //then
    assertPlatformDemo(result, "ios")
  }
  
  it should "render android component" in {
    //given
    PlatformMock.use(Platform.android)
    val component = <(PlatformDemo())()()

    //when
    val result = testRender(component)

    //then
    assertPlatformDemo(result, "android")
  }

  private def assertPlatformDemo(result: TestInstance, platform: String): Unit = {
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.Text(^.rnStyle := styles.info)(
          s"You are using $platform platform"
        )
      )
    )
  }
}
