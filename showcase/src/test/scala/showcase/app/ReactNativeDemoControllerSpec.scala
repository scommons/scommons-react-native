package showcase.app

import scommons.react.navigation.{Navigation, raw}
import scommons.react.redux._
import scommons.react.test.TestSpec
import showcase.app.config.ShowcaseConfig

import scala.scalajs.js

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
    val navigate = mockFunction[String, Unit]
    val state = ShowcaseState(None, ShowcaseConfig())
    val nav = new Navigation(js.Dynamic.literal(
      "navigate" -> (navigate: js.Function)
    ).asInstanceOf[raw.Navigation], null)
    val routeName = "Test"

    navigate.expects(*).onCall { resRoute: String =>
      resRoute shouldBe routeName
      ()
    }

    //when
    val result = controller.mapStateAndRouteToProps(dispatch, state, nav)

    //then
    inside(result) {
      case ReactNativeDemoScreenProps(navigate) =>
        navigate(routeName)
    }
  }
}
