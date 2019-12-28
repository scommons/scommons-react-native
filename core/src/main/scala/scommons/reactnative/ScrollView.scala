package scommons.reactnative

import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._

import scala.scalajs.js

/** @see https://facebook.github.io/react-native/docs/scrollview
  */
object ScrollView {

  trait ScrollViewAttributes {

    import ScrollViewAttributes._

    lazy val keyboardShouldPersistTaps = KeyboardShouldPersistTapsAttribute("keyboardShouldPersistTaps")
  }

  object ScrollViewAttributes {

    import VirtualDOMAttributes.Type._

    case class KeyboardShouldPersistTapsAttribute(name: String) extends AttributeSpec {
      def :=(value: KeyboardShouldPersistTaps): Attribute[KeyboardShouldPersistTaps] = Attribute(name, value, AS_IS)
    }

  }

  trait KeyboardShouldPersistTaps extends js.Object

  object KeyboardShouldPersistTaps {
    /** default */
    val never: KeyboardShouldPersistTaps = "never".asInstanceOf[KeyboardShouldPersistTaps]
    val always: KeyboardShouldPersistTaps = "always".asInstanceOf[KeyboardShouldPersistTaps]
    val handled: KeyboardShouldPersistTaps = "handled".asInstanceOf[KeyboardShouldPersistTaps]
  }

}
