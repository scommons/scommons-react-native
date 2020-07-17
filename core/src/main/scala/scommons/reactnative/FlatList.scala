package scommons.reactnative

import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._
import scommons.react._

import scala.scalajs.js

/** @see https://facebook.github.io/react-native/docs/flatlist
  */
object FlatList {

  trait FlatListAttributes {

    import FlatListAttributes._

    lazy val renderItem = RenderItemAttributeSpec("renderItem")
    lazy val flatListData = DataAttributeSpec("data")
    lazy val keyExtractor = KeyExtractorAttributeSpec("keyExtractor")
    lazy val extraData = ExtraDataAttributeSpec("extraData")
    lazy val onRefresh = OnRefreshAttributeSpec("onRefresh")
    lazy val refreshing = BooleanAttributeSpec("refreshing")
  }

  object FlatListAttributes {

    import VirtualDOMAttributes.Type._

    case class RenderItemAttributeSpec(name: String) extends AttributeSpec {
      private type RenderItem[T] = js.Function1[FlatListData[T], ReactElement]
      
      def :=[T](value: RenderItem[T]): Attribute[RenderItem[T]] = Attribute(name, value, AS_IS)
    }

    case class KeyExtractorAttributeSpec(name: String) extends AttributeSpec {
      private type KeyExtractor1[T] = js.Function1[T, String]
      private type KeyExtractor2[T] = js.Function2[T, Int, String]
      
      def :=[T](value: KeyExtractor1[T]): Attribute[KeyExtractor1[T]] = Attribute(name, value, AS_IS)
      def :=[T](value: KeyExtractor2[T]): Attribute[KeyExtractor2[T]] = Attribute(name, value, AS_IS)
    }

    case class DataAttributeSpec(name: String) extends AttributeSpec {
      def :=[T](value: js.Array[T]): Attribute[js.Array[T]] = Attribute(name, value, AS_IS)
    }

    case class ExtraDataAttributeSpec(name: String) extends AttributeSpec {
      def :=[T](value: T): Attribute[T] = Attribute(name, value, AS_IS)
    }

    case class OnRefreshAttributeSpec(name: String) extends AttributeSpec {
      def :=(onRefresh: js.Function0[Unit]): Attribute[js.Function0[Unit]] = Attribute(name, onRefresh, AS_IS)
    }
  }

  @js.native
  trait FlatListData[T] extends js.Object {
    def item: T = js.native
    def index: Int = js.native
  }

}
