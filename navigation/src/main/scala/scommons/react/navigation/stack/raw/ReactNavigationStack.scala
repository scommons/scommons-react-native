package scommons.react.navigation.stack.raw

import scommons.react.ReactClass
import scommons.react.navigation.stack._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("react-navigation-stack", JSImport.Namespace)
object ReactNavigationStack extends js.Object {

  def createStackNavigator(routes: js.Dictionary[StackRouteConfig],
                           config: js.UndefOr[StackNavigatorConfig] = js.undefined
                          ): ReactClass = js.native
}
