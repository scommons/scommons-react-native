package showcase.app

import scommons.react.test._
import scommons.reactnative.ScrollView._
import scommons.reactnative.{raw, _}
import showcase.app.ShowcaseListView._

class ShowcaseListViewSpec extends TestSpec with TestRendererUtils {

  it should "call navigate when onPress" in {
    //given
    val navigate = mockFunction[String, Unit]
    val props = getShowcaseListViewProps(navigate = navigate)
    val comp = testRender(<(ShowcaseListView())(^.wrapped := props)())
    val touchable = inside(findComponents(comp, raw.TouchableWithoutFeedback)) {
      case List(touchable) => touchable
    }

    //then
    navigate.expects(*).onCall { resRoute: String =>
      resRoute shouldBe "Test"
      ()
    }

    //when
    touchable.props.onPress()
  }

  it should "render component" in {
    //given
    val props = getShowcaseListViewProps()
    val component = <(ShowcaseListView())(^.wrapped := props)()
    
    //when
    val result = testRender(component)
    
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
