package scommons.reactnative

import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._

object Image {

  trait ImageAttributes {

    import ImageAttributes._

    lazy val source = ImageSourceAttributeSpec("source")
  }

  object ImageAttributes {

    import VirtualDOMAttributes.Type._

    case class ImageSourceAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: ImageSource): Attribute[ImageSource] = Attribute(name, value, AS_IS)
    }

  }

}
