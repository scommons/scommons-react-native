package showcase.app.config

import scommons.react.redux._
import showcase.app.config.ShowcaseConfigActions._

trait ShowcaseConfigActions {
  
  def updateTheme(dispatch: Dispatch, darkTheme: Boolean): Unit = {
    dispatch(ShowcaseThemeChangedAction(darkTheme))
  }
}

object ShowcaseConfigActions {

  case class ShowcaseThemeChangedAction(darkTheme: Boolean) extends Action
}
