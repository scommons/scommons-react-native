package scommons.react.navigation.raw

import scala.scalajs.js

/**
  * @see https://reactnavigation.org/docs/themes/
  */
trait Theme extends js.Object {

  val dark: Boolean
  val colors: ThemeColors
}

trait ThemeColors extends js.Object {

  val primary: String
  val background: String
  val card: String
  val text: String
  val border: String
  val notification: String
}
