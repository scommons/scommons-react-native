package showcase.app

import scommons.react._
import scommons.reactnative.ScrollView._
import scommons.reactnative.Style.Color
import scommons.reactnative._

import scala.scalajs.js

object ShowcaseScreen extends FunctionComponent[Unit] {

  protected def render(compProps: Props): ReactElement = {
    val navProps = compProps.native.navigation
    
    <.ScrollView(
      ^.keyboardShouldPersistTaps := KeyboardShouldPersistTaps.always
    )(
      <.TouchableWithoutFeedback(^.onPress := { () =>
        navProps.navigate("Styles")
      })(
        <.View(^.rnStyle := styles.itemContainer)(
          <.Text(^.rnStyle := styles.itemTitle)("Styles"),
          <.Text(^.rnStyle := styles.itemDescription)("Demo style components")
        )
      )
    )
  }

  private[app] lazy val styles = StyleSheet.create(new Styles)
  private[app] class Styles extends js.Object {
    val itemContainer: Style = new ViewStyle {
      override val padding = 10
      override val borderBottomWidth = 2
      override val borderBottomColor = Color.darkgray
    }
    val itemTitle: Style = new TextStyle {
      override val fontSize = 20
    }
    val itemDescription: Style = new TextStyle {
      override val color = "rgba(0, 0, 0, .5)"
    }
  }
}
