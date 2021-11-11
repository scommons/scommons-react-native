package showcase.app.task

import showcase.app.ShowcaseStateDef
import scommons.react._
import scommons.react.navigation._
import scommons.react.redux.Dispatch
import scommons.reactnative.app.BaseStateAndRouteController

class DemoTaskController(actions: DemoTaskActions)
  extends BaseStateAndRouteController[ShowcaseStateDef, DemoTaskScreenProps] {

  lazy val uiComponent: UiComponent[DemoTaskScreenProps] = DemoTaskScreen

  def mapStateAndRouteToProps(dispatch: Dispatch,
                              state: ShowcaseStateDef,
                              nav: Navigation): DemoTaskScreenProps = {
    DemoTaskScreenProps(
      dispatch = dispatch,
      actions = actions
    )
  }
}
