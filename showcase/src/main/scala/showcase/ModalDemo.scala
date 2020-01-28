package showcase

import scommons.react._
import scommons.react.hooks._
import scommons.reactnative.Modal._
import scommons.reactnative._

import scala.scalajs.js

object ModalDemo extends FunctionComponent[Unit] {

  protected def render(props: Props): ReactElement = {
    val (modalVisible, setModalVisible) = useState(false)
    
    <.View(^.rnStyle := styles.container)(
      <.Modal(
        ^.animationType := AnimationType.slide,
        ^.transparent := false,
        ^.visible := modalVisible,
        ^.onShow := { () =>
          println("modal is visible")
        },
        ^.onRequestClose := { () =>
          println("modal will be closed")
        }
      )(
        <.View(^.rnStyle := styles.container)(
          <.View()(
            <.Text()("Hello World!"),
            <.TouchableHighlight(
              ^.onPress := { () =>
                setModalVisible(false)
              }
            )(
              <.Text()("Hide Modal")
            )
          )
        )
      ),

      <.TouchableHighlight(
        ^.onPress := { () =>
          setModalVisible(true)
        }
      )(
        <.Text()("Show Modal")
      )
    )
  }

  private[showcase] lazy val styles = StyleSheet.create(new Styles)
  private[showcase] class Styles extends js.Object {
    
    val container: Style = new ViewStyle {
      override val marginTop = 22
    }
  }
}
