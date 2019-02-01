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
  @JSImport("react-native", "Image") object Image extends ReactClass

  @js.native
  @JSImport("react-native", "ScrollView") object ScrollView extends ReactClass

  @js.native
  @JSImport("react-native", "Text") object Text extends ReactClass

  @js.native
  @JSImport("react-native", "TextInput") object TextInput extends ReactClass

  @js.native
  @JSImport("react-native", "TouchableHighlight") object TouchableHighlight extends ReactClass

  @js.native
  @JSImport("react-native", "View") object View extends ReactClass

}
