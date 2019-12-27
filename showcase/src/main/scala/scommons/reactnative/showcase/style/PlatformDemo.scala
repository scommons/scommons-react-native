package scommons.reactnative.showcase.style

import scommons.react._
import scommons.reactnative._

import scala.scalajs.js

object PlatformDemo extends FunctionComponent[Unit] {

  protected def render(props: Props): ReactElement = {
    <.View(^.rnStyle := styles.container)(
      <.Text(^.rnStyle := styles.info)(
        s"You are using ${Platform.OS} platform"
      )
    )
  }

  private[style] lazy val styles = StyleSheet.create(new Styles)
  private[style] class Styles extends js.Object {
    val container: Style = new ViewStyle {
      override val marginLeft = 40
      override val marginBottom = 20
    }
    val info: Style = new TextStyle {
      override val fontFamily = Platform.select {
        case Platform.ios => "American Typewriter"
        case Platform.android => "monospace"
      }
    }
  }
}
