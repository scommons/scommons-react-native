package showcase.app.community

import scommons.react.navigation._
import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import showcase.app.{ShowcaseListView, ShowcaseListViewProps}

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

  it should "render communityStackComp" in {
    //given
    val Stack = CommunityDemoScreen.Stack
    val component = <(CommunityDemoScreen.communityStackComp).empty

    //when
    val result = shallowRender(component)

    //then
    assertNativeComponent(result,
      <(Stack.Navigator)(^.initialRouteName := "Community")(
        <(Stack.Screen)(^.name := "Community", ^.component := CommunityDemoController())(),
        <(Stack.Screen)(^.name := "Svg", ^.component := SvgDemo())(),
        <(Stack.Screen)(^.name := "WebView", ^.component := WebViewDemo())(),
        <(Stack.Screen)(^.name := "HTMLView", ^.component := HTMLViewDemo())(),
        <(Stack.Screen)(^.name := "SyntaxHighlighter", ^.component := SyntaxHighlighterDemo())()
      )
    )
  }
}
