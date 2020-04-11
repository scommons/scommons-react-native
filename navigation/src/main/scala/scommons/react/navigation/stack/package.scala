package scommons.react.navigation

package object stack {

  type StackScreenOptions = stack.raw.StackScreenOptions
  
  def createStackNavigator(): stack.raw.StackNavigator =
    stack.raw.ReactNavigationStack.createStackNavigator()
  
}
