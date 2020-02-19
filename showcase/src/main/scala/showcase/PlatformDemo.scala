package showcase

import scommons.react._
import scommons.reactnative._

import scala.scalajs.js

/** @see https://facebook.github.io/react-native/docs/platform-specific-code
  */
object PlatformDemo extends FunctionComponent[Unit] {

  protected def render(props: Props): ReactElement = {
    <.View(^.rnStyle := styles.container)(
      <.Text(^.rnStyle := styles.info)(
        s"You are using ${Platform.OS} platform"
      )
    )
  }

  private[showcase] lazy val styles = StyleSheet.create(new Styles)
  private[showcase] class Styles extends js.Object {
    import ViewStyle._
    
    val container: Style = new ViewStyle {
      override val flex = 1
      override val justifyContent = JustifyContent.center
      override val alignItems = AlignItems.center
    }
    val info: Style = new TextStyle {
      override val fontFamily = Platform.select {
        case Platform.ios | Platform.web => "American Typewriter"
        case Platform.android => "monospace"
      }
    }
  }
}
