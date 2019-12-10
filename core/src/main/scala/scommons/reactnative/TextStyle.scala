package scommons.reactnative

import scala.scalajs.js

trait TextStyle extends Style {

  val fontFamily: js.UndefOr[String] = js.undefined
  val fontSize: js.UndefOr[Int] = js.undefined
  val fontWeight: js.UndefOr[String] = js.undefined
}
