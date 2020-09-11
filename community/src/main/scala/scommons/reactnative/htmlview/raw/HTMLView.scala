package scommons.reactnative.htmlview.raw

import scommons.react.ReactClass

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("react-native-htmlview", JSImport.Default)
object HTMLView extends ReactClass

@js.native
trait HTMLViewNode extends js.Object {

  def `type`: String
  def name: js.UndefOr[String]
  def attribs: js.Dynamic
  def data: js.UndefOr[String]

  def parent: js.UndefOr[HTMLViewNode]
  def children: js.Array[HTMLViewNode]
}
