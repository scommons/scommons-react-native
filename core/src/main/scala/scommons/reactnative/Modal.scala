package scommons.reactnative

import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._

import scala.scalajs.js

/** @see https://facebook.github.io/react-native/docs/modal
  */
object Modal {

  trait ModalAttributes {

    import ModalAttributes._

    lazy val visible = BooleanAttributeSpec("visible")
    lazy val onRequestClose = Function0AttributeSpec("onRequestClose")
    lazy val onShow = Function0AttributeSpec("onShow")
    lazy val transparent = BooleanAttributeSpec("transparent")
    lazy val animationType = AnimationTypeAttributeSpec("animationType")
  }

  object ModalAttributes {

    import VirtualDOMAttributes.Type._

    case class Function0AttributeSpec(name: String) extends AttributeSpec {
      def :=(value: js.Function0[Unit]): Attribute[js.Function0[Unit]] = Attribute(name, value, AS_IS)
    }

    case class AnimationTypeAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: AnimationType): Attribute[AnimationType] = Attribute(name, value, AS_IS)
    }

  }

  trait AnimationType extends js.Object

  object AnimationType {
    /** default */
    val none: AnimationType = "none".asInstanceOf[AnimationType]
    val slide: AnimationType = "slide".asInstanceOf[AnimationType]
    val fade: AnimationType = "fade".asInstanceOf[AnimationType]
  }

}
