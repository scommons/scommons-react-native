package scommons.reactnative.app

import scommons.api.ApiResponse
import scommons.react._
import scommons.react.redux.task.TaskManagerUiProps
import scommons.reactnative.ui.popup._

import scala.util.{Success, Try}

object AppTaskManagerUi {

  var errorHandler: PartialFunction[Try[_], (Option[String], Option[String])] = {
    case Success(result) => result match {
      case res: ApiResponse if res.status.nonSuccessful =>
        (Some(res.status.error.getOrElse("Non-successful response")), res.status.details)
      case _ =>
        (None, None)
    }
  }
}

class AppTaskManagerUi(loadingProps: LoadingPopupProps = LoadingPopupProps())
  extends FunctionComponent[TaskManagerUiProps] {

  protected def render(compProps: Props): ReactElement = {
    val props = compProps.wrapped

    <.>()(
      if (props.showLoading) Some(
        <(LoadingPopup())(^.wrapped := loadingProps)()
      ) else None
    )
  }
}
