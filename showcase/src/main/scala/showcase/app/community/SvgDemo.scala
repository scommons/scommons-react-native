package showcase.app.community

import scommons.react._
import scommons.reactnative._

import scala.scalajs.js

/** @see https://github.com/react-native-community/react-native-svg
  */
object SvgDemo extends FunctionComponent[Unit] {

  protected def render(props: Props): ReactElement = {
    <.View(^.rnStyle := styles.container)(
      <.Text(^.rnStyle := styles.title)("SvgXml:"),
      <(SvgXmlDemo())()(),

      <.Text(^.rnStyle := styles.title)("SvgCss:"),
      <(SvgCssDemo())()()
    )
  }

  private[community] lazy val styles = StyleSheet.create(new Styles)
  private[community] class Styles extends js.Object {
    import ViewStyle._

    val container: Style = new ViewStyle {
      override val flex = 1
      override val alignItems = AlignItems.center
    }
    val title: Style = new TextStyle {
      override val marginTop = 15
      override val marginBottom = 5
    }
  }
}
