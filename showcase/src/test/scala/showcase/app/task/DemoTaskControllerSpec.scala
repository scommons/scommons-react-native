package showcase.app.task

import scommons.react.navigation.Navigation
import scommons.react.redux.Dispatch
import scommons.react.test.TestSpec
import showcase.app.ShowcaseStateDef

class DemoTaskControllerSpec extends TestSpec {

  it should "return component" in {
    //given
    val actions = mock[DemoTaskActions]
    val controller = new DemoTaskController(actions)
    
    //when & then
    controller.uiComponent shouldBe DemoTaskScreen
  }
  
  it should "map state to props" in {
    //given
    val dispatch = mock[Dispatch]
    val actions = mock[DemoTaskActions]
    val controller = new DemoTaskController(actions)
    val state = mock[ShowcaseStateDef]
    val nav = mock[Navigation]
    
    //when
    val result = controller.mapStateAndRouteToProps(dispatch, state, nav)
    
    //then
    inside(result) {
      case DemoTaskScreenProps(resDispatch, resActions) =>
        resDispatch shouldBe dispatch
        resActions shouldBe actions
    }
  }
}
