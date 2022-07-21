
const createImage = () => {
  const Image = function () {
    return null
  }
  Image.displayName = "Image"
  Image.prefetch = function (url) {
    return Promise.resolve([undefined])
  }
  return Image
}

module.exports = {
  
  Alert: {
    alert: function (title) {
    }
  },
  
  StyleSheet: {
    create: function (obj) {
      return obj;
    }
  },
  
  Platform: {
    OS: "ios"
  },
  
  ActivityIndicator: 'ActivityIndicator',
  Button: 'Button',
  FlatList: 'FlatList',
  Image: createImage(),
  KeyboardAvoidingView: 'KeyboardAvoidingView',
  Modal: 'Modal',
  ScrollView: 'ScrollView',
  StatusBar: 'StatusBar',
  Switch: 'Switch',
  Text: 'Text',
  TextInput: 'TextInput',
  TouchableHighlight: 'TouchableHighlight',
  TouchableOpacity: 'TouchableOpacity',
  TouchableWithoutFeedback: 'TouchableWithoutFeedback',
  View: 'View'
}
