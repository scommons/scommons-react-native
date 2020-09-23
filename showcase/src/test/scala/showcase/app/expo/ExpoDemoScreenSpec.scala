package showcase.app.expo

import showcase.app.expo.av.VideoDemo
import showcase.app.expo.sqlite.SQLiteDemo
import showcase.app.{ShowcaseListView, ShowcaseListViewProps}
import scommons.react._
import scommons.react.navigation._
import scommons.react.navigation.stack._
import scommons.react.test._

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

  it should "render expo screens" in {
    //given
    val Stack = createStackNavigator()
    val wrapper = new FunctionComponent[Unit] {
      protected def render(props: Props): ReactElement = {
        <.>()(
          ExpoDemoScreen.getExpoScreens(Stack)
        )
      }
    }

    //when
    val result = shallowRender(<(wrapper())()())

    //then
    assertNativeComponent(result,
      <.>()(
        <(Stack.Screen)(^.name := "Asset", ^.component := AssetDemo())(),
        <(Stack.Screen)(^.name := "Font", ^.component := FontDemo())(),
        <(Stack.Screen)(^.name := "Video", ^.component := VideoDemo())(),
        <(Stack.Screen)(^.name := "SQLite", ^.component := SQLiteDemo())()
      )
    )
  }
}
