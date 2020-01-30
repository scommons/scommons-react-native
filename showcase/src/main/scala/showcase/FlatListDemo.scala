package showcase

import scommons.react._
import scommons.reactnative.FlatList._
import scommons.reactnative._

import scala.scalajs.js

/** @see https://facebook.github.io/react-native/docs/flatlist
  */
object FlatListDemo extends FunctionComponent[Unit] {
  
  case class Data(id: String, title: String)
  
  lazy val dataList = List(
    Data(
      id = "bd7acbea-c1b1-46c2-aed5-3ad53abb28ba",
      title = "First Item"
    ),
    Data(
      id = "3ac68afc-c605-48d3-a4f8-fbd91aa97f63",
      title = "Second Item"
    ),
    Data(
      id = "58694a0f-3da1-471f-bd96-145571e29d72",
      title = "Third Item"
    )
  )

  case class ItemProps(title: String)
  
  object Item extends FunctionComponent[ItemProps] {
    protected def render(compProps: Props): ReactElement = {
      val props = compProps.wrapped
      
      <.View(^.rnStyle := styles.item)(
        <.Text(^.rnStyle := styles.title)(props.title)
      )
    }
  }
  
  protected def render(props: Props): ReactElement = {
    <.View(^.rnStyle := styles.container)(
      <.FlatList(
        ^.flatListData := js.Array(dataList: _*),
        ^.renderItem := { data: FlatListData[Data] =>
          val item = data.item
          <(Item())(^.wrapped := ItemProps(item.title))()
        },
        ^.keyExtractor := { item: Data =>
          item.id
        }
      )()
    )
  }

  private[showcase] lazy val styles = StyleSheet.create(new Styles)
  private[showcase] class Styles extends js.Object {
    
    val container: Style = new ViewStyle {
      override val flex = 1
      override val marginTop = 20
    }
    val item: Style = new ViewStyle {
      override val backgroundColor = "#f9c2ff"
      override val padding = 20
      override val marginVertical = 8
      override val marginHorizontal = 16
    }
    val title: Style = new TextStyle {
      override val fontSize = 32
    }
  }
}
