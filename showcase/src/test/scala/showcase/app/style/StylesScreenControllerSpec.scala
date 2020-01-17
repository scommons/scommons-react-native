package showcase.app.style

import scommons.react.navigation.Navigation
import scommons.react.test.TestSpec

class StylesScreenControllerSpec extends TestSpec {

  it should "return component" in {
    //given
    val controller = StylesScreenController
    
    //when & then
    controller.uiComponent shouldBe StylesScreen
  }
  
  it should "map route to props" in {
    //given
    val controller = StylesScreenController
    val nav = mock[Navigation]
    val routeName = "Test"
    
    (nav.navigate(_: String)).expects(routeName)

    //when
    val result = controller.mapRouteToProps(nav)
    
    //then
    inside(result) {
      case StylesScreenProps(navigate) =>
        navigate(routeName)
    }
  }
}
