package scommons.reactnative

import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._

import scala.scalajs.js

/** @see https://reactnative.dev/docs/statusbar
  */
object StatusBar {

  trait StatusBarAttributes {

    import StatusBarAttributes._

    lazy val animated = BooleanAttributeSpec("animated")
    lazy val hidden = BooleanAttributeSpec("hidden")
    lazy val barStyle = BarStyleAttributeSpec("barStyle")
  }

  object StatusBarAttributes {

    import VirtualDOMAttributes.Type._

    case class BarStyleAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: BarStyle): Attribute[BarStyle] = Attribute(name, value, AS_IS)
    }

  }

  trait BarStyle extends js.Object

  object BarStyle {
    /** default */
    val default: BarStyle = "default".asInstanceOf[BarStyle]
    val `light-content`: BarStyle = "light-content".asInstanceOf[BarStyle]
    val `dark-content`: BarStyle = "dark-content".asInstanceOf[BarStyle]
  }

}
