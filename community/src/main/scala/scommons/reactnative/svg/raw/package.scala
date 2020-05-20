package scommons.reactnative.svg

import scommons.react.ReactClass

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

package object raw {

  @js.native
  @JSImport("react-native-svg", "SvgXml")
  object SvgXml extends ReactClass

}
