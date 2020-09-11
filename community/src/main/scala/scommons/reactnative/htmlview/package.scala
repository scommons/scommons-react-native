package scommons.reactnative

import io.github.shogowada.scalajs.reactjs.VirtualDOM.VirtualDOMElements.ReactClassElementSpec
import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._
import scommons.react.ReactElement

import scala.scalajs.js

/** @see https://github.com/jsdf/react-native-htmlview
  */
package object htmlview {

  type HTMLViewNode = htmlview.raw.HTMLViewNode
  type DefaultRendererFn =
    js.Function2[js.Array[HTMLViewNode], js.UndefOr[HTMLViewNode], ReactElement]

  implicit class HTMLViewVirtualDOMElements(elements: VirtualDOMElements) {
    lazy val HTMLView: ReactClassElementSpec = elements(htmlview.raw.HTMLView)
  }

  implicit class HTMLViewVirtualDOMAttributes(attributes: VirtualDOMAttributes) {

    import HTMLViewVirtualDOMAttributes._

    lazy val stylesheet = StyleSheetAttribute("stylesheet")
    lazy val renderNode = RenderNodeAttribute("renderNode")
  }

  object HTMLViewVirtualDOMAttributes {

    import VirtualDOMAttributes.Type._

    case class StyleSheetAttribute(name: String) extends AttributeSpec {
      def :=(value: js.Object): Attribute[js.Object] = Attribute(name, value, AS_IS)
    }
    
    type RenderNodeFn =
      js.Function5[HTMLViewNode, Int, js.Array[HTMLViewNode], js.UndefOr[HTMLViewNode], DefaultRendererFn, js.Any]
    
    case class RenderNodeAttribute(name: String) extends AttributeSpec {
      def :=(value: RenderNodeFn): Attribute[RenderNodeFn] = Attribute(name, value, AS_IS)
    }
  }

}
