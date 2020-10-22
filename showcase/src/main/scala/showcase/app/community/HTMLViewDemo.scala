package showcase.app.community

import scommons.react._
import scommons.react.navigation._
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
    
    def getNodeText(node: HTMLViewNode): Option[String] = {
      node.children.headOption.flatMap(_.data.toOption)
    }

    val tagName = node.name.getOrElse("")
    if (tagName == "custom") {
      val specialStyle = node.attribs.style.asInstanceOf[Style]
      
      <.Text(^.key := s"$index", ^.rnStyle := js.Array(specialStyle, styles.customText))(
        entities.decodeHTML(getNodeText(node).getOrElse(""))
      )
    }
    else ()
  }
  
  protected def render(props: Props): ReactElement = {
    implicit val theme: Theme = useTheme()
    
    val textProps = ^.textComponentProps := {
      val attrs = new js.Object {
        val style = themeTextStyle
      }
      attrs
    }
    
    <.View(^.rnStyle := styles.container)(
      <.Text(themeStyle(styles.title, themeTextStyle))("Simple Html:"),
      <.HTMLView(
        textProps,
        ^.value := "<h1>Rendered from html!</h1>"
      )(),
      
      <.Text(themeStyle(styles.title, themeTextStyle))("Html with custom styles/tags:"),
      <.HTMLView(
        textProps,
        ^.stylesheet := htmlStyles,
        ^.renderNode := renderNode,
        ^.value :=
          """<h1>Custom style example</h1>
            |Some custom <b>&lt;tag&gt;</b> style:
            |<div>
            |  <custom>Rendered with &lt;custom&gt; tag/style</custom>
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
      override val color = DefaultTheme.colors.text
    }
    val customText: Style = new TextStyle {
      override val backgroundColor = Style.Color.yellow
      override val color = Style.Color.red
    }
  }
}
