package showcase

import showcase.app.ShowcaseImages
import scommons.expo.Asset
import scommons.react._
import scommons.react.hooks._
import scommons.reactnative._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js

/** @see https://reactnative.dev/docs/image
  * @see https://reactnative.dev/docs/images.html
  */
object ImageDemo extends FunctionComponent[Unit] {

  protected def render(compProps: Props): ReactElement = {
    val (maybeAsset, setAsset) = useState(Option.empty[Asset])

    useEffect(() => {
      // preload image
      Asset.loadAsync(ShowcaseImages.Expo).map { _ =>
        val asset = Asset.fromModule(ShowcaseImages.Expo)
        setAsset(Some(asset))
      }
      ()
    }, Nil)

    <.View(^.rnStyle := styles.container)(
      // static image source
      <.Image(^.source := ShowcaseImages.User)(),

      maybeAsset.map { asset =>
        // uri image source
        <.Image(
          ^.rnStyle := new Style {
            override val width = asset.width
            override val height = asset.height
          },
          ^.source := new UriResource {
            override val uri = asset.uri
          }
        )()
      }
    )
  }

  private[showcase] lazy val styles = StyleSheet.create(new Styles)
  private[showcase] class Styles extends js.Object {
    import ViewStyle._
    
    val container: Style = new ViewStyle {
      override val flex = 1
      override val justifyContent = JustifyContent.center
      override val alignItems = AlignItems.center
    }
  }
}
