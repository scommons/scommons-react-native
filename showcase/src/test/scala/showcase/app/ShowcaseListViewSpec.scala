package showcase.app

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative.ScrollView._
import scommons.reactnative._
import showcase.app.ShowcaseListView._

class ShowcaseListViewSpec extends TestSpec with ShallowRendererUtils {

  it should "call navigate when onPress" in {
    //given
    val navigate = mockFunction[String, Unit]
    val props = getShowcaseListViewProps(navigate = navigate)
    val comp = shallowRender(<(ShowcaseListView())(^.wrapped := props)())
    val List(touchable) = findComponents(comp, raw.TouchableWithoutFeedback)

    //then
    navigate.expects("Test")

    //when
    touchable.props.onPress()
  }

  it should "render component" in {
    //given
    val props = getShowcaseListViewProps()
    val component = <(ShowcaseListView())(^.wrapped := props)()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <.ScrollView(
        ^.keyboardShouldPersistTaps := KeyboardShouldPersistTaps.always
      )(
        <.TouchableWithoutFeedback(^.key := "Test")(
          <.View(^.rnStyle := styles.itemContainer)(
            <.Text(^.rnStyle := styles.itemTitle)("Test"),
            <.Text(^.rnStyle := styles.itemDescription)("Test Item")
          )
        )
      )
    )
  }
  
  private def getShowcaseListViewProps(navigate: String => Unit = _ => ()): ShowcaseListViewProps = {
    ShowcaseListViewProps(
      items = List(
        "Test" -> "Test Item"
      ),
      navigate = navigate
    )
  }
}
