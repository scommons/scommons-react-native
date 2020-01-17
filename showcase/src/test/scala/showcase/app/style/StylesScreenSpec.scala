package showcase.app.style

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import showcase.app._

class StylesScreenSpec extends TestSpec with ShallowRendererUtils {

  it should "render component" in {
    //given
    val props = StylesScreenProps(navigate = _ => ())
    val component = <(StylesScreen())(^.wrapped := props)()

    //when
    val result = shallowRender(component)

    //then
    assertComponent(result, ShowcaseListView) {
      case ShowcaseListViewProps(items, navigate) =>
        items shouldBe List(
          "BorderStyle" -> "Demo border styles",
          "BorderRadius" -> "Demo border radius styles",
          "MarginStyle" -> "Demo margin styles",
          "PaddingStyle" -> "Demo padding styles",
          "PositionStyle" -> "Demo position styles",
          "Platform" -> "Demo platform-specific styles",
          "TextStyle" -> "Demo text styles",
          "ProfileCard" -> "Demo ProfileCard component"
        )
        navigate shouldBe props.navigate
    }
  }
}
