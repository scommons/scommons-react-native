package showcase.app

import scommons.react.redux.task.{AbstractTask, TaskAction}
import showcase.app.config.{ShowcaseConfig, ShowcaseConfigReducer}

trait ShowcaseStateDef {

  def currentTask: Option[AbstractTask]
  def config: ShowcaseConfig
}

case class ShowcaseState(currentTask: Option[AbstractTask],
                         config: ShowcaseConfig) extends ShowcaseStateDef

object ShowcaseStateReducer {

  def reduce(state: Option[ShowcaseState], action: Any): ShowcaseState = ShowcaseState(
    currentTask = currentTaskReducer(state.flatMap(_.currentTask), action),
    config = ShowcaseConfigReducer(state.map(_.config), action)
  )

  private def currentTaskReducer(currentTask: Option[AbstractTask],
                                 action: Any): Option[AbstractTask] = action match {
    case a: TaskAction => Some(a.task)
    case _ => currentTask
  }
}
