package showcase

import scommons.react._
import scommons.reactnative.Alert._
import scommons.reactnative._

import scala.scalajs.js

/** @see https://facebook.github.io/react-native/docs/alert
  */
object AlertDemo extends FunctionComponent[Unit] {

  private[showcase] var okHandler = { () =>
    println("OK pressed")
  }
  
  protected def render(props: Props): ReactElement = {
    val okButton = AlertButton("OK", onPress = okHandler)
    val cancelButton = AlertButton("Cancel", onPress = { () => println("Cancel pressed") },
      style = Some(AlertButtonStyle.cancel)
    )
    
    <.View(^.rnStyle := styles.container)(
      <.Button(^.title := "2-Button Alert", ^.color := "#0000ff", ^.onPress := { () =>
        Alert.alert(
          title = "Alert Title",
          message = "My Alert Msg",
          buttons = List(cancelButton, okButton)
        )
      })(),
      <.Button(^.title := "3-Button Alert", ^.color := "#0000ff", ^.onPress := { () =>
        Alert.alert(
          title = "Alert Title",
          message = "",
          buttons = List(
            AlertButton("Ask me later", onPress = { () => println("Ask me later pressed") }),
            cancelButton,
            okButton
          )
        )
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
