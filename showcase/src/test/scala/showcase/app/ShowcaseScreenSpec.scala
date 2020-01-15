package showcase.app

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative.ScrollView._
import scommons.reactnative._
import showcase.app.ShowcaseScreen._

class ShowcaseScreenSpec extends TestSpec with ShallowRendererUtils {

  it should "call navigate when onPress" in {
    //given
    val navigate = mockFunction[String, Unit]
    val props = ShowcaseScreenProps(navigate = navigate)
    val comp = shallowRender(<(ShowcaseScreen())(^.wrapped := props)())
    val List(touchable) = findComponents(comp, raw.TouchableWithoutFeedback)

    //then
    navigate.expects("Styles")

    //when
    touchable.props.onPress()
  }

  it should "render component" in {
    //given
    val props = ShowcaseScreenProps(navigate = _ => ())
    val component = <(ShowcaseScreen())(^.wrapped := props)()
    
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
