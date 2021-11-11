package scommons.reactnative.app

import io.github.shogowada.scalajs.reactjs.React.Props
import scommons.react.navigation._
import scommons.react.redux._

trait BaseStateAndRouteController[S, P] extends BaseStateController[S, P] {

  override def mapStateToProps(dispatch: Dispatch, state: S, props: Props[Unit]): P = {
    mapStateAndRouteToProps(dispatch, state, Navigation(props))
  }

  def mapStateAndRouteToProps(
    dispatch: Dispatch,
    state: S,
    nav: Navigation): P
}
