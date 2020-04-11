package scommons.react.navigation.tab.raw

import scommons.react.ReactClass

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * @see https://reactnavigation.org/docs/bottom-tab-navigator/
  */
@js.native
@JSImport("@react-navigation/bottom-tabs", JSImport.Namespace)
object ReactNavigationBottomTabs extends js.Object {

  def createBottomTabNavigator(): TabNavigator = js.native
}

@js.native
trait TabNavigator extends js.Object {
  
  def Navigator: ReactClass = js.native
  
  def Screen: ReactClass = js.native
}
