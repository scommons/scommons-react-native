package showcase

import io.github.shogowada.scalajs.reactjs.React.Props
import io.github.shogowada.scalajs.reactjs.redux.Redux.Dispatch
import scommons.react.test.TestSpec
import showcase.app.ShowcaseStateDef
import showcase.app.config.{ShowcaseConfig, ShowcaseConfigActions}

class SwitchControllerSpec extends TestSpec {

  it should "return component" in {
    //given
    val actions = mock[ShowcaseConfigActions]
    val controller = new SwitchController(actions)
    
    //when & then
    controller.uiComponent shouldBe SwitchDemo
  }
  
  it should "map state to props" in {
    //given
    val dispatch = mock[Dispatch]
    val actions = mock[ShowcaseConfigActions]
    val controller = new SwitchController(actions)
    val state = mock[ShowcaseStateDef]
    val config = ShowcaseConfig(darkTheme = true)
    val props = mock[Props[Unit]]

    (state.config _).expects().returning(config)
    
    //when
    val result = controller.mapStateToProps(dispatch, state, props)
    
    //then
    inside(result) {
      case SwitchDemoProps(resDispatch, resActions, darkTheme) =>
        resDispatch shouldBe dispatch
        resActions shouldBe actions
        darkTheme shouldBe config.darkTheme
    }
  }
}
