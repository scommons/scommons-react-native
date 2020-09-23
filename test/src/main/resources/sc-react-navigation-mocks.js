
module.exports = {
  
  NavigationContainer: "NavigationContainer",
  
  getFocusedRouteNameFromRoute: function (route) {
    return null
  },
  
  useIsFocused: function () {
    return true
  },
  
  createStackNavigator: function () {
    return {
      Navigator: "Navigator",
      Screen: "Screen"
    }
  },
  
  createBottomTabNavigator: function () {
    return {
      Navigator: "Navigator",
      Screen: "Screen"
    }
  }
}
