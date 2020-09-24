package scommons.reactnative.safearea.raw

import scommons.react.ReactClass

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("react-native-safe-area-context", JSImport.Namespace)
object SafeArea extends SafeArea

@js.native
trait SafeArea extends js.Object {
  
  val SafeAreaProvider: ReactClass = js.native
  val SafeAreaView: ReactClass = js.native
  
  def useSafeAreaInsets(): SafeAreaInsets = js.native
}

@js.native
trait SafeAreaInsets extends js.Object {

  def top: Int
  def right: Int
  def bottom: Int
  def left: Int
}
