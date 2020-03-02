package showcase.app.task

import showcase.app.ShowcaseStateDef
import io.github.shogowada.scalajs.reactjs.redux.Redux.Dispatch
import scommons.react._
import scommons.react.navigation._
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
