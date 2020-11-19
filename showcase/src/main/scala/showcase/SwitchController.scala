package showcase

import io.github.shogowada.scalajs.reactjs.React.Props
import io.github.shogowada.scalajs.reactjs.redux.Redux.Dispatch
import showcase.app.ShowcaseStateDef
import showcase.app.config.ShowcaseConfigActions
import scommons.react._
import scommons.react.redux.BaseStateController

class SwitchController(actions: ShowcaseConfigActions)
  extends BaseStateController[ShowcaseStateDef, SwitchDemoProps] {

  lazy val uiComponent: UiComponent[SwitchDemoProps] = SwitchDemo

  def mapStateToProps(dispatch: Dispatch, state: ShowcaseStateDef, props: Props[Unit]): SwitchDemoProps = {
    SwitchDemoProps(
      dispatch = dispatch,
      actions = actions,
      darkTheme = state.config.darkTheme
    )
  }
}
