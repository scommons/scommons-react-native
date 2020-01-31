package showcase.app

import scommons.react._
import scommons.react.navigation._

object ReactNativeDemoController extends BaseRouteController[Unit, ReactNativeDemoScreenProps] {

  lazy val uiComponent: UiComponent[ReactNativeDemoScreenProps] = ReactNativeDemoScreen

  def mapRouteToProps(nav: Navigation): ReactNativeDemoScreenProps = {
    ReactNativeDemoScreenProps(
      navigate = { screen =>
        nav.navigate(screen)
      }
    )
  }
}
