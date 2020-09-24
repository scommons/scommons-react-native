package scommons.reactnative

import io.github.shogowada.scalajs.reactjs.VirtualDOM.VirtualDOMElements._
import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._

import scala.scalajs.js

/**
  * @see https://github.com/th3rdwave/react-native-safe-area-context
  */
package object safearea extends SafeArea {

  type SafeAreaInsets = safearea.raw.SafeAreaInsets

  protected lazy val native: safearea.raw.SafeArea = safearea.raw.SafeArea

  implicit class SafeAreaVirtualDOMElements(elements: VirtualDOMElements) {
    lazy val SafeAreaProvider: ReactClassElementSpec = elements(native.SafeAreaProvider)
    lazy val SafeAreaView: ReactClassElementSpec = elements(native.SafeAreaView)
  }

  implicit class SafeAreaVirtualDOMAttributes(attributes: VirtualDOMAttributes) {

    import SafeAreaVirtualDOMAttributes._
    
    //SafeAreaView
    lazy val edges = EdgesAttributeSpec("edges")
    lazy val mode = ModeAttributeSpec("mode")
  }

  object SafeAreaVirtualDOMAttributes {

    import VirtualDOMAttributes.Type._
    import SafeArea._

    case class EdgesAttributeSpec(name: String) extends AttributeSpec {
      def :=(values: Seq[SafeAreaEdge]): Attribute[js.Array[SafeAreaEdge]] = {
        Attribute(name, js.Array(values: _*), AS_IS)
      }
    }
    
    case class ModeAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: SafeAreaMode): Attribute[SafeAreaMode] = Attribute(name, value, AS_IS)
    }
  }

}
