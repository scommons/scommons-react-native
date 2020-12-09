package scommons.reactnative

import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._

import scala.scalajs.js

/** @see https://reactnative.dev/docs/keyboardavoidingview
  */
object KeyboardAvoidingView {

  trait KeyboardAvoidingViewAttributes {

    import KeyboardAvoidingViewAttributes._

    lazy val behavior = BehaviorAttributeSpec("behavior")
  }

  object KeyboardAvoidingViewAttributes {

    import VirtualDOMAttributes.Type._

    case class BehaviorAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: Behavior): Attribute[Behavior] = Attribute(name, value, AS_IS)
    }

  }

  trait Behavior extends js.Object

  object Behavior {
    val height: Behavior = "height".asInstanceOf[Behavior]
    val position: Behavior = "position".asInstanceOf[Behavior]
    val padding: Behavior = "padding".asInstanceOf[Behavior]
  }

}
