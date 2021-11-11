package showcase.app.task

import scommons.api.StatusResponse
import scommons.react.redux._
import scommons.react.redux.task.{FutureTask, TaskAction}
import showcase.api.task.DemoTaskApi
import showcase.app.task.DemoTaskActions._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Success

trait DemoTaskActions {
  
  protected def client: DemoTaskApi

  def successfulAction(dispatch: Dispatch): SuccessfulFetchAction = {
    val future = client.successExample().andThen {
      case Success(data) =>
        dispatch(SuccessfulFetchedAction(data))
    }
    
    SuccessfulFetchAction(FutureTask("Calling successful endpoint", future))
  }

  def timedoutAction(): FailingApiAction = {
    val future = client.timedoutExample()
    
    FailingApiAction(FutureTask("Calling timedout endpoint", future))
  }

  def failedAction(): FailingApiAction = {
    val future = client.failedExample()
    
    FailingApiAction(FutureTask("Calling failed endpoint", future))
  }
}

object DemoTaskActions {

  case class SuccessfulFetchAction(task: FutureTask[String]) extends TaskAction
  case class SuccessfulFetchedAction(data: String) extends Action
  
  case class FailingApiAction(task: FutureTask[StatusResponse]) extends TaskAction
}
