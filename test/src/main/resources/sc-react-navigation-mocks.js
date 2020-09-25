
const defaultTheme = {
  dark: false,
  colors: {
    primary: 'rgb(255, 45, 85)',
    background: 'rgb(242, 242, 242)',
    card: 'rgb(255, 255, 255)',
    text: 'rgb(28, 28, 30)',
    border: 'rgb(199, 199, 204)',
    notification: 'rgb(255, 69, 58)'
  }
}

const darkTheme = {
  dark: true,
  colors: {
    ...defaultTheme.colors,
    card: 'rgb(0, 0, 0)'
  }
}

module.exports = {
  
  NavigationContainer: "NavigationContainer",
  
  getFocusedRouteNameFromRoute: function (route) {
    return null
  },
  
  useIsFocused: function () {
    return true
  },
  
  useTheme: function () {
    return defaultTheme
  },
  
  DefaultTheme: defaultTheme,
  DarkTheme: darkTheme,
  
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
