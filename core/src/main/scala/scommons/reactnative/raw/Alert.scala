package scommons.reactnative.raw

import scommons.reactnative.Alert._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("react-native", "Alert")
object Alert extends js.Object {

  def alert(title: String,
            message: String = js.native,
            buttons: js.Array[AlertButton] = js.native,
            options: AlertOptions = js.native
           ): Unit = js.native
}

trait AlertButton extends js.Object {

  val text: String
  val onPress: js.Function0[Unit]
  val style: js.UndefOr[AlertButtonStyle] = js.undefined
}

trait AlertOptions extends js.Object {

  val cancelable: js.UndefOr[Boolean]
  val onDismiss: js.UndefOr[js.Function0[Unit]] = js.undefined
}
