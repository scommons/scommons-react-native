package showcase.app.expo

import showcase.app.ShowcaseImages
import scommons.expo.Asset
import scommons.react._
import scommons.react.hooks._
import scommons.reactnative._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js

/** @see https://docs.expo.io/versions/latest/sdk/asset/
  * @see https://docs.expo.io/versions/latest/guides/preloading-and-caching-assets/
  */
object AssetDemo extends FunctionComponent[Unit] {

  protected def render(props: Props): ReactElement = {
    val (maybeAsset, setAsset) = useState(Option.empty[Asset])
    
    useEffect(() => {
      // preload image
      Asset.loadAsync(Seq(ShowcaseImages.Expo)).map { _ =>
        val asset = Asset.fromModule(ShowcaseImages.Expo)
        setAsset(Some(asset))
      }
      ()
    }, Nil)
    
    <.View(^.rnStyle := styles.container)(
      <.Image(^.source := ShowcaseImages.Expo)(),

      maybeAsset.map { asset =>
        <.>()(
          <.Text()("Asset props:"),
          <.Text()(s"name: ${asset.name}"),
          <.Text()(s"type: ${asset.`type`}"),
          //<.Text()(s"hash: ${asset.hash}"),
          //<.Text()(s"uri: ${asset.uri}"),
          //<.Text()(s"localUri: ${asset.localUri}"),
          <.Text()(s"width: ${asset.width}"),
          <.Text()(s"height: ${asset.height}")
        )
      }
    )
  }

  private[expo] lazy val styles = StyleSheet.create(new Styles)
  private[expo] class Styles extends js.Object {
    import ViewStyle._

    val container: Style = new ViewStyle {
      override val flex = 1
      override val justifyContent = JustifyContent.center
      override val alignItems = AlignItems.center
    }
  }
}
