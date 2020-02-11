package scommons.react.navigation.stack.raw

import scommons.react.ReactClass

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("@react-navigation/stack", JSImport.Namespace)
object ReactNavigationStack extends js.Object {

  def createStackNavigator(): StackNavigator = js.native
}

@js.native
trait StackNavigator extends js.Object {
  
  def Navigator: ReactClass = js.native
  
  def Screen: ReactClass = js.native
}
