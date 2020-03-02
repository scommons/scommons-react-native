package showcase.api.task

import org.scalajs.dom
import scommons.api.{ApiStatus, StatusResponse}

import scala.concurrent.duration._
import scala.concurrent.{Future, Promise}

trait DemoTaskApi {

  def successExample(): Future[String] = {
    Future.successful("All good!")
  }
  
  def timedoutExample(): Future[StatusResponse] = {
    val promise = Promise[StatusResponse]()

    var handleId = 0
    handleId = dom.window.setTimeout({ () =>
      dom.window.clearTimeout(handleId)

      promise.failure(new Exception("Request timed out, unable to get timely response"))
    }, 2.seconds.toMillis.toDouble)

    promise.future
  }

  def failedExample(): Future[StatusResponse] = {
    Future.successful(StatusResponse(
      ApiStatus(500, "Internal Server Error", "Some error occurred, try again later)")
    ))
  }
}
