package scommons.react.navigation

package object tab {

  type TabScreenOptions = tab.raw.TabScreenOptions
  type TabBarIconParams = tab.raw.TabBarIconParams
  type TabBarLabelParams = tab.raw.TabBarLabelParams
  
  def createBottomTabNavigator(): tab.raw.TabNavigator =
    tab.raw.ReactNavigationBottomTabs.createBottomTabNavigator()
  
}
