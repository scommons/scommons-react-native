package showcase.app

import scommons.react._
import scommons.reactnative.ScrollView._
import scommons.reactnative.Style.Color
import scommons.reactnative._

import scala.scalajs.js

case class ShowcaseListViewProps(items: List[(String, String)],
                                 navigate: String => Unit)

object ShowcaseListView extends FunctionComponent[ShowcaseListViewProps] {

  protected def render(compProps: Props): ReactElement = {
    val props = compProps.wrapped
    
    <.ScrollView(
      ^.keyboardShouldPersistTaps := KeyboardShouldPersistTaps.always
    )(
      props.items.map { case (item, description) =>
        <.TouchableWithoutFeedback(
          ^.key := item,
          ^.onPress := { () =>
            props.navigate(item)
          }
        )(
          <.View(^.rnStyle := styles.itemContainer)(
            <.Text(^.rnStyle := styles.itemTitle)(item),
            <.Text(^.rnStyle := styles.itemDescription)(description)
          )
        )
      }
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
