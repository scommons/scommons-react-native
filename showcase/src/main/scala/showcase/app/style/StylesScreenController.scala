package showcase.app.style

import showcase.app.ShowcaseStateDef
import scommons.react._
import scommons.react.navigation._
import scommons.react.redux.Dispatch
import scommons.reactnative.app.BaseStateAndRouteController

object StylesScreenController extends BaseStateAndRouteController[ShowcaseStateDef, StylesScreenProps] {

  lazy val uiComponent: UiComponent[StylesScreenProps] = StylesScreen

  def mapStateAndRouteToProps(dispatch: Dispatch,
                              state: ShowcaseStateDef,
                              nav: Navigation): StylesScreenProps = {
    StylesScreenProps(
      navigate = { screen =>
        nav.navigate(screen)
      }
    )
  }
}
