package scommons.expo.raw

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/** @see https://docs.expo.io/versions/latest/sdk/asset/
  */
@js.native
@JSImport("expo-asset", "Asset")
object Asset extends js.Object {

  /** Returns the [[Asset]] instance representing an asset given its module
    * 
    * @param module (number) -- The value of `require('path/to/file')` for the asset
    * @return       The [[Asset]] instance for the asset
    */
  def fromModule(module: js.Any): Asset = js.native

  /** A helper that wraps `Asset.fromModule(module).downloadAsync` for convenience.
    * 
    * @param modules (Array<number>|number) -- An array of require('path/to/file').
    *                Can also be just one module without an Array.
    * @return        Returns a Promise that resolves when the asset has been saved to disk.
    */
  def loadAsync(modules: js.Any): js.Promise[js.Any] = js.native
}

@js.native
trait Asset extends js.Object {

  def name: String = js.native
  def `type`: String = js.native
  def hash: String = js.native
  def uri: String = js.native
  def localUri: js.UndefOr[String] = js.native
  def width: js.UndefOr[Int] = js.native
  def height: js.UndefOr[Int] = js.native
  
  def downloadAsync(): js.Promise[js.Any] = js.native
}
