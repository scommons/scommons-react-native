package scommons.react.navigation

import scala.scalajs.js

trait ReactNavigation {

  protected def native: raw.ReactNavigation

  def getFocusedRouteNameFromRoute(route: raw.Route): Option[String] = {
    val routeName = native.getFocusedRouteNameFromRoute(route)
    if (js.isUndefined(routeName) || routeName == null) None
    else Some(routeName.asInstanceOf[String])
  }

  @inline
  def useIsFocused(): Boolean = native.useIsFocused()
}
