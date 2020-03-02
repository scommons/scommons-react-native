package showcase.app.task

import io.github.shogowada.scalajs.reactjs.redux.Action
import scommons.api.StatusResponse
import scommons.react.redux.task.{FutureTask, TaskAction}

trait DemoActions {
  
}

object DemoActions {

  case class SuccessfulFetchAction(task: FutureTask[String]) extends TaskAction
  case class SuccessfulFetchedAction(data: String) extends Action
  
  case class FailingApiAction(task: FutureTask[StatusResponse]) extends TaskAction
}
