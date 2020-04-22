package scommons.expo

import scommons.reactnative.StaticResource

import scala.concurrent.Future
import scala.scalajs.js

/** @see https://docs.expo.io/versions/latest/sdk/asset/
  */
object Asset {

  def fromModule(module: StaticResource): Asset = {
    raw.Asset.fromModule(module)
  }
  
  def loadAsync(modules: Seq[StaticResource]): Future[js.Any] = {
    raw.Asset.loadAsync(js.Array(modules: _*)).toFuture
  }
  
  def loadAsync(module: StaticResource): Future[js.Any] = {
    raw.Asset.loadAsync(module).toFuture
  }
}
