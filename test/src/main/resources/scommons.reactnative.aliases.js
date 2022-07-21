const moduleAlias = require('module-alias')

// see:
//  https://www.npmjs.com/package/module-alias
//
moduleAlias.addAliases({
  'react-redux': 'react-redux/lib/alternate-renderers',
  'react-native': __dirname + '/sc-react-native-mocks.js',
  '@react-native-picker/picker': __dirname + '/sc-react-native-community-mocks.js',
  'react-native-safe-area-context': __dirname + '/sc-react-native-community-mocks.js',
  'react-native-svg': __dirname + '/sc-react-native-community-mocks.js',
  'react-native-webview': __dirname + '/sc-react-native-community-mocks.js',
  'react-native-htmlview': __dirname + '/sc-react-native-htmlview-mocks.js',
  'entities': __dirname + '/sc-entities-mocks.js',
  'react-native-syntax-highlighter': __dirname + '/sc-react-native-syntax-highlighter-mocks.js',
  'react-syntax-highlighter/styles/hljs': __dirname + '/sc-react-syntax-highlighter-mocks.js',
  '@react-navigation/native': __dirname + '/sc-react-navigation-mocks.js',
  '@react-navigation/stack': __dirname + '/sc-react-navigation-mocks.js',
  '@react-navigation/bottom-tabs': __dirname + '/sc-react-navigation-mocks.js',
  'expo-asset': __dirname + '/sc-expo-asset-mocks.js',
  'expo-font': __dirname + '/sc-expo-font-mocks.js',
  'expo-av': __dirname + '/sc-expo-mocks.js',
  'expo-sqlite': __dirname + '/sc-expo-sqlite-mocks.js',
  '@expo/vector-icons': __dirname + '/sc-expo-mocks.js'
})

// see:
//  https://stackoverflow.com/questions/12752622/require-file-as-string
//
const aliasFileExtensions = [
  'ico', 'png', 'gif', 'jpg', 'jpeg', 'ttf', 'mp3', 'wav', 'mp4', 'mov', 'html', 'pdf'
]
aliasFileExtensions.forEach(ext => {
  require.extensions['.' + ext] = function (module, filename) {
    module.exports = filename
  }
})
