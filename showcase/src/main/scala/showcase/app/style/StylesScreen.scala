package showcase.app.style

import showcase.PlatformDemo
import scommons.react._
import scommons.reactnative.ScrollView._
import scommons.reactnative._

import scala.scalajs.js

object StylesScreen extends FunctionComponent[Unit] {

  protected def render(props: Props): ReactElement = {
    <.View(^.rnStyle := styles.container)(
      <.ScrollView(
        ^.rnStyle := styles.content,
        ^.keyboardShouldPersistTaps := KeyboardShouldPersistTaps.always
      )(
        <.Text()("Border Styles:\n"),
        <(BorderStyleDemo())()(),
        
        <.Text()("Border Radius Styles:\n"),
        <(BorderRadiusDemo())()(),
        
        <.Text()("Margin Styles:\n"),
        <(MarginStyleDemo())()(),
        
        <.Text()("Padding Styles:\n"),
        <(PaddingStyleDemo())()(),
        
        <.Text()("Position Styles:\n"),
        <(PositionStyleDemo())()(),

        <.Text()(s"Platform:\n"),
        <(PlatformDemo())()(),
        
        <.Text()(s"TextStyle:\n"),
        <(TextStyleDemo())()(),
        
        <.Text()("Profile Card:\n"),
        <(ProfileCard())()()
      )
    )
  }

  private[style] lazy val styles = StyleSheet.create(new Styles)
  private[style] class Styles extends js.Object {
    val container: Style = new ViewStyle {
      override val flex = 1
      override val backgroundColor = "#f5f5f5"
    }
    val content: Style = new ViewStyle {
      override val flex = 1
      override val paddingTop = 60
    }
  }
}