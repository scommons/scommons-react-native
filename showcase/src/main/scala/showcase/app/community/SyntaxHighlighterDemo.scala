package showcase.app.community

import scommons.react._
import scommons.reactnative._
import scommons.reactnative.highlighter._
import scommons.reactnative.htmlview._

import scala.scalajs.js

/** @see https://github.com/conorhastings/react-native-syntax-highlighter
  */
object SyntaxHighlighterDemo extends FunctionComponent[Unit] {

  def renderNode(node: HTMLViewNode,
                 index: Int,
                 siblings: js.Array[HTMLViewNode],
                 parent: js.UndefOr[HTMLViewNode],
                 defaultRenderer: DefaultRendererFn): js.Any = {

    val tagName = node.name.getOrElse("")
    val codeBlock =
      if (tagName == "pre") {
        node.children.find(_.name.getOrElse("") == "code")
          .flatMap(_.children.headOption.flatMap(_.data.toOption))
      }
      else None
    
    codeBlock match {
      case Some(code) =>
        <.SyntaxHighlighter(
          ^.key := s"$index",
          ^.PreTag := <.Text.reactClass, // default is ScrollView
          ^.CodeTag := <.Text.reactClass, // default is ScrollView
          //^.fontSize := 24,
          ^.customStyle := customStyle,
          ^.highlighter := "hljs",
          ^.highlighterStyle := getHighlightJsStyle("dark")
            .getOrElse(HighlightJsStyles.defaultStyle)
        )(entities.decodeHTML(code.trim))
      case None => ()
    }
  }
  
  protected def render(props: Props): ReactElement = {
    <.View(^.rnStyle := styles.container)(
      <.Text(^.rnStyle := styles.title)("SyntaxHighlighter:"),
      <.SyntaxHighlighter(
        ^.language := "javascript",
        ^.highlighter := "hljs",
        ^.highlighterStyle := getHighlightJsStyle("github")
          .getOrElse(HighlightJsStyles.defaultStyle)
      )(
        """(num) => num + 1"""
      ),
      
      <.Text(^.rnStyle := styles.title)("HtmlView with SyntaxHighlighter:"),
      <.HTMLView(
        ^.renderNode := renderNode,
        ^.value :=
          """<pre>
            |  <code>val test = 1 + 2;</code>
            |</pre>
            |""".stripMargin
      )()
    )
  }

  private[community] val customStyle = new js.Object {
    val padding = 0
    val margin = 0
  }
  
  private[community] lazy val styles = StyleSheet.create(new Styles)
  private[community] class Styles extends js.Object {

    val container: Style = new ViewStyle {
      //override val flex = 1
    }
    val title: Style = new TextStyle {
      override val marginTop = 15
      override val marginBottom = 5
    }
  }
}
