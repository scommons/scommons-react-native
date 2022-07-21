
const createPicker = () => {
  const Picker = function () {
    return null
  }
  Picker.displayName = "Picker"
  Picker.Item = "Picker.Item"
  return Picker
}

module.exports = {
  
  Picker: createPicker(),

  SvgXml: 'SvgXml',
  SvgCss: 'SvgCss',
  
  WebView: 'WebView',
  
  SafeAreaProvider: 'SafeAreaProvider',
  SafeAreaView: 'SafeAreaView',
  useSafeAreaInsets: function () {
    return {
      top: 1,
      right: 2,
      bottom: 3,
      left: 4
    }
  }
}
