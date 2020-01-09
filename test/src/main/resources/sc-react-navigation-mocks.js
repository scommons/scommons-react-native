const React = require('react')
const { View } = require('react-native')

module.exports = {
  
  createAppContainer: function (obj) {
    return obj
  },
  
  createStackNavigator: function (routes, config) {
    return (props) => {
      return React.createElement(View, {routes, config})
    }
  }
}
