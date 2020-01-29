package showcase

import scommons.react._
import scommons.reactnative._

import scala.scalajs.js

/** @see https://facebook.github.io/react-native/docs/button
  */
object ButtonDemo extends FunctionComponent[Unit] {

  protected def render(props: Props): ReactElement = {
    <.View(^.rnStyle := js.Array(styles.container, styles.horizontal))(
      <.Button(^.title := "Press me", ^.color := "#0000ff", ^.onPress := { () => })(),
      <.Button(^.title := "Press me", ^.color := "#00ff00", ^.onPress := { () => })()
    )
  }

  private[showcase] lazy val styles = StyleSheet.create(new Styles)
  private[showcase] class Styles extends js.Object {
    import ViewStyle._
    
    val container: Style = new ViewStyle {
      override val flex = 1
      override val justifyContent = JustifyContent.center
    }
    val horizontal: Style = new ViewStyle {
      override val flexDirection = FlexDirection.row
      override val justifyContent = JustifyContent.`space-around`
      override val padding = 10
    }
  }
}
