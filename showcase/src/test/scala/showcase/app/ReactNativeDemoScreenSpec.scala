package showcase.app

import showcase._
import scommons.react.navigation._
import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils

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

  it should "render reactNativeStackComp" in {
    //given
    val Stack = ReactNativeDemoScreen.Stack
    val component = <(ReactNativeDemoScreen.reactNativeStackComp).empty

    //when
    val result = shallowRender(component)

    //then
    assertNativeComponent(result,
      <(Stack.Navigator)(^.initialRouteName := "ReactNative")(
        <(Stack.Screen)(^.name := "ReactNative", ^.component := ReactNativeDemoController())(),
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
