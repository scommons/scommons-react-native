package showcase.app.ui

import showcase.app._
import scommons.react._
import scommons.react.navigation._
import scommons.react.test._

class UiDemoScreenSpec extends TestSpec with ShallowRendererUtils {

  it should "render main component" in {
    //given
    val props = UiDemoScreenProps(navigate = _ => ())
    val component = <(UiDemoScreen())(^.wrapped := props)()

    //when
    val result = shallowRender(component)

    //then
    assertComponent(result, ShowcaseListView) {
      case ShowcaseListViewProps(items, navigate) =>
        items shouldBe List(
          "ChoiceGroup" -> "Demo ChoiceGroup component"
        )
        navigate shouldBe props.navigate
    }
  }

  it should "render UI stack" in {
    //given
    val stack = ShowcaseScreen.Stack
    val wrapper = new FunctionComponent[Unit] {
      protected def render(props: Props): ReactElement = {
        <.>()(
          UiDemoScreen.getUiStack(stack)
        )
      }
    }
    
    //when
    val result = shallowRender(<(wrapper())()())
    
    //then
    assertNativeComponent(result,
      <.>()(
        <(stack.Screen)(^.name := "UI", ^.component := UiDemoController())(),
        <(stack.Screen)(^.name := "ChoiceGroup", ^.component := ChoiceGroupDemo())()
      )
    )
  }
}
