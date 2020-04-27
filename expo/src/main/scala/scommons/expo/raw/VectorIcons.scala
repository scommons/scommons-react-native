package scommons.expo.raw

import scommons.react.ReactClass
import scommons.reactnative.StaticResource

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * @see https://docs.expo.io/versions/latest/guides/icons/#expovector-icons
  */
@js.native
@JSImport("@expo/vector-icons", JSImport.Namespace)
object VectorIcons extends js.Object {
  
  def AntDesign: VectorFontComp = js.native
  def Entypo: VectorFontComp = js.native
  def EvilIcons: VectorFontComp = js.native
  def Feather: VectorFontComp = js.native
  def FontAwesome: VectorFontComp = js.native
  def FontAwesome5: VectorFontComp = js.native
  def Foundation: VectorFontComp = js.native
  def Ionicons: VectorFontComp = js.native
  def MaterialIcons: VectorFontComp = js.native
  def MaterialCommunityIcons: VectorFontComp = js.native
  def SimpleLineIcons: VectorFontComp = js.native
  def Octicons: VectorFontComp = js.native
  def Zocial: VectorFontComp = js.native
}

@js.native
trait VectorFontComp extends ReactClass {
  
  def font: js.Dictionary[StaticResource] = js.native
}
