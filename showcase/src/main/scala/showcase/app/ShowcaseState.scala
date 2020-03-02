package showcase.app

import scommons.react.redux.task.{AbstractTask, TaskAction}

trait ShowcaseStateDef {

  def currentTask: Option[AbstractTask]
}

case class ShowcaseState(currentTask: Option[AbstractTask]) extends ShowcaseStateDef

object ShowcaseStateReducer {

  def reduce(state: Option[ShowcaseState], action: Any): ShowcaseState = ShowcaseState(
    currentTask = currentTaskReducer(state.flatMap(_.currentTask), action)
  )

  private def currentTaskReducer(currentTask: Option[AbstractTask],
                                 action: Any): Option[AbstractTask] = action match {
    case a: TaskAction => Some(a.task)
    case _ => currentTask
  }
}
