package showcase.app.ui

import showcase.app.ShowcaseStateDef
import io.github.shogowada.scalajs.reactjs.redux.Redux.Dispatch
import scommons.react._
import scommons.react.navigation._
import scommons.reactnative.app.BaseStateAndRouteController

object UiDemoController extends BaseStateAndRouteController[ShowcaseStateDef, UiDemoScreenProps] {

  lazy val uiComponent: UiComponent[UiDemoScreenProps] = UiDemoScreen

  def mapStateAndRouteToProps(dispatch: Dispatch,
                              state: ShowcaseStateDef,
                              nav: Navigation): UiDemoScreenProps = {
    UiDemoScreenProps(
      navigate = { screen =>
        nav.navigate(screen)
      }
    )
  }
}
