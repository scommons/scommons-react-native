package showcase.app.video

import scommons.expo.av._
import scommons.react._
import scommons.reactnative._

import scala.scalajs.js

object VideoDemo extends FunctionComponent[Unit] {

  protected def render(props: Props): ReactElement = {
    <.View(^.rnStyle := styles.container)(
      <.Video(
        ^.rnStyle := styles.mediaPlayer,
        ^.expoAVSource := new ExpoAVSource {
          override val uri = "http://d23dyxeqlo5psv.cloudfront.net/big_buck_bunny.mp4"
        },
        ^.shouldPlay := true,
        ^.useNativeControls := true
      )()
    )
  }

  private[video] lazy val styles = StyleSheet.create(new Styles)
  private[video] class Styles extends js.Object {
    import Style._
    
    val container: Style = new ViewStyle {
      override val flex = 1
    }
    val mediaPlayer: Style = new ViewStyle {
      override val position = Position.absolute
      override val top = 0
      override val left = 0
      override val bottom = 0
      override val right = 0
      override val backgroundColor = Color.black
    }
  }
}
