package showcase.app.style

import io.github.shogowada.scalajs.reactjs.redux.Redux.Dispatch
import scommons.react.navigation.Navigation
import scommons.react.test.TestSpec
import showcase.app.ShowcaseStateDef

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
    val dispatch = mock[Dispatch]
    val state = mock[ShowcaseStateDef]
    val nav = mock[Navigation]
    val routeName = "Test"
    
    (nav.navigate(_: String)).expects(routeName)

    //when
    val result = controller.mapStateAndRouteToProps(dispatch, state, nav)
    
    //then
    inside(result) {
      case StylesScreenProps(navigate) =>
        navigate(routeName)
    }
  }
}
