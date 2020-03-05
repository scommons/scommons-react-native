package scommons.reactnative.app

import scommons.api.ApiResponse
import scommons.api.http.ApiHttpStatusException
import scommons.react._
import scommons.react.redux.task.TaskManagerUiProps
import scommons.reactnative.ui.popup._

import scala.util.{Failure, Success, Try}

object AppTaskManagerUi {

  var errorHandler: PartialFunction[Try[_], (Option[String], Option[String])] = {
    
    case Success(res: ApiResponse) if res.status.nonSuccessful =>
      (Some(res.status.error.getOrElse("Non-successful response")), res.status.details)
    
    case Failure(e: ApiHttpStatusException) =>
      (Some(e.error), Option(e.getMessage))
  }
}

class AppTaskManagerUi(loadingProps: LoadingPopupProps = LoadingPopupProps())
  extends FunctionComponent[TaskManagerUiProps] {

  protected def render(compProps: Props): ReactElement = {
    val props = compProps.wrapped
    val statusMessage = props.status.getOrElse("")
    val showError = props.error.isDefined
    val errorMessage = props.error.getOrElse("")

    <.>()(
      <(TaskLogger())(^.wrapped := TaskLoggerProps(statusMessage))(),
      
      if (props.showLoading) Some(
        <(LoadingPopup())(^.wrapped := loadingProps)()
      ) else None,

      if (showError) Some(
        <(ErrorPopup())(^.wrapped := ErrorPopupProps(
          error = errorMessage,
          onClose = props.onCloseErrorPopup,
          details = props.errorDetails
        ))()
      ) else None
    )
  }
}
