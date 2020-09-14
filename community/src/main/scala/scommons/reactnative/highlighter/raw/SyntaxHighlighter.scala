package scommons.reactnative.highlighter.raw

import scommons.react.ReactClass

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("react-native-syntax-highlighter", JSImport.Default)
object SyntaxHighlighter extends ReactClass

@js.native
@JSImport("react-syntax-highlighter/styles/hljs", JSImport.Namespace)
object HighlightJsStyles extends HighlightJsStyles

@js.native
trait HighlightJsStyles extends js.Object {
  
  val defaultStyle: HighlighterStyle = js.native
}

@js.native
trait HighlighterStyle extends js.Object
