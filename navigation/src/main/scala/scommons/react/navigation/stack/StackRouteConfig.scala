package scommons.react.navigation.stack

import scommons.react.ReactClass

import scala.scalajs.js

trait StackRouteConfig extends js.Object {

  val screen: ReactClass
  
  val path: js.UndefOr[String] = js.undefined
  val params: js.UndefOr[js.Object] = js.undefined
  
  val navigationOptions: js.UndefOr[js.Function1[js.Object, js.Object]] = js.undefined
}
