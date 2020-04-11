package scommons.react.navigation.raw

import scommons.react._

import scala.scalajs.js

trait NavigatorScreenOptions extends js.Object {

  val title: js.UndefOr[String] = js.undefined
  val headerTintColor: js.UndefOr[String] = js.undefined
  val headerTitle: js.UndefOr[js.Function1[js.Dynamic, ReactElement]] = js.undefined
  val headerStyle: js.UndefOr[js.Object] = js.undefined
  val headerShown: js.UndefOr[Boolean] = js.undefined
  val gestureEnabled: js.UndefOr[Boolean] = js.undefined
}
