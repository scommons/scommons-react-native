package showcase

import showcase.app.ShowcaseImages
import scommons.expo.Asset
import scommons.react._
import scommons.react.hooks._
import scommons.reactnative._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.scalajs.js

/** @see https://reactnative.dev/docs/image
  * @see https://reactnative.dev/docs/images.html
  */
object ImageDemo extends FunctionComponent[Unit] {

  protected def render(compProps: Props): ReactElement = {
    val (imagesReady, setImagesReady) = useState(false)
    val networkImageUrl = "https://reactjs.org/logo-og.png"

    useEffect(() => {
      // preload images - usually done at the start of app, see ShowcaseApp
      Future.sequence(List(
        Asset.loadAsync(ShowcaseImages.Expo.Resource),
        Image.prefetch(networkImageUrl)
      )).map { _ =>
        setImagesReady(true)
      }
      ()
    }, Nil)

    <.View(^.rnStyle := styles.container)(
      if (imagesReady) Some(
        <.>()(
          // static image source
          <.Image(
            ^.source := ShowcaseImages.Expo.Resource,
            ^.rnStyle := new Style {
              override val width = ShowcaseImages.Expo.asset.width
              override val height = ShowcaseImages.Expo.asset.height
            }
          )(),

          // uri image source
          <.Image(
            ^.source := new UriResource {
              override val uri = networkImageUrl
            },
            ^.rnStyle := new Style {
              override val width = 400
              override val height = 400
            }
          )()
        )
      ) else None
    )
  }

  private[showcase] lazy val styles = StyleSheet.create(new Styles)
  private[showcase] class Styles extends js.Object {
    import ViewStyle._
    
    val container: Style = new ViewStyle {
      override val flex = 1
      override val justifyContent = JustifyContent.center
      override val alignItems = AlignItems.center
      override val alignContent = AlignContent.`space-between`
    }
  }
}
