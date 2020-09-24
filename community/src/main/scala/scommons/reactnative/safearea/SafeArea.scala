package scommons.reactnative.safearea

import scala.scalajs.js

trait SafeArea {

  protected def native: raw.SafeArea
  
  @inline
  def useSafeAreaInsets(): SafeAreaInsets = native.useSafeAreaInsets()
}

object SafeArea {

  trait SafeAreaEdge extends js.Object

  object SafeAreaEdge {
    val top: SafeAreaEdge = "top".asInstanceOf[SafeAreaEdge]
    val right: SafeAreaEdge = "right".asInstanceOf[SafeAreaEdge]
    val bottom: SafeAreaEdge = "bottom".asInstanceOf[SafeAreaEdge]
    val left: SafeAreaEdge = "left".asInstanceOf[SafeAreaEdge]
  }

  trait SafeAreaMode extends js.Object

  object SafeAreaMode {
    /** default */
    val padding: SafeAreaMode = "padding".asInstanceOf[SafeAreaMode]
    val margin: SafeAreaMode = "margin".asInstanceOf[SafeAreaMode]
  }

}
