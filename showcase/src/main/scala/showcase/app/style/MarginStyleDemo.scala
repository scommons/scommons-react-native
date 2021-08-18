package showcase.app.style

import scommons.react._
import scommons.reactnative._

import scala.scalajs.js

object MarginStyleDemo extends FunctionComponent[Unit] {

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
      <.View(^.rnStyle := styles.exampleContainer)(
        <(exampleComp())()(
          <(centeredTextComp())()("A")
        )
      ),
      <.View(^.rnStyle := styles.exampleContainer)(
        <(exampleComp())(^.rnStyle := new Style {
          override val marginTop = 50
        })(
          <(centeredTextComp())()("B")
        )
      ),
      <.View(^.rnStyle := styles.exampleContainer)(
        <(exampleComp())(^.rnStyle := new Style {
          override val marginTop = 50
          override val marginLeft = 10
        })(
          <(centeredTextComp())()("C")
        )
      ),
      <.View(^.rnStyle := styles.exampleContainer)(
        <(exampleComp())(^.rnStyle := new Style {
          override val marginLeft = -10
          override val marginTop = -10
        })(
          <(centeredTextComp())()("D")
        )
      )
    )
  }

  private[style] lazy val styles = StyleSheet.create(new Styles)
  private[style] class Styles extends js.Object {
    import Style._
    import TextStyle._
    import ViewStyle._
    
    val container: Style = new ViewStyle {
      override val alignItems = AlignItems.center
      override val flex = 1
      override val flexDirection = FlexDirection.row
      override val flexWrap = FlexWrap.wrap
      override val justifyContent = JustifyContent.center
      override val backgroundColor = Style.Color.white
    }
    val exampleContainer: Style = new ViewStyle {
      override val borderWidth = 1
      override val width = 120
      override val height = 120
      override val marginLeft = 20
      override val marginBottom = 20
    }
    val example: Style = new ViewStyle {
      override val width = 50
      override val height = 50
      override val backgroundColor = Color.grey
      override val borderWidth = 1
      override val justifyContent = JustifyContent.center
    }
    val centeredText: Style = new TextStyle {
      override val textAlign = TextAlign.center
      override val margin = 10
    }
  }
}
