package showcase

import scommons.react._
import scommons.react.hooks._
import scommons.reactnative.Modal._
import scommons.reactnative._

import scala.scalajs.js

/** @see https://facebook.github.io/react-native/docs/modal
  */
object ModalDemo extends FunctionComponent[Unit] {

  protected def render(props: Props): ReactElement = {
    val (modalVisible, setModalVisible) = useState(false)
    
    <.View(^.rnStyle := styles.container)(
      if (modalVisible) Some(
        <.Modal(
          ^.animationType := AnimationType.slide,
          ^.transparent := false,
          ^.visible := true,
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
              <.Button(^.title := "Hide Modal", ^.color := "#0000ff", ^.onPress := { () =>
                setModalVisible(false)
              })()
            )
          )
        )
      ) else None,

      <.Button(^.title := "Show Modal", ^.color := "#0000ff", ^.onPress := { () =>
        setModalVisible(true)
      })()
    )
  }

  private[showcase] lazy val styles = StyleSheet.create(new Styles)
  private[showcase] class Styles extends js.Object {
    
    val container: Style = new ViewStyle {
      override val marginTop = 22
    }
  }
}
