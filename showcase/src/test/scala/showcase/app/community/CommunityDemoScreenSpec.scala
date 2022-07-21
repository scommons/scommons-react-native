package showcase.app.community

import scommons.react._
import scommons.react.navigation._
import scommons.react.navigation.stack._
import scommons.react.test._
import scommons.reactnative._
import showcase.app.{ShowcaseListView, ShowcaseListViewProps}

class CommunityDemoScreenSpec extends TestSpec with TestRendererUtils {

  it should "render main component" in {
    //given
    val props = CommunityDemoScreenProps(navigate = _ => ())
    val component = <(CommunityDemoScreen())(^.wrapped := props)()

    //when
    val result = testRender(component)

    //then
    assertTestComponent(result, ShowcaseListView) {
      case ShowcaseListViewProps(items, navigate) =>
        items shouldBe List(
          "Picker" -> "Demo Picker component",
          "Svg" -> "Demo Svg components",
          "WebView" -> "Demo WebView components",
          "HTMLView" -> "Demo HTMLView components",
          "SyntaxHighlighter" -> "Demo SyntaxHighlighter components"
        )
        navigate shouldBe props.navigate
    }
  }

  it should "render community screens" in {
    //given
    val Stack = createStackNavigator()
    val wrapper = new FunctionComponent[Unit] {
      protected def render(props: Props): ReactElement = {
        <.View()(
          CommunityDemoScreen.getCommunityScreens(Stack)
        )
      }
    }

    //when
    val result = testRender(<(wrapper())()())

    //then
    assertNativeComponent(result,
      <.View()(
        <(Stack.Screen)(^.name := "Picker", ^.component := PickerDemo())(),
        <(Stack.Screen)(^.name := "Svg", ^.component := SvgDemo())(),
        <(Stack.Screen)(^.name := "WebView", ^.component := WebViewDemo())(),
        <(Stack.Screen)(^.name := "HTMLView", ^.component := HTMLViewDemo())(),
        <(Stack.Screen)(^.name := "SyntaxHighlighter", ^.component := SyntaxHighlighterDemo())()
      )
    )
  }
}
