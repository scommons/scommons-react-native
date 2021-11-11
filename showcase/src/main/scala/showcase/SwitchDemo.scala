package showcase

import showcase.app.config.ShowcaseConfigActions
import scommons.react._
import scommons.react.navigation._
import scommons.react.redux._
import scommons.reactnative.Switch._
import scommons.reactnative._

import scala.scalajs.js

case class SwitchDemoProps(dispatch: Dispatch,
                           actions: ShowcaseConfigActions,
                           darkTheme: Boolean)

/** @see https://reactnative.dev/docs/switch
  */
object SwitchDemo extends FunctionComponent[SwitchDemoProps] {

  protected def render(compProps: Props): ReactElement = {
    val props = compProps.wrapped
    
    implicit val theme: Theme = useTheme()
    
    <.View(^.rnStyle := styles.container)(
      <.Text(^.rnStyle := themeTextStyle)("Dark Theme"),
      <.Switch(
        ^.trackColor := new TrackColor {
          val `false`: String = "#767577"
          val `true`: String = "#81b0ff"
        },
        ^.thumbColor := {
          if (props.darkTheme) "#f5dd4b" else "#f4f3f4"
        },
        ^("ios_backgroundColor") := "#3e3e3e",
        ^.switchOnValueChange := { value =>
          props.actions.updateTheme(props.dispatch, value)
        },
        ^.switchValue := props.darkTheme
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
