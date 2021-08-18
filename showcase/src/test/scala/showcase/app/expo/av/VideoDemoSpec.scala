package showcase.app.expo.av

import scommons.expo.av._
import scommons.react.test._
import scommons.reactnative._
import showcase.app.expo.av.VideoDemo.styles

class VideoDemoSpec extends TestSpec with TestRendererUtils {

  it should "render component" in {
    //given
    val component = <(VideoDemo())()()

    //when
    val result = testRender(component)

    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.Video(
          ^.rnStyle := styles.mediaPlayer,
          ^.expoAVSource := new ExpoAVSource {
            override val uri = "http://d23dyxeqlo5psv.cloudfront.net/big_buck_bunny.mp4"
          },
          ^.shouldPlay := true,
          ^.useNativeControls := true
        )()
      )
    )
  }
}
