package showcase.app.task

import scommons.api.StatusResponse
import scommons.nodejs.test.AsyncTestSpec
import scommons.react.redux.task.FutureTask
import showcase.api.task.DemoTaskApi
import showcase.app.task.DemoTaskActions._
import showcase.app.task.DemoTaskActionsSpec._

import scala.concurrent.Future

class DemoTaskActionsSpec extends AsyncTestSpec {

  it should "dispatch SuccessfulFetchedAction when successfulAction" in {
    //given
    val successExampleMock = mockFunction[Future[String]]
    val timedoutExampleMock = mockFunction[Future[StatusResponse]]
    val failedExampleMock = mockFunction[Future[StatusResponse]]
    val api = new DemoTaskApiMock(successExampleMock, timedoutExampleMock, failedExampleMock)
    val actions = new DemoTaskActionsTest(api)
    val dispatch = mockFunction[Any, Any]
    val expectedResp = "successful resp"

    successExampleMock.expects().returning(Future.successful(expectedResp))
    dispatch.expects(SuccessfulFetchedAction(expectedResp))

    //when
    val SuccessfulFetchAction(FutureTask(message, future)) =
      actions.successfulAction(dispatch)

    //then
    message shouldBe "Calling successful endpoint"
    future.map { resp =>
      resp shouldBe expectedResp
    }
  }
  
  it should "return FailingApiAction when timedoutAction" in {
    //given
    val successExampleMock = mockFunction[Future[String]]
    val timedoutExampleMock = mockFunction[Future[StatusResponse]]
    val failedExampleMock = mockFunction[Future[StatusResponse]]
    val api = new DemoTaskApiMock(successExampleMock, timedoutExampleMock, failedExampleMock)
    val actions = new DemoTaskActionsTest(api)
    val expectedResp = new Exception("timed out resp")

    timedoutExampleMock.expects().returning(Future.failed(expectedResp))

    //when
    val FailingApiAction(FutureTask(message, future)) =
      actions.timedoutAction()

    //then
    message shouldBe "Calling timedout endpoint"
    future.failed.map { resp =>
      resp shouldBe expectedResp
    }
  }
  
  it should "return FailingApiAction when failedAction" in {
    //given
    val successExampleMock = mockFunction[Future[String]]
    val timedoutExampleMock = mockFunction[Future[StatusResponse]]
    val failedExampleMock = mockFunction[Future[StatusResponse]]
    val api = new DemoTaskApiMock(successExampleMock, timedoutExampleMock, failedExampleMock)
    val actions = new DemoTaskActionsTest(api)
    val expectedResp = new Exception("failed resp")

    failedExampleMock.expects().returning(Future.failed(expectedResp))

    //when
    val FailingApiAction(FutureTask(message, future)) =
      actions.failedAction()

    //then
    message shouldBe "Calling failed endpoint"
    future.failed.map { resp =>
      resp shouldBe expectedResp
    }
  }
}

object DemoTaskActionsSpec {

  class DemoTaskApiMock(
                         successExampleMock: () => Future[String],
                         timedoutExampleMock: () => Future[StatusResponse],
                         failedExampleMock: () => Future[StatusResponse]
                       ) extends DemoTaskApi {

    override def successExample(): Future[String] = successExampleMock()

    override def timedoutExample(): Future[StatusResponse] = timedoutExampleMock()

    override def failedExample(): Future[StatusResponse] = failedExampleMock()
  }

  private class DemoTaskActionsTest(api: DemoTaskApi)
    extends DemoTaskActions {

    protected def client: DemoTaskApi = api
  }
}
