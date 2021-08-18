package showcase.app.ui

import scommons.react._
import scommons.react.navigation._
import scommons.react.navigation.stack._
import scommons.react.test._
import scommons.reactnative._
import showcase.app._

class UiDemoScreenSpec extends TestSpec with TestRendererUtils {

  it should "render main component" in {
    //given
    val props = UiDemoScreenProps(navigate = _ => ())
    val component = <(UiDemoScreen())(^.wrapped := props)()

    //when
    val result = testRender(component)

    //then
    assertTestComponent(result, ShowcaseListView) {
      case ShowcaseListViewProps(items, navigate) =>
        items shouldBe List(
          "ChoiceGroup" -> "Demo ChoiceGroup component"
        )
        navigate shouldBe props.navigate
    }
  }

  it should "render UI screens" in {
    //given
    val stack = createStackNavigator()
    val wrapper = new FunctionComponent[Unit] {
      protected def render(props: Props): ReactElement = {
        <.View()(
          UiDemoScreen.getUiStack(stack)
        )
      }
    }
    
    //when
    val result = testRender(<(wrapper())()())
    
    //then
    assertNativeComponent(result,
      <.View()(
        <(stack.Screen)(^.name := "UI", ^.component := UiDemoController())(),
        <(stack.Screen)(^.name := "ChoiceGroup", ^.component := ChoiceGroupDemo())()
      )
    )
  }
}
