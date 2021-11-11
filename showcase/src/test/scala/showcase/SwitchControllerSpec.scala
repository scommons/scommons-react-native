package showcase

import io.github.shogowada.scalajs.reactjs.React.Props
import scommons.react.redux._
import scommons.react.test.TestSpec
import showcase.app.ShowcaseState
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
    val config = ShowcaseConfig(darkTheme = true)
    val state = ShowcaseState(None, config)
    val props = mock[Props[Unit]]
    
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
