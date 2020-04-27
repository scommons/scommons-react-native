package scommons.expo.raw

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/** @see https://docs.expo.io/versions/latest/sdk/font/
  */
@js.native
@JSImport("expo-font", JSImport.Namespace)
object Font extends js.Object {

  def loadAsync(fontFamilyToSource: js.Dictionary[js.Any]): js.Promise[js.Any] = js.native
}
