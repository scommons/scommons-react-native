package showcase.app.config

import io.github.shogowada.scalajs.reactjs.redux.Action
import io.github.shogowada.scalajs.reactjs.redux.Redux.Dispatch
import showcase.app.config.ShowcaseConfigActions._

trait ShowcaseConfigActions {
  
  def updateTheme(dispatch: Dispatch, darkTheme: Boolean): Unit = {
    dispatch(ShowcaseThemeChangedAction(darkTheme))
  }
}

object ShowcaseConfigActions {

  case class ShowcaseThemeChangedAction(darkTheme: Boolean) extends Action
}
