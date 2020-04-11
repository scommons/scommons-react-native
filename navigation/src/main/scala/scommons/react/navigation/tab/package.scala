package scommons.react.navigation

package object tab {

  type TabScreenOptions = tab.raw.TabScreenOptions
  
  def createBottomTabNavigator(): tab.raw.TabNavigator =
    tab.raw.ReactNavigationBottomTabs.createBottomTabNavigator()
  
}
