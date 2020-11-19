package showcase.app

import io.github.shogowada.scalajs.reactjs.React.Props
import io.github.shogowada.scalajs.reactjs.redux.Redux.Dispatch
import scommons.react._
import scommons.react.redux.BaseStateController

object ShowcaseRootController extends BaseStateController[ShowcaseStateDef, ShowcaseRootProps] {

  lazy val uiComponent: UiComponent[ShowcaseRootProps] = ShowcaseRoot

  def mapStateToProps(dispatch: Dispatch, state: ShowcaseStateDef, props: Props[Unit]): ShowcaseRootProps = {
    ShowcaseRootProps(
      darkTheme = state.config.darkTheme
    )
  }
}
