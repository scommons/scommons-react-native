package showcase.app.style

import scommons.react._
import scommons.reactnative._

import scala.scalajs.js

object BorderStyleDemo extends FunctionComponent[Unit] {

  protected def render(props: Props): ReactElement = {
    import Style._
    
    <.View(^.rnStyle := styles.container)(
      <(Example())(^.rnStyle := new Style {
        override val borderWidth = 1
      })(
        <.Text()("borderWidth: 1")
      ),
      <(Example())(^.rnStyle := new Style {
        override val borderWidth = 3
        override val borderLeftWidth = 0
      })(
        <.Text()("borderWidth: 3, borderLeftWidth: 0")
      ),
      <(Example())(^.rnStyle := new Style {
        override val borderWidth = 3
        override val borderLeftColor = Color.red
      })(
        <.Text()("borderWidth: 3, borderLeftColor: 'red'")
      ),
      <(Example())(^.rnStyle := new Style {
        override val borderLeftWidth = 3
      })(
        <.Text()("borderLeftWidth: 3")
      ),
      <(Example())(^.rnStyle := new Style {
        override val borderWidth = 1
        override val borderStyle = BorderStyle.dashed
      })(
        <.Text()("borderWidth: 1, borderStyle: 'dashed'")
      )
    )
  }

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

  private[style] lazy val styles = StyleSheet.create(new Styles)
  private[style] class Styles extends js.Object {
    import ViewStyle._
    
    val container: Style = new ViewStyle {
      override val flex = 1
      override val justifyContent = JustifyContent.center
      override val alignItems = AlignItems.center
      override val backgroundColor = Style.Color.white
    }
    val example: Style = new ViewStyle {
      override val marginBottom = 15
    }
  }
}
