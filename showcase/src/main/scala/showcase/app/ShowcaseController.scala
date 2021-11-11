package showcase.app

import scommons.react._
import scommons.react.navigation._
import scommons.react.redux._
import scommons.reactnative.app.BaseStateAndRouteController

object ShowcaseController extends BaseStateAndRouteController[ShowcaseStateDef, ShowcaseScreenProps] {

  lazy val uiComponent: UiComponent[ShowcaseScreenProps] = ShowcaseScreen

  def mapStateAndRouteToProps(dispatch: Dispatch,
                              state: ShowcaseStateDef,
                              nav: Navigation): ShowcaseScreenProps = {
    ShowcaseScreenProps(
      navigate = { screen =>
        nav.navigate(screen)
      }
    )
  }
}
