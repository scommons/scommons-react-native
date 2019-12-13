package scommons.reactnative

import scala.scalajs.js

trait TextStyle extends Style {

  val fontFamily: js.UndefOr[String] = js.undefined
  val fontSize: js.UndefOr[Int] = js.undefined // default to 14
  val fontStyle: js.UndefOr[String] = js.undefined // normal (default), or italic
  val fontWeight: js.UndefOr[String] = js.undefined // normal (default, 400), bold, 100, 200 ... 900
}
