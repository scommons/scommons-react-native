package showcase.app.style

import scommons.react._
import scommons.react.navigation._
import scommons.react.navigation.stack._
import scommons.react.test._
import scommons.reactnative._
import showcase.app._

class StylesScreenSpec extends TestSpec with TestRendererUtils {

  it should "render main component" in {
    //given
    val props = StylesScreenProps(navigate = _ => ())
    val component = <(StylesScreen())(^.wrapped := props)()

    //when
    val result = testRender(component)

    //then
    assertTestComponent(result, ShowcaseListView) {
      case ShowcaseListViewProps(items, navigate) =>
        items shouldBe List(
          "BorderStyle" -> "Demo border styles",
          "BorderRadius" -> "Demo border radius styles",
          "MarginStyle" -> "Demo margin styles",
          "PaddingStyle" -> "Demo padding styles",
          "PositionStyle" -> "Demo position styles",
          "TextStyle" -> "Demo text styles",
          "ProfileCard" -> "Demo ProfileCard component"
        )
        navigate shouldBe props.navigate
    }
  }

  it should "render Styles screens" in {
    //given
    val stack = createStackNavigator()
    val wrapper = new FunctionComponent[Unit] {
      protected def render(props: Props): ReactElement = {
        <.View()(
          StylesScreen.getStylesStack(stack)
        )
      }
    }
    
    //when
    val result = testRender(<(wrapper())()())
    
    //then
    assertNativeComponent(result,
      <.View()(
        <(stack.Screen)(^.name := "Styles", ^.component := StylesScreenController())(),
        <(stack.Screen)(^.name := "BorderStyle", ^.component := BorderStyleDemo())(),
        <(stack.Screen)(^.name := "BorderRadius", ^.component := BorderRadiusDemo())(),
        <(stack.Screen)(^.name := "MarginStyle", ^.component := MarginStyleDemo())(),
        <(stack.Screen)(^.name := "PaddingStyle", ^.component := PaddingStyleDemo())(),
        <(stack.Screen)(^.name := "PositionStyle", ^.component := PositionStyleDemo())(),
        <(stack.Screen)(^.name := "TextStyle", ^.component := TextStyleDemo())(),
        <(stack.Screen)(^.name := "ProfileCard", ^.component := ProfileCard())()
      )
    )
  }
}
