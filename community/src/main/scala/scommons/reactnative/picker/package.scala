package scommons.reactnative

import io.github.shogowada.scalajs.reactjs.VirtualDOM.VirtualDOMElements.ReactClassElementSpec
import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._

import scala.scalajs.js
import scala.scalajs.js.|

/** @see https://github.com/react-native-picker/picker
 */
package object picker {

  implicit class PickerVirtualDOMElements(elements: VirtualDOMElements) {
    lazy val Picker: ReactClassElementSpec = elements(raw.Picker)
    lazy val PickerItem: ReactClassElementSpec = elements(raw.Picker.Item)
  }

  implicit class PickerVirtualDOMAttributes(attributes: VirtualDOMAttributes) {

    import PickerVirtualDOMAttributes._

    lazy val onValueChange = OnValueChangeAttributeSpec("onValueChange")
    lazy val selectedValue = SelectedValueAttributeSpec("selectedValue")
  }

  object PickerVirtualDOMAttributes {

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
