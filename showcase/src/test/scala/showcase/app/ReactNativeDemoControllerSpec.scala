package showcase.app

import io.github.shogowada.scalajs.reactjs.redux.Redux.Dispatch
import scommons.react.navigation.Navigation
import scommons.react.test.TestSpec

class ReactNativeDemoControllerSpec extends TestSpec {

  it should "return component" in {
    //given
    val controller = ReactNativeDemoController

    //when & then
    controller.uiComponent shouldBe ReactNativeDemoScreen
  }

  it should "map route to props" in {
    //given
    val controller = ReactNativeDemoController
    val dispatch = mock[Dispatch]
    val state = mock[ShowcaseStateDef]
    val nav = mock[Navigation]
    val routeName = "Test"

    (nav.navigate(_: String)).expects(routeName)

    //when
    val result = controller.mapStateAndRouteToProps(dispatch, state, nav)

    //then
    inside(result) {
      case ReactNativeDemoScreenProps(navigate) =>
        navigate(routeName)
    }
  }
}
