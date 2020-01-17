package showcase.app.style

import showcase.app.BaseRouteController
import scommons.react._
import scommons.react.navigation._

object StylesScreenController extends BaseRouteController[Unit, StylesScreenProps] {

  lazy val uiComponent: UiComponent[StylesScreenProps] = StylesScreen

  def mapRouteToProps(nav: Navigation): StylesScreenProps = {
    StylesScreenProps(
      navigate = { screen =>
        nav.navigate(screen)
      }
    )
  }
}
