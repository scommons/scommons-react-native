package scommons.react.navigation.tab.raw

import scommons.react._
import scommons.react.navigation.tab.TabBarOptions.LabelPosition
import scommons.reactnative.Style

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * @see https://reactnavigation.org/docs/bottom-tab-navigator/#options
  */
trait TabScreenOptions extends navigation.raw.NavigatorScreenOptions {

  val tabBarStyle: js.UndefOr[Style] = js.undefined
  val tabBarActiveTintColor: js.UndefOr[String] = js.undefined
  val tabBarActiveBackgroundColor: js.UndefOr[String] = js.undefined
  val tabBarInactiveTintColor: js.UndefOr[String] = js.undefined
  val tabBarInactiveBackgroundColor: js.UndefOr[String] = js.undefined
  val tabBarShowLabel: js.UndefOr[Boolean] = js.undefined
  val tabBarLabel: js.UndefOr[String | js.Function1[TabBarLabelParams, ReactElement]] = js.undefined
  val tabBarLabelStyle: js.UndefOr[Style] = js.undefined
  val tabBarLabelPosition: js.UndefOr[LabelPosition] = js.undefined
  val tabBarItemStyle: js.UndefOr[Style] = js.undefined
  val tabBarAllowFontScaling: js.UndefOr[Boolean] = js.undefined
  val tabBarHideOnKeyboard: js.UndefOr[Boolean] = js.undefined
  val tabBarShowIcon: js.UndefOr[Boolean] = js.undefined
  val tabBarIcon: js.UndefOr[js.Function1[TabBarIconParams, ReactElement]] = js.undefined
  val tabBarIconStyle: js.UndefOr[Style] = js.undefined
  val tabBarButton: js.UndefOr[js.Function1[js.Dynamic, ReactElement]] = js.undefined
  val tabBarAccessibilityLabel: js.UndefOr[String] = js.undefined
  val unmountOnBlur: js.UndefOr[Boolean] = js.undefined
  val `lazy`: js.UndefOr[Boolean] = js.undefined
}

@js.native
trait TabBarIconParams extends js.Object {

  def focused: Boolean = js.native
  def color: String = js.native
  def size: Int = js.native
}

@js.native
trait TabBarLabelParams extends js.Object {

  def focused: Boolean = js.native
  def color: String = js.native
}
