package scommons.reactnative

import scala.scalajs.js

object StyleSheet {

  def create[T <: js.Object](obj: T): T = {
    raw.StyleSheet.create(obj).asInstanceOf[T]
  }
}
