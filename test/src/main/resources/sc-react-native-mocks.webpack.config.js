
module.exports = {
  
  resolve: {
    alias: {
      'react-native$': './sc-react-native-mocks.js'
    }
  },
  
  module: {
    rules: [{
      test: /\.(ico|png|gif|jpe?g|svg)$/i,
      use: [{
        loader: 'file-loader',
        options: {
          name: '[path][name].[ext]'
        }
      }]
    }]
  }
}
