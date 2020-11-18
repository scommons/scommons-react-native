package showcase

import scommons.react._
import scommons.react.hooks._
import scommons.reactnative.Switch._
import scommons.reactnative._

import scala.scalajs.js

/** @see https://reactnative.dev/docs/switch
  */
object SwitchDemo extends FunctionComponent[Unit] {

  protected def render(compProps: Props): ReactElement = {
    val (isEnabled, setIsEnabled) = useStateUpdater(false)
    
    <.View(^.rnStyle := styles.container)(
      <.Text()("Dark Theme"),
      <.Switch(
        ^.trackColor := new TrackColor {
          val `false`: String = "#767577"
          val `true`: String = "#81b0ff"
        },
        ^.thumbColor := {
          if (isEnabled) "#f5dd4b" else "#f4f3f4"
        },
        ^("ios_backgroundColor") := "#3e3e3e",
        ^.switchOnValueChange := { _ =>
          setIsEnabled(enabled => !enabled)
        },
        ^.switchValue := isEnabled
      )()
    )
  }

  private[showcase] lazy val styles = StyleSheet.create(new Styles)
  private[showcase] class Styles extends js.Object {
    import ViewStyle._
    
    val container: Style = new ViewStyle {
      override val flex = 1
      override val alignItems = AlignItems.center
      override val justifyContent = JustifyContent.center
    }
  }
}
