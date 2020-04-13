package scommons.react.navigation.tab

import scommons.react.navigation.tab.TabBarOptions._
import scommons.reactnative.Style

import scala.scalajs.js

trait TabBarOptions extends js.Object {

  val activeTintColor: js.UndefOr[String] = js.undefined
  val activeBackgroundColor: js.UndefOr[String] = js.undefined
  val inactiveTintColor: js.UndefOr[String] = js.undefined
  val inactiveBackgroundColor: js.UndefOr[String] = js.undefined
  val showLabel: js.UndefOr[Boolean] = js.undefined
  val showIcon: js.UndefOr[Boolean] = js.undefined
  val style: js.UndefOr[Style] = js.undefined
  val labelStyle: js.UndefOr[Style] = js.undefined
  val labelPosition: js.UndefOr[LabelPosition] = js.undefined
  val tabStyle: js.UndefOr[Style] = js.undefined
  val allowFontScaling: js.UndefOr[Boolean] = js.undefined
  val adaptive: js.UndefOr[Boolean] = js.undefined
  val keyboardHidesTabBar: js.UndefOr[Boolean] = js.undefined
}

object TabBarOptions {

  trait LabelPosition extends js.Object

  object LabelPosition {
    /** default */
    val `beside-icon`: LabelPosition = "beside-icon".asInstanceOf[LabelPosition]
    val `below-icon`: LabelPosition = "below-icon".asInstanceOf[LabelPosition]
  }

}
