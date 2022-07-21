package showcase.app

import scommons.react._
import scommons.react.navigation._
import scommons.react.navigation.stack._
import scommons.react.test._
import scommons.reactnative._
import showcase._
import showcase.app.ReactNativeDemoScreen._

class ReactNativeDemoScreenSpec extends TestSpec with TestRendererUtils {

  it should "render main component" in {
    //given
    val props = ReactNativeDemoScreenProps(navigate = _ => ())
    val component = <(ReactNativeDemoScreen())(^.wrapped := props)()

    //when
    val result = testRender(component)

    //then
    assertTestComponent(result, ShowcaseListView) {
      case ShowcaseListViewProps(items, navigate) =>
        items shouldBe List(
          "ActivityIndicator" -> "Demo ActivityIndicator component",
          "Button" -> "Demo Button component",
          "FlatList" -> "Demo FlatList component",
          "Image" -> "Demo Image component",
          "Modal" -> "Demo Modal component",
          "Alert" -> "Demo Alert component",
          "Switch" -> "Demo Switch component",
          "Platform" -> "Demo Platform API"
        )
        navigate shouldBe props.navigate
    }
  }

  it should "render ReactNative screens" in {
    //given
    val Stack = createStackNavigator()
    val wrapper = new FunctionComponent[Unit] {
      protected def render(props: Props): ReactElement = {
        <.View()(
          getReactNativeScreens(Stack)
        )
      }
    }

    //when
    val result = testRender(<(wrapper())()())

    //then
    assertNativeComponent(result,
      <.View()(
        <(Stack.Screen)(^.name := "ActivityIndicator", ^.component := ActivityIndicatorDemo())(),
        <(Stack.Screen)(^.name := "Button", ^.component := ButtonDemo())(),
        <(Stack.Screen)(^.name := "FlatList", ^.component := FlatListDemo())(),
        <(Stack.Screen)(^.name := "Image", ^.component := ImageDemo())(),
        <(Stack.Screen)(^.name := "Modal", ^.component := ModalDemo())(),
        <(Stack.Screen)(^.name := "Alert", ^.component := AlertDemo())(),
        <(Stack.Screen)(^.name := "Switch", ^.component := switchComp)(),
        <(Stack.Screen)(^.name := "Platform", ^.component := PlatformDemo())()
      )
    )
  }
}
