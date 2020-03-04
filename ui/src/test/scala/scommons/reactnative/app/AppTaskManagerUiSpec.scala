package scommons.reactnative.app

import org.scalatest.Succeeded
import scommons.api.{ApiStatus, StatusResponse}
import scommons.react._
import scommons.react.redux.task.TaskManagerUiProps
import scommons.react.test.TestSpec
import scommons.react.test.raw.ShallowInstance
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative.ActivityIndicator._
import scommons.reactnative.Style
import scommons.reactnative.ui.popup._

import scala.util.Success

class AppTaskManagerUiSpec extends TestSpec with ShallowRendererUtils {

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

  it should "return None if successful response in errorHandler" in {
    //given
    val value = Success(StatusResponse(ApiStatus.Ok))

    //when
    val (error, errorDetails) = AppTaskManagerUi.errorHandler(value)

    //then
    error shouldBe None
    errorDetails shouldBe None
  }

  it should "call onCloseErrorPopup function when onClose error popup" in {
    //given
    val onCloseErrorPopup = mockFunction[Unit]
    val props = getTaskManagerUiProps(
      error = Some("Some error"),
      onCloseErrorPopup = onCloseErrorPopup
    )
    val comp = new AppTaskManagerUi().apply()
    val result = shallowRender(<(comp)(^.wrapped := props)())
    val errorProps = findComponentProps(result, ErrorPopup)

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
    val result = shallowRender(<(comp)(^.wrapped := props)())

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
    val result = shallowRender(<(comp)(^.wrapped := props)())

    //then
    assertRenderingResult(result, props)
  }

  it should "render empty component" in {
    //given
    val props = getTaskManagerUiProps()
    val comp = new AppTaskManagerUi().apply()

    //when
    val result = shallowRender(<(comp)(^.wrapped := props)())

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
  
  private def assertRenderingResult(result: ShallowInstance, props: TaskManagerUiProps): Unit = {
    val showError = props.error.isDefined
    
    assertNativeComponent(result, <.>()(), { children =>
      val (taskLogger, loadingPopup, errorPopup) = children match {
        case List(tl, lp) if props.showLoading => (tl, Some(lp), None)
        case List(tl, ep) if showError => (tl, None, Some(ep))
        case List(tl) => (tl, None, None)
      }

      assertComponent(taskLogger, TaskLogger) { case TaskLoggerProps(text) =>
        text shouldBe props.status.getOrElse("")
      }
      
      if (props.showLoading) {
        loadingPopup should not be None
        assertComponent(loadingPopup.get, LoadingPopup) { case LoadingPopupProps(resSize, color) =>
          resSize shouldBe ActivityIndicatorSize.small
          color shouldBe Style.Color.gray
        }
      }

      if (showError) {
        errorPopup should not be None
        assertComponent(errorPopup.get, ErrorPopup) { case ErrorPopupProps(error, onClose, details) =>
          error shouldBe props.error.getOrElse("")
          details shouldBe props.errorDetails
          onClose shouldBe props.onCloseErrorPopup
        }
      }

      Succeeded
    })
  }
}
