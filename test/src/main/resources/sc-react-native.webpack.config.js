
module.exports = {
  
  resolve: {
    alias: {
      'react-native$': './sc-react-native-mocks.js',
      '@react-navigation/native$': './sc-react-navigation-mocks.js',
      '@react-navigation/stack$': './sc-react-navigation-mocks.js',
      '@react-navigation/bottom-tabs$': './sc-react-navigation-mocks.js',
      'expo-asset$': './sc-expo-asset-mocks.js',
      'expo-av$': './sc-expo-mocks.js',
      '@expo/vector-icons$': './sc-expo-mocks.js'
    }
  },
  
  module: {
    rules: [{
      test: /\.(ico|png|gif|jpe?g|svg)$/i,
      use: [{
        loader: 'file-loader',
        options: {
          emitFile: false,
          name: '[path][name].[ext]'
        }
      }]
    }]
  }
}
