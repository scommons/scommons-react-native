package showcase.app

import scommons.react._
import scommons.react.navigation._
import scommons.react.redux._
import scommons.reactnative.app.BaseStateAndRouteController

object ReactNativeDemoController
  extends BaseStateAndRouteController[ShowcaseStateDef, ReactNativeDemoScreenProps] {

  lazy val uiComponent: UiComponent[ReactNativeDemoScreenProps] = ReactNativeDemoScreen

  def mapStateAndRouteToProps(dispatch: Dispatch,
                              state: ShowcaseStateDef,
                              nav: Navigation): ReactNativeDemoScreenProps = {
    ReactNativeDemoScreenProps(
      navigate = { screen =>
        nav.navigate(screen)
      }
    )
  }
}
