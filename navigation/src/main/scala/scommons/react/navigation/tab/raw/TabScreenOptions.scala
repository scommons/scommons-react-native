package scommons.react.navigation.tab.raw

import scommons.react._

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * @see https://reactnavigation.org/docs/bottom-tab-navigator/#options
  */
trait TabScreenOptions extends navigation.raw.NavigatorScreenOptions {

  val tabBarIcon: js.UndefOr[js.Function1[TabBarIconParams, ReactElement]] = js.undefined
  val tabBarLabel: js.UndefOr[String | js.Function1[TabBarLabelParams, ReactElement]] = js.undefined
  val tabBarButton: js.UndefOr[js.Function1[js.Dynamic, ReactElement]] = js.undefined
  val tabBarAccessibilityLabel: js.UndefOr[String] = js.undefined
  val unmountOnBlur: js.UndefOr[Boolean] = js.undefined
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
