package showcase.app

import showcase.app.expo.av._
import showcase.app.style._
import scommons.react.navigation._
import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils

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
          "Styles" -> "Demo style components",
          "Video" -> "Demo video components",
          "DemoTask" -> "Demo API task components"
        )
        navigate shouldBe props.navigate
    }
  }

  it should "render homeStackComp" in {
    //given
    val Stack = ShowcaseScreen.Stack
    val component = <(ShowcaseScreen.homeStackComp).empty

    //when
    val result = shallowRender(component)

    //then
    assertNativeComponent(result,
      <(Stack.Navigator)(^.initialRouteName := "Showcase")(
        <(Stack.Screen)(^.name := "Showcase", ^.component := ShowcaseController())(),
        // styles
        StylesScreen.getStylesStack(Stack),
        // expo
        <(Stack.Screen)(^.name := "Video", ^.component := VideoDemo())(),
        // ui
        <(Stack.Screen)(^.name := "DemoTask", ^.component := ShowcaseScreen.demoTaskComp)()
      )
    )
  }
}
