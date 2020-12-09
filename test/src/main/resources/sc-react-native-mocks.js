
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

const createPicker = () => {
  const Picker = function () {
    return null
  }
  Picker.displayName = "Picker"
  Picker.Item = "Picker.Item"
  return Picker
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
  Picker: createPicker(),
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
