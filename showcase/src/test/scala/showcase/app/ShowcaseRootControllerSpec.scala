package showcase.app

import io.github.shogowada.scalajs.reactjs.React.Props
import io.github.shogowada.scalajs.reactjs.redux.Redux.Dispatch
import scommons.react.test.TestSpec
import showcase.app.config.ShowcaseConfig

class ShowcaseRootControllerSpec extends TestSpec {

  it should "return component" in {
    //given
    val controller = ShowcaseRootController
    
    //when & then
    controller.uiComponent shouldBe ShowcaseRoot
  }
  
  it should "map state to props" in {
    //given
    val dispatch = mock[Dispatch]
    val controller = ShowcaseRootController
    val state = mock[ShowcaseStateDef]
    val config = ShowcaseConfig(darkTheme = true)
    val props = mock[Props[Unit]]

    (state.config _).expects().returning(config)
    
    //when
    val result = controller.mapStateToProps(dispatch, state, props)
    
    //then
    inside(result) {
      case ShowcaseRootProps(darkTheme) =>
        darkTheme shouldBe config.darkTheme
    }
  }
}
