package showcase.app

import io.github.shogowada.scalajs.reactjs.React.Props
import scommons.react._
import scommons.react.redux._

object ShowcaseRootController extends BaseStateController[ShowcaseStateDef, ShowcaseRootProps] {

  lazy val uiComponent: UiComponent[ShowcaseRootProps] = ShowcaseRoot

  def mapStateToProps(dispatch: Dispatch, state: ShowcaseStateDef, props: Props[Unit]): ShowcaseRootProps = {
    ShowcaseRootProps(
      darkTheme = state.config.darkTheme
    )
  }
}
