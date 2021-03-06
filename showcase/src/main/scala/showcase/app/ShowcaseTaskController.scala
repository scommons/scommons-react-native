package showcase.app

import io.github.shogowada.scalajs.reactjs.React.Props
import io.github.shogowada.scalajs.reactjs.redux.Redux.Dispatch
import scommons.react.UiComponent
import scommons.react.redux.BaseStateController
import scommons.react.redux.task.{TaskManager, TaskManagerProps}
import scommons.reactnative.app.AppTaskManagerUi

object ShowcaseTaskController
  extends BaseStateController[ShowcaseStateDef, TaskManagerProps] {

  lazy val uiComponent: UiComponent[TaskManagerProps] = {
    TaskManager.uiComponent = new AppTaskManagerUi()
    TaskManager.errorHandler = AppTaskManagerUi.errorHandler
    TaskManager
  }

  def mapStateToProps(dispatch: Dispatch, state: ShowcaseStateDef, props: Props[Unit]): TaskManagerProps = {
    TaskManagerProps(state.currentTask)
  }
}
