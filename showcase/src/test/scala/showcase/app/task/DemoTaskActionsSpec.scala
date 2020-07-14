package showcase.app.task

import scommons.nodejs.test.AsyncTestSpec
import scommons.react.redux.task.FutureTask
import showcase.api.task.DemoTaskApi
import showcase.app.task.DemoTaskActions._
import showcase.app.task.DemoTaskActionsSpec._

import scala.concurrent.Future

class DemoTaskActionsSpec extends AsyncTestSpec {

  it should "dispatch SuccessfulFetchedAction when successfulAction" in {
    //given
    val api = mock[DemoTaskApi]
    val actions = new DemoTaskActionsTest(api)
    val dispatch = mockFunction[Any, Any]
    val expectedResp = "successful resp"

    (api.successExample _).expects()
      .returning(Future.successful(expectedResp))
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
    val api = mock[DemoTaskApi]
    val actions = new DemoTaskActionsTest(api)
    val expectedResp = new Exception("timed out resp")

    (api.timedoutExample _).expects().returning(Future.failed(expectedResp))

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
    val api = mock[DemoTaskApi]
    val actions = new DemoTaskActionsTest(api)
    val expectedResp = new Exception("failed resp")

    (api.failedExample _).expects().returning(Future.failed(expectedResp))

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

  private class DemoTaskActionsTest(api: DemoTaskApi)
    extends DemoTaskActions {

    protected def client: DemoTaskApi = api
  }
}
