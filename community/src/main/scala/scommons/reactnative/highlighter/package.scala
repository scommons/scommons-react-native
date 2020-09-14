package scommons.reactnative

import io.github.shogowada.scalajs.reactjs.VirtualDOM.VirtualDOMElements.ReactClassElementSpec
import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._

import scala.scalajs.js

/** @see https://github.com/conorhastings/react-native-syntax-highlighter
  */
package object highlighter {

  val HighlightJsStyles: highlighter.raw.HighlightJsStyles = highlighter.raw.HighlightJsStyles
  type HighlighterStyle = highlighter.raw.HighlighterStyle
  
  def getHighlightJsStyle(name: String): Option[HighlighterStyle] = {
    val hljsStyle = highlighter.raw.HighlightJsStyles.asInstanceOf[js.Dynamic]
    hljsStyle.selectDynamic(name).asInstanceOf[js.UndefOr[HighlighterStyle]].toOption
  }
  
  implicit class SyntaxHighlighterVirtualDOMElements(elements: VirtualDOMElements) {
    lazy val SyntaxHighlighter: ReactClassElementSpec = elements(highlighter.raw.SyntaxHighlighter)
  }

  implicit class SyntaxHighlighterVirtualDOMAttributes(attributes: VirtualDOMAttributes) {

    import SyntaxHighlighterVirtualDOMAttributes._

    lazy val language = StringAttributeSpec("language")
    lazy val fontFamily = StringAttributeSpec("fontFamily")
    lazy val fontSize = IntegerAttributeSpec("fontSize")
    lazy val customStyle = CustomStyleAttributeSpec("customStyle")
    
    lazy val highlighter = StringAttributeSpec("highlighter")
    lazy val highlighterStyle = HighlighterStyleAttribute("style")
  }

  object SyntaxHighlighterVirtualDOMAttributes {

    import VirtualDOMAttributes.Type._

    case class CustomStyleAttributeSpec(name: String) extends AttributeSpec {
      def :=(style: js.Object): Attribute[js.Object] = Attribute(name, style, AS_IS)
    }

    case class HighlighterStyleAttribute(name: String) extends AttributeSpec {
      def :=(value: HighlighterStyle): Attribute[HighlighterStyle] = Attribute(name, value, AS_IS)
    }
  }

}
