package scommons.reactnative.app

import scommons.api.http.{ApiHttpResponse, ApiHttpStatusException}
import scommons.api.{ApiStatus, StatusResponse}
import scommons.react.redux.task.TaskManagerUiProps
import scommons.react.test._
import scommons.reactnative.ActivityIndicator._
import scommons.reactnative.Style
import scommons.reactnative.app.AppTaskManagerUi._
import scommons.reactnative.ui.popup._

import scala.util.{Failure, Success}

class AppTaskManagerUiSpec extends TestSpec with TestRendererUtils {

  AppTaskManagerUi.taskLoggerComp = mockUiComponent("TaskLogger")
  AppTaskManagerUi.loadingPopup = mockUiComponent("LoadingPopup")
  AppTaskManagerUi.errorPopup = mockUiComponent("ErrorPopup")

  it should "return error if unsuccessful response in errorHandler" in {
    //given
    val status = ApiStatus(500, "Some API error", "Some error details")
    val value = Success(StatusResponse(status))

    //when
    val (error, errorDetails) = AppTaskManagerUi.errorHandler(value)

    //then
    error shouldBe status.error
    errorDetails shouldBe status.details
  }

  it should "not handle successful response in errorHandler" in {
    //given
    val value = Success(StatusResponse(ApiStatus.Ok))

    //when & then
    AppTaskManagerUi.errorHandler.isDefinedAt(value) shouldBe false
  }

  it should "not handle any other successful result in errorHandler" in {
    //given
    val value = Success(123)

    //when & then
    AppTaskManagerUi.errorHandler.isDefinedAt(value) shouldBe false
  }

  it should "return error if failed response exception in errorHandler" in {
    //given
    val resp = ApiHttpResponse("test/url", 500, Map.empty, "Some error resp")
    val ex = ApiHttpStatusException("Login failed", resp)

    //when
    val (error, errorDetails) = AppTaskManagerUi.errorHandler(Failure(ex))

    //then
    error shouldBe Some(ex.error)
    errorDetails shouldBe Some(ex.getMessage)
  }

  it should "not handle any other exception in errorHandler" in {
    //given
    val ex = new Exception("any other test error")

    //when & then
    AppTaskManagerUi.errorHandler.isDefinedAt(Failure(ex)) shouldBe false
  }

  it should "call onCloseErrorPopup function when onClose error popup" in {
    //given
    val onCloseErrorPopup = mockFunction[Unit]
    val props = getTaskManagerUiProps(
      error = Some("Some error"),
      onCloseErrorPopup = onCloseErrorPopup
    )
    val comp = new AppTaskManagerUi().apply()
    val result = createTestRenderer(<(comp)(^.wrapped := props)()).root
    val errorProps = findComponentProps(result, errorPopup)

    //then
    onCloseErrorPopup.expects()

    //when
    errorProps.onClose()
  }

  it should "render loading and log task status" in {
    //given
    val props = getTaskManagerUiProps(
      showLoading = true,
      status = Some("Fetching data")
    )
    val comp = new AppTaskManagerUi().apply()

    //when
    val result = createTestRenderer(<(comp)(^.wrapped := props)()).root

    //then
    assertRenderingResult(result, props)
  }

  it should "render error with details" in {
    //given
    val props = getTaskManagerUiProps(
      error = Some("Some error"),
      errorDetails = Some("Some error details")
    )
    val comp = new AppTaskManagerUi().apply()

    //when
    val result = createTestRenderer(<(comp)(^.wrapped := props)()).root

    //then
    assertRenderingResult(result, props)
  }

  it should "render empty component" in {
    //given
    val props = getTaskManagerUiProps()
    val comp = new AppTaskManagerUi().apply()

    //when
    val result = createTestRenderer(<(comp)(^.wrapped := props)()).root

    //then
    assertRenderingResult(result, props)
  }

  private def getTaskManagerUiProps(showLoading: Boolean = false,
                                    status: Option[String] = None,
                                    onHideStatus: () => Unit = () => (),
                                    error: Option[String] = None,
                                    errorDetails: Option[String] = None,
                                    onCloseErrorPopup: () => Unit = () => ()): TaskManagerUiProps = {

    TaskManagerUiProps(
      showLoading,
      status,
      onHideStatus,
      error,
      errorDetails,
      onCloseErrorPopup
    )
  }
  
  private def assertRenderingResult(result: TestInstance, props: TaskManagerUiProps): Unit = {
    val showError = props.error.isDefined
    
    val (resTaskLogger, resLoadingPopup, resErrorPopup) = inside(result.children.toList) {
      case List(tl, lp) if props.showLoading => (tl, Some(lp), None)
      case List(tl, ep) if showError => (tl, None, Some(ep))
      case List(tl) => (tl, None, None)
    }

    assertTestComponent(resTaskLogger, taskLoggerComp) { case TaskLoggerProps(text) =>
      text shouldBe props.status.getOrElse("")
    }
    
    if (props.showLoading) {
      resLoadingPopup should not be None
      assertTestComponent(resLoadingPopup.get, loadingPopup) { case LoadingPopupProps(resSize, color) =>
        resSize shouldBe ActivityIndicatorSize.small
        color shouldBe Style.Color.gray
      }
    }

    if (showError) {
      resErrorPopup should not be None
      assertTestComponent(resErrorPopup.get, errorPopup) { case ErrorPopupProps(error, onClose, details) =>
        error shouldBe props.error.getOrElse("")
        details shouldBe props.errorDetails
        onClose shouldBe props.onCloseErrorPopup
      }
    }
  }
}
