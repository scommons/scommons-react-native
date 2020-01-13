package showcase.app

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative.ScrollView._
import scommons.reactnative._
import showcase.app.ShowcaseScreen._

class ShowcaseScreenSpec extends TestSpec with ShallowRendererUtils {

  it should "render component" in {
    //given
    val component = <(ShowcaseScreen())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <.ScrollView(
        ^.keyboardShouldPersistTaps := KeyboardShouldPersistTaps.always
      )(
        <.TouchableWithoutFeedback()(
          <.View(^.rnStyle := styles.itemContainer)(
            <.Text(^.rnStyle := styles.itemTitle)("Styles"),
            <.Text(^.rnStyle := styles.itemDescription)("Demo style components")
          )
        )
      )
    )
  }
}
