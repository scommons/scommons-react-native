package showcase.app

import io.github.shogowada.scalajs.reactjs.redux.ReactRedux._
import io.github.shogowada.scalajs.reactjs.redux.Redux
import scommons.expo.{Asset, Font}
import scommons.react._
import scommons.react.hooks._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel(name = "ShowcaseApp")
class ShowcaseApp(onReady: js.Function0[Unit]) extends FunctionComponent[Unit] {

  @JSExport("apply")
  override def apply(): ReactClass = super.apply()

  private val store = Redux.createStore(ShowcaseStateReducer.reduce)
  
  protected def render(props: Props): ReactElement = {
    val (isReady, setIsReady) = useState(false)
    
    useEffect({ () =>
      preloadAssets { () =>
        setIsReady(true)
        onReady()
      }
    }, Nil)
    
    if (!isReady) <.>()() //Loading...
    else {
      <.Provider(^.store := store)(
        <.>()(
          <(ShowcaseRoot()).empty,
          <(ShowcaseTaskController()).empty
        )
      )
    }
  }

  /** @see https://docs.expo.io/guides/preloading-and-caching-assets/
    */
  private def preloadAssets(onFinish: () => Unit): Unit = {
    
    def cacheImages(): Future[js.Any] = {
      Asset.loadAsync(ShowcaseImages.imagesToPreload).recover {
        case _ => Console.err.println("Failed to cache images")
      }
    }
    
    def cacheFonts(): Future[js.Any] = {
      Font.loadAsync(ShowcaseFonts.fontsToPreload).recover {
        case _ => Console.err.println("Failed to cache fonts")
      }
    }
    
    def cacheIcons(): Future[js.Any] = {
      Font.loadAsync(ShowcaseIcons.iconsToPreload).recover {
        case _ => Console.err.println("Failed to cache icons")
      }
    }
    
    Future.sequence(Seq(
      cacheImages(),
      cacheFonts(),
      cacheIcons()
    )).andThen { case _ =>
      onFinish()
    }
  }
}
