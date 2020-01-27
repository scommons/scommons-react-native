package scommons.reactnative

import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._

import scala.scalajs.js

/** @see https://facebook.github.io/react-native/docs/activityindicator
  */
object ActivityIndicator {

  trait ActivityIndicatorAttributes {

    import ActivityIndicatorAttributes._

    lazy val animating = BooleanAttributeSpec("animating")
    lazy val color = StringAttributeSpec("color")
    lazy val aiSize = ActivityIndicatorSizeAttributeSpec("size")
  }

  object ActivityIndicatorAttributes {

    import VirtualDOMAttributes.Type._

    case class ActivityIndicatorSizeAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: ActivityIndicatorSize): Attribute[ActivityIndicatorSize] = Attribute(name, value, AS_IS)
    }

  }

  trait ActivityIndicatorSize extends js.Object

  object ActivityIndicatorSize {
    /** default */
    val small: ActivityIndicatorSize = "small".asInstanceOf[ActivityIndicatorSize]
    val large: ActivityIndicatorSize = "large".asInstanceOf[ActivityIndicatorSize]
  }

}
