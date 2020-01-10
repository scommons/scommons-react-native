package scommons.react.navigation

import scommons.react.ReactClass
import scommons.react.navigation.stack.raw.ReactNavigationStack

import scala.scalajs.js

package object stack {

  def createStackNavigator(routes: Map[String, StackRouteConfig],
                           config: StackNavigatorConfig): ReactClass = {
    
    ReactNavigationStack.createStackNavigator(js.Dictionary(routes.toList: _*), config)
  }
}
