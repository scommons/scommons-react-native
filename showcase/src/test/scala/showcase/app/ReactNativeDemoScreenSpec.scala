package showcase.app

import showcase._
import scommons.react._
import scommons.react.navigation._
import scommons.react.navigation.stack._
import scommons.react.test._

class ReactNativeDemoScreenSpec extends TestSpec with ShallowRendererUtils {

  it should "render main component" in {
    //given
    val props = ReactNativeDemoScreenProps(navigate = _ => ())
    val component = <(ReactNativeDemoScreen())(^.wrapped := props)()

    //when
    val result = shallowRender(component)

    //then
    assertComponent(result, ShowcaseListView) {
      case ShowcaseListViewProps(items, navigate) =>
        items shouldBe List(
          "ActivityIndicator" -> "Demo ActivityIndicator component",
          "Button" -> "Demo Button component",
          "FlatList" -> "Demo FlatList component",
          "Image" -> "Demo Image component",
          "Modal" -> "Demo Modal component",
          "Picker" -> "Demo Picker component",
          "Alert" -> "Demo Alert component",
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
        <.>()(
          ReactNativeDemoScreen.getReactNativeScreens(Stack)
        )
      }
    }

    //when
    val result = shallowRender(<(wrapper())()())

    //then
    assertNativeComponent(result,
      <.>()(
        <(Stack.Screen)(^.name := "ActivityIndicator", ^.component := ActivityIndicatorDemo())(),
        <(Stack.Screen)(^.name := "Button", ^.component := ButtonDemo())(),
        <(Stack.Screen)(^.name := "FlatList", ^.component := FlatListDemo())(),
        <(Stack.Screen)(^.name := "Image", ^.component := ImageDemo())(),
        <(Stack.Screen)(^.name := "Modal", ^.component := ModalDemo())(),
        <(Stack.Screen)(^.name := "Picker", ^.component := PickerDemo())(),
        <(Stack.Screen)(^.name := "Alert", ^.component := AlertDemo())(),
        <(Stack.Screen)(^.name := "Platform", ^.component := PlatformDemo())()
      )
    )
  }
}
