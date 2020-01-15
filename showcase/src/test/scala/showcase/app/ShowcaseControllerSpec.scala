package showcase.app

import scommons.react.navigation.Navigation
import scommons.react.test.TestSpec

class ShowcaseControllerSpec extends TestSpec {

  it should "return component" in {
    //given
    val controller = ShowcaseController
    
    //when & then
    controller.uiComponent shouldBe ShowcaseScreen
  }
  
  it should "map route to props" in {
    //given
    val controller = ShowcaseController
    val nav = mock[Navigation]
    val routeName = "Styles"
    
    (nav.navigate(_: String)).expects(routeName)

    //when
    val result = controller.mapRouteToProps(nav)
    
    //then
    inside(result) {
      case ShowcaseScreenProps(navigate) =>
        navigate(routeName)
    }
  }
}
