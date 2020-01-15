package showcase.app

import scommons.react._
import scommons.react.navigation._

object ShowcaseController extends BaseRouteController[Unit, ShowcaseScreenProps] {

  lazy val uiComponent: UiComponent[ShowcaseScreenProps] = ShowcaseScreen

  def mapRouteToProps(nav: Navigation): ShowcaseScreenProps = {
    ShowcaseScreenProps(
      navigate = { screen =>
        nav.navigate(screen)
      }
    )
  }
}
