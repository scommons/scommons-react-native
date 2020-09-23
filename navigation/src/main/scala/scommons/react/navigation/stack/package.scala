package scommons.react.navigation

package object stack {

  type StackNavigator = stack.raw.StackNavigator
  type StackScreenOptions = stack.raw.StackScreenOptions
  
  def createStackNavigator(): StackNavigator =
    stack.raw.ReactNavigationStack.createStackNavigator()
  
}
