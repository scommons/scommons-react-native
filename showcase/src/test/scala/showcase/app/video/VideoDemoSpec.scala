package showcase.app.video

import scommons.expo.av._
import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative._
import showcase.app.video.VideoDemo.styles

class VideoDemoSpec extends TestSpec with ShallowRendererUtils {

  it should "render component" in {
    //given
    val component = <(VideoDemo())()()

    //when
    val result = shallowRender(component)

    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.Video(
          ^.rnStyle := styles.mediaPlayer,
          ^.expoAVSource := new ExpoAVSource {
            override val uri = "https://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"
          },
          ^.shouldPlay := true,
          ^.useNativeControls := true
        )()
      )
    )
  }
}
