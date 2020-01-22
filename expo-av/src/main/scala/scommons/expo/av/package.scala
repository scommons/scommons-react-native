package scommons.expo

import io.github.shogowada.scalajs.reactjs.VirtualDOM.VirtualDOMElements.ReactClassElementSpec
import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._

package object av {
  
  type ExpoAVSource = raw.ExpoAVSource

  implicit class ExpoAVElements(elements: VirtualDOMElements) {
    lazy val Video: ReactClassElementSpec = elements(raw.ExpoVideo)
  }

  object ExpoAVAttributes {

    import VirtualDOMAttributes.Type._

    case class ExpoAVSourceAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: ExpoAVSource): Attribute[ExpoAVSource] = Attribute(name, value, AS_IS)
    }
  }

  implicit class ExpoAVAttributes(attributes: VirtualDOMAttributes) {

    import ExpoAVAttributes._

    lazy val expoAVSource = ExpoAVSourceAttributeSpec("source")
    lazy val shouldPlay = BooleanAttributeSpec("shouldPlay")
    lazy val useNativeControls = BooleanAttributeSpec("useNativeControls")
  }
}
