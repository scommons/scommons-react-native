package scommons.reactnative.showcase

import scommons.react._
import scommons.reactnative.ViewStyle._
import scommons.reactnative._

import scala.scalajs.js

object ViewStyleDemo extends FunctionComponent[Unit] {

  protected def render(compProps: Props): ReactElement = {
    <.View(
      ^.rnStyle := styles.view
    )()
  }

  private lazy val styles = StyleSheet.create(new Styles)
  private class Styles extends js.Object {
    
    val view: Style = new ViewStyle {
      override val alignContent = AlignContent.center
      override val alignItems = AlignItems.baseline
      override val alignSelf = AlignSelf.stretch
      override val flex = 1
      override val flexBasis = 2
      override val flexDirection = FlexDirection.row
      override val flexGrow = 0.3
      override val flexShrink = 0.4
      override val flexWrap = FlexWrap.wrap
      override val justifyContent = JustifyContent.`space-evenly`
    }
  }
}
