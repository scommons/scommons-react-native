package showcase.app.expo

import showcase.app.ShowcaseStateDef
import scommons.react._
import scommons.react.navigation._
import scommons.react.redux._
import scommons.reactnative.app.BaseStateAndRouteController

object ExpoDemoController
  extends BaseStateAndRouteController[ShowcaseStateDef, ExpoDemoScreenProps] {

  lazy val uiComponent: UiComponent[ExpoDemoScreenProps] = ExpoDemoScreen

  def mapStateAndRouteToProps(dispatch: Dispatch,
                              state: ShowcaseStateDef,
                              nav: Navigation): ExpoDemoScreenProps = {
    ExpoDemoScreenProps(
      navigate = { screen =>
        nav.navigate(screen)
      }
    )
  }
}
