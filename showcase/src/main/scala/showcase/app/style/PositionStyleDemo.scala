package showcase.app.style

import scommons.react._
import scommons.reactnative._

import scala.scalajs.js

object PositionStyleDemo extends FunctionComponent[Unit] {

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
    <.View(^.rnStyle := styles.screen)(
      <.View(^.rnStyle := styles.container)(
        <.View(^.rnStyle := styles.row)(
          <(exampleComp())()(
            <(centeredTextComp())()("A")
          ),
          <(exampleComp())()(
            <(centeredTextComp())()("B"),
            <.View(^.rnStyle := js.Array(styles.tinyExample, styles.positionAbsolute))(
              <(centeredTextComp())()("E")
            )
          ),
          <(exampleComp())()(
            <(centeredTextComp())()("C")
          )
        ),
        <(exampleComp())(^.rnStyle := styles.positionAbsolute)(
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
    
    val screen: Style = new ViewStyle {
      override val flex = 1
      override val justifyContent = JustifyContent.center
      override val alignItems = AlignItems.center
      override val backgroundColor = Style.Color.white
    }
    val container: Style = new ViewStyle {
      override val width = 300
      override val height = 300
      override val marginLeft = 40
      override val marginBottom = 20
      override val borderWidth = 1
    }
    val row: Style = new ViewStyle {
      override val flex = 1
      override val flexDirection = FlexDirection.row
    }
    val example: Style = new ViewStyle {
      override val width = 100
      override val height = 100
      override val backgroundColor = Color.grey
      override val borderWidth = 1
      override val justifyContent = JustifyContent.center
    }
    val tinyExample: Style = new ViewStyle {
      override val width = 30
      override val height = 30
      override val borderWidth = 1
      override val justifyContent = JustifyContent.center
      override val backgroundColor = Color.lightgrey
    }
    val centeredText: Style = new TextStyle {
      override val textAlign = TextAlign.center
      override val margin = 10
    }
    val positionAbsolute: Style = new ViewStyle {
      override val position = Position.absolute
      override val right = 0
      override val bottom = 0
    }
  }
}
