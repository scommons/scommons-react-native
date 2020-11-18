package scommons.reactnative

import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._

import scala.scalajs.js

/** @see https://reactnative.dev/docs/switch
  */
object Switch {

  trait SwitchAttributes {

    import SwitchAttributes._

    lazy val thumbColor = StringAttributeSpec("thumbColor")
    lazy val trackColor = TrackColorAttributeSpec("trackColor")
    
    lazy val switchOnValueChange = OnValueChangeAttributeSpec("onValueChange")
    lazy val switchValue = BooleanAttributeSpec("value")
  }

  object SwitchAttributes {

    import VirtualDOMAttributes.Type._

    case class OnValueChangeAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: js.Function1[Boolean, Unit]): Attribute[js.Function1[Boolean, Unit]] =
        Attribute(name, value, AS_IS)
    }

    case class TrackColorAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: TrackColor): Attribute[TrackColor] = Attribute(name, value, AS_IS)
    }

  }

  trait TrackColor extends js.Object {
    
    val `false`: String
    val `true`: String
  }

}
