package scommons.reactnative.showcase

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative._
import scommons.reactnative.showcase.ShowcaseApp._
import scommons.reactnative.showcase.style._

class ShowcaseAppSpec extends TestSpec with ShallowRendererUtils {

  it should "render component" in {
    //given
    val component = <(ShowcaseApp())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.ScrollView(
          ^.rnStyle := styles.content,
          ^.keyboardShouldPersistTaps := "always"
        )(
          <.Text()("Border Styles:\n"),
          <(BorderStyleDemo())()(),
  
          <.Text()("Border Radius Styles:\n"),
          <(BorderRadiusDemo())()(),

          <.Text()("Profile Card:\n"),
          <(ProfileCard())()()
        )
      )
    )
  }
}
