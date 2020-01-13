package showcase

import showcase.app.style.StyleImages
import scommons.react._
import scommons.reactnative._

import scala.scalajs.js

object ImageDemo extends FunctionComponent[Unit] {

  protected def render(compProps: Props): ReactElement = {
    <.Image(
      ^.rnStyle := styles.image,
      ^.source := StyleImages.User
    )()
  }

  private[showcase] lazy val styles = StyleSheet.create(new Styles)
  private[showcase] class Styles extends js.Object {
    
    val image: Style = new ViewStyle {
      override val margin = 10
    }
  }
}