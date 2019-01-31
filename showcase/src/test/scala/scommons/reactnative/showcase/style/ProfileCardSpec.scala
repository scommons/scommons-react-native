package scommons.reactnative.showcase.style

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative._
import scommons.reactnative.showcase.style.ProfileCard._

class ProfileCardSpec extends TestSpec with ShallowRendererUtils {

  it should "render component" in {
    //given
    val component = <(ProfileCard())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.View(^.rnStyle := styles.cardContainer)(
          <.View(^.rnStyle := styles.cardImageContainer)(
            <.Image(^.rnStyle := styles.cardImage, ^.source := StyleImages.User)()
          )
        )
      )
    )
  }
}
