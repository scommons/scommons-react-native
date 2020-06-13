package showcase.app.expo

import scommons.react.navigation._
import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import showcase.app.expo.av.VideoDemo
import showcase.app.expo.sqlite.SQLiteDemo
import showcase.app.{ShowcaseListView, ShowcaseListViewProps}

class ExpoDemoScreenSpec extends TestSpec with ShallowRendererUtils {

  it should "render main component" in {
    //given
    val props = ExpoDemoScreenProps(navigate = _ => ())
    val component = <(ExpoDemoScreen())(^.wrapped := props)()

    //when
    val result = shallowRender(component)

    //then
    assertComponent(result, ShowcaseListView) {
      case ShowcaseListViewProps(items, navigate) =>
        items shouldBe List(
          "Asset" -> "Demo Asset API",
          "Font" -> "Demo Font API",
          "Video" -> "Demo video components",
          "SQLite" -> "Demo SQLite API"
        )
        navigate shouldBe props.navigate
    }
  }

  it should "render expoStackComp" in {
    //given
    val Stack = ExpoDemoScreen.Stack
    val component = <(ExpoDemoScreen.expoStackComp).empty

    //when
    val result = shallowRender(component)

    //then
    assertNativeComponent(result,
      <(Stack.Navigator)(^.initialRouteName := "Expo")(
        <(Stack.Screen)(^.name := "Expo", ^.component := ExpoDemoController())(),
        <(Stack.Screen)(^.name := "Asset", ^.component := AssetDemo())(),
        <(Stack.Screen)(^.name := "Font", ^.component := FontDemo())(),
        <(Stack.Screen)(^.name := "Video", ^.component := VideoDemo())(),
        <(Stack.Screen)(^.name := "SQLite", ^.component := SQLiteDemo())()
      )
    )
  }
}
