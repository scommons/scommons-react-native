package showcase.app.community

import showcase.app.{ShowcaseListView, ShowcaseListViewProps}
import scommons.react._
import scommons.react.navigation._
import scommons.react.navigation.stack._
import scommons.react.test._

class CommunityDemoScreenSpec extends TestSpec with ShallowRendererUtils {

  it should "render main component" in {
    //given
    val props = CommunityDemoScreenProps(navigate = _ => ())
    val component = <(CommunityDemoScreen())(^.wrapped := props)()

    //when
    val result = shallowRender(component)

    //then
    assertComponent(result, ShowcaseListView) {
      case ShowcaseListViewProps(items, navigate) =>
        items shouldBe List(
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
        <.>()(
          CommunityDemoScreen.getCommunityScreens(Stack)
        )
      }
    }

    //when
    val result = shallowRender(<(wrapper())()())

    //then
    assertNativeComponent(result,
      <.>()(
        <(Stack.Screen)(^.name := "Svg", ^.component := SvgDemo())(),
        <(Stack.Screen)(^.name := "WebView", ^.component := WebViewDemo())(),
        <(Stack.Screen)(^.name := "HTMLView", ^.component := HTMLViewDemo())(),
        <(Stack.Screen)(^.name := "SyntaxHighlighter", ^.component := SyntaxHighlighterDemo())()
      )
    )
  }
}
