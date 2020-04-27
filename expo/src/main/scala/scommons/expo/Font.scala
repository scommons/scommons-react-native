package scommons.expo

import scommons.reactnative.StaticResource

import scala.concurrent.Future
import scala.scalajs.js

/** @see https://docs.expo.io/versions/latest/sdk/font/
  */
object Font {

  def loadAsync(fonts: Seq[(String, StaticResource)]): Future[js.Any] = {
    loadAsync(js.Dictionary[js.Any](fonts: _*))
  }
  
  def loadAsync(fonts: js.Dictionary[js.Any]): Future[js.Any] = {
    raw.Font.loadAsync(fonts).toFuture
  }
}
