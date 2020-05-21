package scommons.reactnative

import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._

import scala.concurrent.Future
import scala.scalajs.js

/** @see https://reactnative.dev/docs/image
  * @see https://reactnative.dev/docs/images.html
  */
object Image {

  def prefetch(url: String): Future[js.Any] = {
    raw.Image.prefetch(url).toFuture
  }

  trait ImageAttributes {

    import ImageAttributes._

    lazy val source = ImageSourceAttributeSpec("source")
  }

  object ImageAttributes {

    import VirtualDOMAttributes.Type._

    case class ImageSourceAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: StaticResource): Attribute[StaticResource] = Attribute(name, value, AS_IS)
      def :=(value: UriResource): Attribute[UriResource] = Attribute(name, value, AS_IS)
    }

  }

}
