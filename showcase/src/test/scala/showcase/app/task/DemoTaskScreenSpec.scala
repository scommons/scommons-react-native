package showcase.app.task

import io.github.shogowada.scalajs.reactjs.redux.Redux.Dispatch
import org.scalatest.Succeeded
import scommons.api.{ApiStatus, StatusResponse}
import scommons.react.redux.task.FutureTask
import scommons.react.test.dom.AsyncTestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative._
import scommons.reactnative.raw.{Alert => NativeAlert}
import showcase.app.task.DemoTaskActions._
import showcase.app.task.DemoTaskScreen.styles
import showcase.app.task.DemoTaskScreenSpec.AlertMock

import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportAll

class DemoTaskScreenSpec extends AsyncTestSpec with ShallowRendererUtils {

  it should "dispatch actions and call alert() when press Successful Request" in {
    //given
    val dispatch = mockFunction[Any, Any]
    val actions = mock[DemoTaskActions]
    val alert = mock[AlertMock]
    NativeAlert.asInstanceOf[js.Dynamic].updateDynamic("alert")(alert.alert _)
    val props = getDemoTaskScreenProps(dispatch, actions)
    val comp = shallowRender(<(DemoTaskScreen())(^.wrapped := props)())
    val List(successReqBtn, _, _) = findComponents(comp, raw.Button)

    val resp = "test resp"
    val action = SuccessfulFetchAction(
      FutureTask("Fetching", Future.successful(resp))
    )
    
    //then
    (actions.successfulAction _).expects(dispatch).returning(action)
    dispatch.expects(action)
    (alert.alert _).expects(*, *, *, *).onCall { (title, message, buttons, options) =>
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
    val actions = mock[DemoTaskActions]
    val alert = mock[AlertMock]
    NativeAlert.asInstanceOf[js.Dynamic].updateDynamic("alert")(alert.alert _)
    val props = getDemoTaskScreenProps(dispatch, actions)
    val comp = shallowRender(<(DemoTaskScreen())(^.wrapped := props)())
    val List(_, timedoutReqBtn, _) = findComponents(comp, raw.Button)

    val action = FailingApiAction(
      FutureTask("Timedout", Future.failed(new Exception("timedout resp")))
    )
    
    //then
    (actions.timedoutAction _).expects().returning(action)
    dispatch.expects(action)
    
    //when
    timedoutReqBtn.props.onPress()

    Succeeded
  }

  it should "dispatch action when press Failed Request" in {
    //given
    val dispatch = mockFunction[Any, Any]
    val actions = mock[DemoTaskActions]
    val alert = mock[AlertMock]
    NativeAlert.asInstanceOf[js.Dynamic].updateDynamic("alert")(alert.alert _)
    val props = getDemoTaskScreenProps(dispatch, actions)
    val comp = shallowRender(<(DemoTaskScreen())(^.wrapped := props)())
    val List(_, _, failedReqBtn) = findComponents(comp, raw.Button)

    val action = FailingApiAction(
      FutureTask("Filed", Future.successful(StatusResponse(
        ApiStatus(500, "Error", "Some test error occurred")
      )))
    )
    
    //then
    (actions.failedAction _).expects().returning(action)
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
    val result = shallowRender(component)

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

  @JSExportAll
  trait AlertMock {
    
    def alert(title: String,
              message: String,
              buttons: js.Array[raw.AlertButton],
              options: raw.AlertOptions
             ): Unit
  }
}
