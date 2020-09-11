package showcase.app.community

import scommons.react._
import scommons.reactnative._
import scommons.reactnative.htmlview._

import scala.scalajs.js

/** @see https://github.com/jsdf/react-native-htmlview
  */
object HTMLViewDemo extends FunctionComponent[Unit] {

  def renderNode(node: HTMLViewNode,
                 index: Int,
                 siblings: js.Array[HTMLViewNode],
                 parent: js.UndefOr[HTMLViewNode],
                 defaultRenderer: DefaultRendererFn): js.Any = {
    
    if (node.name.getOrElse("") == "custom") {
      val specialStyle = node.attribs.style.asInstanceOf[Style]
      
      <.Text(^.key := s"$index", ^.rnStyle := js.Array(specialStyle, styles.customText))(
        defaultRenderer(node.children, parent)
      )
    }
    else ()
  }
  
  protected def render(props: Props): ReactElement = {
    <.View(^.rnStyle := styles.container)(
      <.Text(^.rnStyle := styles.title)("Simple Html:"),
      <.HTMLView(
        ^.value := "<h1>Rendered from html!</h1>"
      )(),
      
      <.Text(^.rnStyle := styles.title)("Html with custom styles/tags:"),
      <.HTMLView(
        ^.stylesheet := htmlStyles,
        ^.renderNode := renderNode,
        ^.value :=
          """<h1>Custom style example</h1>
            |<div>
            |  <custom>Rendered with custom tag/style</custom>
            |</div>
            |""".stripMargin
      )()
    )
  }

  private[community] lazy val htmlStyles = StyleSheet.create(new js.Object {
    val h1 = new TextStyle {
      override val fontSize = 24
      override val color = Style.Color.blue
    }
  })
  
  private[community] lazy val styles = StyleSheet.create(new Styles)
  private[community] class Styles extends js.Object {

    val container: Style = new ViewStyle {
      override val flex = 1
    }
    val title: Style = new TextStyle {
      override val marginTop = 15
      override val marginBottom = 5
    }
    val customText: Style = new TextStyle {
      override val backgroundColor = Style.Color.yellow
      override val color = Style.Color.red
    }
  }
}
