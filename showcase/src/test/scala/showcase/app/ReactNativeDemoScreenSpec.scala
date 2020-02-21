package showcase.app

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils

class ReactNativeDemoScreenSpec extends TestSpec with ShallowRendererUtils {

  it should "render component" in {
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
          "Modal" -> "Demo Modal component",
          "Alert" -> "Demo Alert component"
        )
        navigate shouldBe props.navigate
    }
  }
}
