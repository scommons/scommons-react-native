package showcase.app.style

import scommons.react._
import scommons.reactnative._

import scala.scalajs.js

object BorderRadiusDemo extends FunctionComponent[Unit] {

  private[style] val Example = new FunctionComponent[Unit] {

    protected def render(props: Props): ReactElement = {
      <.View(^.rnStyle := js.Array(
        styles.example,
        props.native.style.asInstanceOf[Style]
      ))(
        props.children
      )
    }
  }

  private[style] val CenteredText = new FunctionComponent[Unit] {

    protected def render(props: Props): ReactElement = {
      <.Text(^.rnStyle := js.Array(
        styles.centeredText,
        props.native.style.asInstanceOf[Style]
      ))(
        props.children
      )
    }
  }

  private[style] var exampleComp: UiComponent[Unit] = Example
  private[style] var centeredTextComp: UiComponent[Unit] = CenteredText

  protected def render(props: Props): ReactElement = {
    <.View(^.rnStyle := styles.container)(
      <(exampleComp())(^.rnStyle := new Style {
        override val borderRadius = 20
      })(
        <(centeredTextComp())()("Example 1:\n4 Rounded Corners")
      ),
      <(exampleComp())(^.rnStyle := new Style {
        override val borderTopRightRadius = 60
        override val borderBottomRightRadius = 60
      })(
        <(centeredTextComp())()("Example 2:\nD Shape")
      ),
      <(exampleComp())(^.rnStyle := new Style {
        override val borderTopLeftRadius = 30
        override val borderBottomRightRadius = 30
      })(
        <(centeredTextComp())()("Example 3:\nLeaf Shape")
      ),
      <(exampleComp())(^.rnStyle := new Style {
        override val borderRadius = 60
      })(
        <(centeredTextComp())()("Example 4:\nCircle")
      )
    )
  }

  private[style] lazy val styles = StyleSheet.create(new Styles)
  private[style] class Styles extends js.Object {
    import Style._
    import TextStyle._
    import ViewStyle._
    
    val container: Style = new ViewStyle {
      override val flex = 1
      override val justifyContent = JustifyContent.center
      override val alignItems = AlignItems.center
      override val flexDirection = FlexDirection.row
      override val flexWrap = FlexWrap.wrap
      override val backgroundColor = Style.Color.white
    }
    val example: Style = new ViewStyle {
      override val width = 120
      override val height = 120
      override val marginLeft = 20
      override val marginBottom = 20
      override val backgroundColor = Color.grey
      override val borderWidth = 2
      override val justifyContent = JustifyContent.center
    }
    val centeredText: Style = new TextStyle {
      override val textAlign = TextAlign.center
      override val margin = 10
    }
  }
}
