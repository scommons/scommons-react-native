package scommons.react.navigation.raw

import io.github.shogowada.scalajs.reactjs.classes.ReactClass

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("react-navigation", JSImport.Namespace)
object ReactNavigation extends js.Object {

  def createAppContainer(comp: ReactClass): ReactClass = js.native
}

/**
  * @see https://reactnavigation.org/docs/en/navigation-prop.html
  */
@js.native
trait Navigation extends js.Object {
  
  def navigate(routeName: String): Unit = js.native
  def navigate(routeName: String, params: js.Any): Unit = js.native
  
  def goBack(): Unit = js.native
  
  def isFocused: Boolean = js.native
  
  def state: NavigationState = js.native
}

@js.native
trait NavigationState extends js.Object {
  
  def routeName: String = js.native
  def key: String = js.native
  def params: js.Any = js.native
}
