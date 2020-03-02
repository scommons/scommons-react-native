package showcase.app

import io.github.shogowada.scalajs.reactjs.redux.Redux.Dispatch
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
    val dispatch = mock[Dispatch]
    val state = mock[ShowcaseStateDef]
    val nav = mock[Navigation]
    val routeName = "Styles"
    
    (nav.navigate(_: String)).expects(routeName)

    //when
    val result = controller.mapStateAndRouteToProps(dispatch, state, nav)
    
    //then
    inside(result) {
      case ShowcaseScreenProps(navigate) =>
        navigate(routeName)
    }
  }
}
