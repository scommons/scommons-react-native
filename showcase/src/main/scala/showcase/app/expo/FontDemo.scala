package showcase.app.expo

import showcase.app.ShowcaseFonts.MontserratBlack
import scommons.expo.Font
import scommons.react._
import scommons.react.hooks._
import scommons.reactnative._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js

/** @see https://docs.expo.io/versions/latest/sdk/font/
  * @see https://docs.expo.io/versions/latest/guides/preloading-and-caching-assets/
  */
object FontDemo extends FunctionComponent[Unit] {

  protected def render(props: Props): ReactElement = {
    val (maybeFont, setFont) = useState(Option.empty[String])
    
    useEffect(() => {
      // preload font
      Font.loadAsync(Seq(MontserratBlack.name -> MontserratBlack.Resource)).map { _ =>
        setFont(Some(MontserratBlack.name))
      }
      ()
    }, Nil)
    
    <.View(^.rnStyle := styles.container)(
      maybeFont.map { font =>
        <.Text(^.rnStyle := new TextStyle {
          override val fontFamily = font
        })(
          s"Font: $font"
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
