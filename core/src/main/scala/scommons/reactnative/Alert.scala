package scommons.reactnative

import scala.scalajs.js

/** @see https://facebook.github.io/react-native/docs/alert
  */
object Alert {

  def alert(title: String,
            message: String,
            buttons: List[AlertButton] = Nil,
            options: raw.AlertOptions = defaultOptions
           ): Unit = {

    raw.Alert.alert(title, message, js.Array(buttons.map { btn =>
      new raw.AlertButton {
        override val text = btn.text
        override val onPress: js.Function0[Unit] = btn.onPress
        override val style: js.UndefOr[AlertButtonStyle] = btn.style match {
          case None => js.undefined
          case Some(v) => v
        }
      }
    }: _*), options)
  }
  
  case class AlertButton(text: String,
                         onPress: () => Unit,
                         style: Option[AlertButtonStyle] = None)

  private lazy val defaultOptions = new raw.AlertOptions {
    override val cancelable = false
  }

  trait AlertButtonStyle extends js.Object

  object AlertButtonStyle {

    val default: AlertButtonStyle = "default".asInstanceOf[AlertButtonStyle]
    val cancel: AlertButtonStyle = "cancel".asInstanceOf[AlertButtonStyle]
    val destructive: AlertButtonStyle = "destructive".asInstanceOf[AlertButtonStyle]
  }

}
