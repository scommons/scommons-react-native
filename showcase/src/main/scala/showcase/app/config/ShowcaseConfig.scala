package showcase.app.config

import showcase.app.config.ShowcaseConfigActions._

case class ShowcaseConfig(darkTheme: Boolean = false)

object ShowcaseConfigReducer {

  def apply(state: Option[ShowcaseConfig], action: Any): ShowcaseConfig = {
    reduce(state.getOrElse(ShowcaseConfig()), action)
  }

  private def reduce(state: ShowcaseConfig, action: Any): ShowcaseConfig = action match {
    case ShowcaseThemeChangedAction(darkTheme) => state.copy(darkTheme = darkTheme)
    case _ => state
  }
}
