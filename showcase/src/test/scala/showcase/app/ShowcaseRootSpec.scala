package showcase.app

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative.ScrollView._
import scommons.reactnative._
import showcase.PlatformDemo
import showcase.app.ShowcaseRoot._
import showcase.app.style._

class ShowcaseRootSpec extends TestSpec with ShallowRendererUtils {

  it should "render component" in {
    //given
    val component = <(ShowcaseRoot())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.ScrollView(
          ^.rnStyle := styles.content,
          ^.keyboardShouldPersistTaps := KeyboardShouldPersistTaps.always
        )(
          <.Text()("Border Styles:\n"),
          <(BorderStyleDemo())()(),
  
          <.Text()("Border Radius Styles:\n"),
          <(BorderRadiusDemo())()(),

          <.Text()("Margin Styles:\n"),
          <(MarginStyleDemo())()(),

          <.Text()("Padding Styles:\n"),
          <(PaddingStyleDemo())()(),

          <.Text()("Position Styles:\n"),
          <(PositionStyleDemo())()(),

          <.Text()(s"Platform:\n"),
          <(PlatformDemo())()(),

          <.Text()(s"TextStyle:\n"),
          <(TextStyleDemo())()(),

          <.Text()("Profile Card:\n"),
          <(ProfileCard())()()
        )
      )
    )
  }
}
