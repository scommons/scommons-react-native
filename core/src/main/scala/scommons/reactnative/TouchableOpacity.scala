package scommons.reactnative

import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._

/** @see https://facebook.github.io/react-native/docs/touchableopacity
  */
object TouchableOpacity {

  trait TouchableOpacityAttributes {

    import TouchableOpacityAttributes._
    
    lazy val activeOpacity = NumberAttributeSpec("activeOpacity")
  }

  object TouchableOpacityAttributes {

    import VirtualDOMAttributes.Type._

    case class NumberAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: Double): Attribute[Double] = Attribute(name, value, AS_IS)
    }
  }

}
