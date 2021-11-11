package showcase.app

import io.github.shogowada.scalajs.reactjs.React.Props
import scommons.react.redux._
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
    val config = ShowcaseConfig(darkTheme = true)
    val state = ShowcaseState(None, config)
    val props = mock[Props[Unit]]
    
    //when
    val result = controller.mapStateToProps(dispatch, state, props)
    
    //then
    inside(result) {
      case ShowcaseRootProps(darkTheme) =>
        darkTheme shouldBe config.darkTheme
    }
  }
}
