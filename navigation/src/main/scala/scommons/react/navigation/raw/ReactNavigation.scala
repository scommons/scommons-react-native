package scommons.react.navigation.raw

import io.github.shogowada.scalajs.reactjs.classes.ReactClass

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("@react-navigation/native", JSImport.Namespace)
object ReactNavigation extends ReactNavigation

@js.native
trait ReactNavigation extends js.Object {
  
  val NavigationContainer: ReactClass = js.native
  
  def getFocusedRouteNameFromRoute(route: Route): js.Any = js.native
  
  def useIsFocused(): Boolean = js.native
}

/**
  * @see https://reactnavigation.org/docs/en/navigation-prop.html
  */
@js.native
trait Navigation extends js.Object {
  
  def navigate(name: String): Unit = js.native
  def navigate(name: String, params: js.Any): Unit = js.native
  
  def goBack(): Unit = js.native
  
  def isFocused: Boolean = js.native
  
  def setParams(params: js.Any): Unit = js.native
  def setOptions(options: js.Object): Unit = js.native
}

@js.native
trait Route extends js.Object {
  
  def name: String = js.native
  def key: String = js.native
  def params: js.Any = js.native
}

@js.native
trait NavigationProps extends js.Object {
  
  def navigation: Navigation = js.native
  def route: Route = js.native
}
