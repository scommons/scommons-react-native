package showcase.app.community

import scommons.react._
import scommons.react.navigation._
import scommons.reactnative._

import scala.scalajs.js

/** @see https://github.com/react-native-community/react-native-svg
  */
object SvgDemo extends FunctionComponent[Unit] {

  protected def render(props: Props): ReactElement = {
    implicit val theme: Theme = useTheme()
    
    <.View(^.rnStyle := styles.container)(
      <.Text(themeStyle(styles.title, themeTextStyle))("SvgXml:"),
      <(SvgXmlDemo())()(),

      <.Text(themeStyle(styles.title, themeTextStyle))("SvgCss:"),
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
