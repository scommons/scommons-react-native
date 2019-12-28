package scommons.reactnative

import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._

import scala.scalajs.js

object Touchable {

  trait TouchableAttributes {

    import TouchableAttributes._

    lazy val onPress = OnPressEventAttribute("onPress")
  }

  object TouchableAttributes {

    import VirtualDOMAttributes.Type._

    type OnPressEvent = js.Function0[Unit]
    
    case class OnPressEventAttribute(name: String) extends AttributeSpec {
      def :=(onEvent: OnPressEvent): Attribute[OnPressEvent] = Attribute(name, onEvent, AS_IS)
    }
  }

}
