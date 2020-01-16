package showcase.app

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils

class ShowcaseScreenSpec extends TestSpec with ShallowRendererUtils {

  it should "render component" in {
    //given
    val props = ShowcaseScreenProps(navigate = _ => ())
    val component = <(ShowcaseScreen())(^.wrapped := props)()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertComponent(result, ShowcaseListView) {
      case ShowcaseListViewProps(items, navigate) =>
        items shouldBe List(
          "Styles" -> "Demo style components"
        )
        navigate shouldBe props.navigate
    }
  }
}
