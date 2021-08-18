package showcase.app.task

import io.github.shogowada.scalajs.reactjs.redux.Redux.Dispatch
import org.scalatest.Succeeded
import scommons.api.{ApiStatus, StatusResponse}
import scommons.nodejs.test.AsyncTestSpec
import scommons.react.redux.task.FutureTask
import scommons.react.test.{BaseTestSpec, TestRendererUtils}
import scommons.reactnative._
import scommons.reactnative.raw.{Alert => NativeAlert}
import showcase.api.task.DemoTaskApi
import showcase.app.task.DemoTaskActions._
import showcase.app.task.DemoTaskScreen.styles
import showcase.app.task.DemoTaskScreenSpec.{DemoTaskActionsMock, setAlertMock}

import scala.concurrent.Future
import scala.scalajs.js

class DemoTaskScreenSpec extends AsyncTestSpec
  with BaseTestSpec
  with TestRendererUtils {

  it should "dispatch actions and call alert() when press Successful Request" in {
    //given
    val dispatch = mockFunction[Any, Any]
    val successfulActionMock = mockFunction[Dispatch, SuccessfulFetchAction]
    val timedoutActionMock = mockFunction[FailingApiAction]
    val failedActionMock = mockFunction[FailingApiAction]
    val actions = new DemoTaskActionsMock(successfulActionMock, timedoutActionMock, failedActionMock)
    val alertMock = mockFunction[String, String, js.Array[raw.AlertButton], raw.AlertOptions, Unit]
    setAlertMock(alertMock)
    val props = getDemoTaskScreenProps(dispatch, actions)
    val comp = testRender(<(DemoTaskScreen())(^.wrapped := props)())
    val successReqBtn = inside(findComponents(comp, raw.Button)) {
      case List(successReqBtn, _, _) => successReqBtn
    }

    val resp = "test resp"
    val action = SuccessfulFetchAction(
      FutureTask("Fetching", Future.successful(resp))
    )
    
    //then
    successfulActionMock.expects(dispatch).returning(action)
    dispatch.expects(action)
    alertMock.expects(*, *, *, *).onCall { (title, message, buttons, options) =>
      //then
      title shouldBe "Successful Request"
      message shouldBe resp
      buttons.toList shouldBe Nil
      options.cancelable shouldBe false
    }
    
    //when
    successReqBtn.props.onPress()

    action.task.future.map(_ => Succeeded)
  }

  it should "dispatch action when press Timed-out Request" in {
    //given
    val dispatch = mockFunction[Any, Any]
    val successfulActionMock = mockFunction[Dispatch, SuccessfulFetchAction]
    val timedoutActionMock = mockFunction[FailingApiAction]
    val failedActionMock = mockFunction[FailingApiAction]
    val actions = new DemoTaskActionsMock(successfulActionMock, timedoutActionMock, failedActionMock)
    val alertMock = mockFunction[String, String, js.Array[raw.AlertButton], raw.AlertOptions, Unit]
    setAlertMock(alertMock)
    val props = getDemoTaskScreenProps(dispatch, actions)
    val comp = testRender(<(DemoTaskScreen())(^.wrapped := props)())
    val timedoutReqBtn = inside(findComponents(comp, raw.Button)) {
      case List(_, timedoutReqBtn, _) => timedoutReqBtn
    }

    val action = FailingApiAction(
      FutureTask("Timedout", Future.failed(new Exception("timedout resp")))
    )
    
    //then
    timedoutActionMock.expects().returning(action)
    dispatch.expects(action)
    
    //when
    timedoutReqBtn.props.onPress()

    Succeeded
  }

  it should "dispatch action when press Failed Request" in {
    //given
    val dispatch = mockFunction[Any, Any]
    val successfulActionMock = mockFunction[Dispatch, SuccessfulFetchAction]
    val timedoutActionMock = mockFunction[FailingApiAction]
    val failedActionMock = mockFunction[FailingApiAction]
    val actions = new DemoTaskActionsMock(successfulActionMock, timedoutActionMock, failedActionMock)
    val alertMock = mockFunction[String, String, js.Array[raw.AlertButton], raw.AlertOptions, Unit]
    setAlertMock(alertMock)
    val props = getDemoTaskScreenProps(dispatch, actions)
    val comp = testRender(<(DemoTaskScreen())(^.wrapped := props)())
    val failedReqBtn = inside(findComponents(comp, raw.Button)) {
      case List(_, _, failedReqBtn) => failedReqBtn
    }

    val action = FailingApiAction(
      FutureTask("Filed", Future.successful(StatusResponse(
        ApiStatus(500, "Error", "Some test error occurred")
      )))
    )
    
    //then
    failedActionMock.expects().returning(action)
    dispatch.expects(action)
    
    //when
    failedReqBtn.props.onPress()

    Succeeded
  }

  it should "render component" in {
    //given
    val props = getDemoTaskScreenProps()
    val component = <(DemoTaskScreen())(^.wrapped := props)()

    //when
    val result = testRender(component)

    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.Button(^.title := "Successful Request", ^.color := "#00ff00")(),
        <.Button(^.title := "Timed-out Request", ^.color := "#0000ff")(),
        <.Button(^.title := "Failed Request", ^.color := "#ff0000")()
      )
    )
  }
  
  private def getDemoTaskScreenProps(dispatch: Dispatch = mock[Dispatch],
                                     actions: DemoTaskActions = mock[DemoTaskActions]
                                    ): DemoTaskScreenProps = {
    DemoTaskScreenProps(
      dispatch = dispatch,
      actions = actions
    )
  }
}

object DemoTaskScreenSpec {

  def setAlertMock(alertMock: (String, String, js.Array[raw.AlertButton], raw.AlertOptions) => Unit): Unit = {
    NativeAlert.asInstanceOf[js.Dynamic].updateDynamic("alert")(alertMock: js.Function)
  }

  class DemoTaskActionsMock(
                             successfulActionMock: Dispatch => SuccessfulFetchAction,
                             timedoutActionMock: () => FailingApiAction,
                             failedActionMock: () => FailingApiAction
                           ) extends DemoTaskActions {

    protected def client: DemoTaskApi = null

    override def successfulAction(dispatch: Dispatch): SuccessfulFetchAction = successfulActionMock(dispatch)

    override def timedoutAction(): FailingApiAction = timedoutActionMock()

    override def failedAction(): FailingApiAction = failedActionMock()
  }
}
