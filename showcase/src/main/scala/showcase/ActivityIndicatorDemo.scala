package showcase

import scommons.react._
import scommons.reactnative.ActivityIndicator._
import scommons.reactnative._

import scala.scalajs.js

object ActivityIndicatorDemo extends FunctionComponent[Unit] {

  protected def render(props: Props): ReactElement = {
    <.View(^.rnStyle := js.Array(styles.container, styles.horizontal))(
      <.ActivityIndicator(^.aiSize := ActivityIndicatorSize.large, ^.color := "#0000ff")(),
      <.ActivityIndicator(^.aiSize := ActivityIndicatorSize.small, ^.color := "#00ff00")(),
      <.ActivityIndicator(^.aiSize := ActivityIndicatorSize.large, ^.color := "#0000ff")(),
      <.ActivityIndicator(^.aiSize := ActivityIndicatorSize.small, ^.color := "#00ff00")()
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
