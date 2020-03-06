
const createPicker = () => {
  const Picker = function () {}
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
  Image: 'Image',
  Modal: 'Modal',
  Picker: createPicker(),
  ScrollView: 'ScrollView',
  Text: 'Text',
  TextInput: 'TextInput',
  TouchableHighlight: 'TouchableHighlight',
  TouchableOpacity: 'TouchableOpacity',
  TouchableWithoutFeedback: 'TouchableWithoutFeedback',
  View: 'View'
}
