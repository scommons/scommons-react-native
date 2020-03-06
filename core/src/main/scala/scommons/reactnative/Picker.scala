package scommons.reactnative

import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._

import scala.scalajs.js
import scala.scalajs.js.|

/** @see https://reactnative.dev/docs/picker
  */
object Picker {

  trait PickerAttributes {

    import PickerAttributes._

    lazy val onValueChange = OnValueChangeAttributeSpec("onValueChange")
    lazy val selectedValue = SelectedValueAttributeSpec("selectedValue")
  }

  object PickerAttributes {

    import VirtualDOMAttributes.Type._

    case class OnValueChangeAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: js.Function2[String, Int, Unit]): Attribute[js.Function2[String, Int, Unit]] =
        Attribute(name, value, AS_IS)
    }

    case class SelectedValueAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: String | Int): Attribute[String | Int] = Attribute(name, value, AS_IS)
    }

  }

}
