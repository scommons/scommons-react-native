package scommons.reactnative.app

import scommons.api.ApiResponse
import scommons.api.http.ApiHttpStatusException
import scommons.react._
import scommons.react.redux.task.TaskManagerUiProps
import scommons.reactnative.app.AppTaskManagerUi._
import scommons.reactnative.ui.popup._

import scala.util.{Failure, Success, Try}

object AppTaskManagerUi {

  var errorHandler: PartialFunction[Try[_], (Option[String], Option[String])] = {
    
    case Success(res: ApiResponse) if res.status.nonSuccessful =>
      (Some(res.status.error.getOrElse("Non-successful response")), res.status.details)
    
    case Failure(e: ApiHttpStatusException) =>
      (Some(e.error), Option(e.getMessage))
  }

  private[app] var taskLoggerComp: UiComponent[TaskLoggerProps] = TaskLogger
  private[app] var loadingPopup: UiComponent[LoadingPopupProps] = LoadingPopup
  private[app] var errorPopup: UiComponent[ErrorPopupProps] = ErrorPopup
}

class AppTaskManagerUi(loadingProps: LoadingPopupProps = LoadingPopupProps())
  extends FunctionComponent[TaskManagerUiProps] {

  protected def render(compProps: Props): ReactElement = {
    val props = compProps.wrapped
    val statusMessage = props.status.getOrElse("")
    val showError = props.error.isDefined
    val errorMessage = props.error.getOrElse("")

    <.>()(
      <(taskLoggerComp())(^.wrapped := TaskLoggerProps(statusMessage))(),
      
      if (props.showLoading) Some(
        <(loadingPopup())(^.wrapped := loadingProps)()
      ) else None,

      if (showError) Some(
        <(errorPopup())(^.wrapped := ErrorPopupProps(
          error = errorMessage,
          onClose = props.onCloseErrorPopup,
          details = props.errorDetails
        ))()
      ) else None
    )
  }
}
