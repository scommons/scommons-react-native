package showcase.app.expo

import io.github.shogowada.scalajs.reactjs.redux.Redux.Dispatch
import scommons.react.navigation.Navigation
import scommons.react.test.TestSpec
import showcase.app.ShowcaseStateDef

class ExpoDemoControllerSpec extends TestSpec {

  it should "return component" in {
    //given
    val controller = ExpoDemoController

    //when & then
    controller.uiComponent shouldBe ExpoDemoScreen
  }

  it should "map route to props" in {
    //given
    val controller = ExpoDemoController
    val dispatch = mock[Dispatch]
    val state = mock[ShowcaseStateDef]
    val nav = mock[Navigation]
    val routeName = "Test"

    (nav.navigate(_: String)).expects(routeName)

    //when
    val result = controller.mapStateAndRouteToProps(dispatch, state, nav)

    //then
    inside(result) {
      case ExpoDemoScreenProps(navigate) =>
        navigate(routeName)
    }
  }
}
