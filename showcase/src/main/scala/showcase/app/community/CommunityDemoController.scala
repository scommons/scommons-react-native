package showcase.app.community

import showcase.app.ShowcaseStateDef
import scommons.react._
import scommons.react.navigation._
import scommons.react.redux._
import scommons.reactnative.app.BaseStateAndRouteController

object CommunityDemoController
  extends BaseStateAndRouteController[ShowcaseStateDef, CommunityDemoScreenProps] {

  lazy val uiComponent: UiComponent[CommunityDemoScreenProps] = CommunityDemoScreen

  def mapStateAndRouteToProps(dispatch: Dispatch,
                              state: ShowcaseStateDef,
                              nav: Navigation): CommunityDemoScreenProps = {
    CommunityDemoScreenProps(
      navigate = { screen =>
        nav.navigate(screen)
      }
    )
  }
}
