package scommons.reactnative

import io.github.shogowada.scalajs.reactjs.classes.ReactClass

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

package object raw {

  @js.native
  @JSImport("react-native", "StyleSheet")
  object StyleSheet extends js.Object {

    def create(obj: js.Object): js.Object = js.native
  }
  
  @js.native
  @JSImport("react-native", "Platform")
  object Platform extends js.Object {

    val OS: String = js.native
  }
  
  @js.native
  @JSImport("react-native", "ActivityIndicator") object ActivityIndicator extends ReactClass

  @js.native
  @JSImport("react-native", "Button") object Button extends ReactClass

  @js.native
  @JSImport("react-native", "FlatList") object FlatList extends ReactClass

  @js.native
  @JSImport("react-native", "Image") object Image extends ReactClass {

    def prefetch(url: String): js.Promise[js.Any] = js.native
  }

  @js.native
  @JSImport("react-native", "Modal") object Modal extends ReactClass

  @js.native
  @JSImport("react-native", "Picker") object Picker extends ReactClass {

    val Item: ReactClass = js.native
  }

  @js.native
  @JSImport("react-native", "ScrollView") object ScrollView extends ReactClass

  @js.native
  @JSImport("react-native", "Text") object Text extends ReactClass

  @js.native
  @JSImport("react-native", "TextInput") object TextInput extends ReactClass

  @js.native
  @JSImport("react-native", "TouchableHighlight") object TouchableHighlight extends ReactClass

  @js.native
  @JSImport("react-native", "TouchableOpacity") object TouchableOpacity extends ReactClass

  @js.native
  @JSImport("react-native", "TouchableWithoutFeedback") object TouchableWithoutFeedback extends ReactClass

  @js.native
  @JSImport("react-native", "View") object View extends ReactClass

}
