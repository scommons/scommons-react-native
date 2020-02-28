package scommons.reactnative.ui.popup

import scommons.react._
import scommons.reactnative.ActivityIndicator._
import scommons.reactnative.Modal._
import scommons.reactnative._

import scala.scalajs.js

case class LoadingPopupProps(size: ActivityIndicatorSize = ActivityIndicatorSize.small,
                             color: String = Style.Color.gray)

object LoadingPopup extends FunctionComponent[LoadingPopupProps] {

  protected def render(compProps: Props): ReactElement = {
    val props = compProps.wrapped
    
    <.Modal(
      ^.animationType := AnimationType.none,
      ^.transparent := true,
      ^.visible := true
    )(
      <.View(^.rnStyle := styles.container)(
        <.ActivityIndicator(^.aiSize := props.size, ^.color := props.color)()
      )
    )
  }

  private[popup] lazy val styles = StyleSheet.create(new Styles)
  private[popup] class Styles extends js.Object {
    import ViewStyle._

    val container: Style = new ViewStyle {
      override val flex = 1
      override val justifyContent = JustifyContent.center
      override val alignContent = AlignContent.center
    }
  }
}
