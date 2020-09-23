package showcase.app

import showcase.app.style._
import showcase.app.ui.UiDemoScreen
import scommons.react._
import scommons.react.navigation._
import scommons.react.navigation.stack._
import scommons.react.test._

class ShowcaseScreenSpec extends TestSpec with ShallowRendererUtils {

  it should "render main component" in {
    //given
    val props = ShowcaseScreenProps(navigate = _ => ())
    val component = <(ShowcaseScreen())(^.wrapped := props)()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertComponent(result, ShowcaseListView) {
      case ShowcaseListViewProps(items, navigate) =>
        items shouldBe List(
          "Styles" -> "Demo different styles",
          "DemoTask" -> "Demo API tasks",
          "UI" -> "Demo common UI components"
        )
        navigate shouldBe props.navigate
    }
  }

  it should "render Home screens" in {
    //given
    val Stack = createStackNavigator()
    val wrapper = new FunctionComponent[Unit] {
      protected def render(props: Props): ReactElement = {
        <.>()(
          ShowcaseScreen.getHomeScreens(Stack)
        )
      }
    }

    //when
    val result = shallowRender(<(wrapper())()())

    //then
    assertNativeComponent(result,
      <.>()(
        // styles
        StylesScreen.getStylesStack(Stack),
        // ui
        <(Stack.Screen)(^.name := "DemoTask", ^.component := ShowcaseScreen.demoTaskComp)(),
        UiDemoScreen.getUiStack(Stack)
      )
    )
  }
}
