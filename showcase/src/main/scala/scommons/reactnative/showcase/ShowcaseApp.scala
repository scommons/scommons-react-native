package scommons.reactnative.showcase

import scommons.react._
import scommons.reactnative.ScrollView._
import scommons.reactnative._
import scommons.reactnative.showcase.style._

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel(name = "ShowcaseApp")
object ShowcaseApp extends FunctionComponent[Unit] {

  @JSExport("apply")
  override def apply(): ReactClass = super.apply()

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

  private[showcase] lazy val styles = StyleSheet.create(new Styles)
  private[showcase] class Styles extends js.Object {
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
