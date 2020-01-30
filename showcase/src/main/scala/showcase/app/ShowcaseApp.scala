package showcase.app

import showcase._
import showcase.app.style._
import showcase.app.video._
import scommons.react._
import scommons.react.navigation._
import scommons.react.navigation.stack._

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel(name = "ShowcaseApp")
object ShowcaseApp extends FunctionComponent[Unit] {

  @JSExport("apply")
  override def apply(): ReactClass = super.apply()

  protected def render(props: Props): ReactElement = {
    <(AppContainer)()()
  }
  
  private lazy val AppContainer = createAppContainer(AppNavigator)
  private lazy val AppNavigator = createStackNavigator(
    routes = Map(
      "Showcase" -> new StackRouteConfig {
        override val screen = ShowcaseController()
      },
      // components
      "ActivityIndicator" -> new StackRouteConfig {
        override val screen = ActivityIndicatorDemo()
      },
      "Button" -> new StackRouteConfig {
        override val screen = ButtonDemo()
      },
      "FlatList" -> new StackRouteConfig {
        override val screen = FlatListDemo()
      },
      "Modal" -> new StackRouteConfig {
        override val screen = ModalDemo()
      },
      //style
      "Styles" -> new StackRouteConfig {
        override val screen = StylesScreenController()
      },
      "BorderStyle" -> new StackRouteConfig {
        override val screen = BorderStyleDemo()
      },
      "BorderRadius" -> new StackRouteConfig {
        override val screen = BorderRadiusDemo()
      },
      "MarginStyle" -> new StackRouteConfig {
        override val screen = MarginStyleDemo()
      },
      "PaddingStyle" -> new StackRouteConfig {
        override val screen = PaddingStyleDemo()
      },
      "PositionStyle" -> new StackRouteConfig {
        override val screen = PositionStyleDemo()
      },
      "Platform" -> new StackRouteConfig {
        override val screen = PlatformDemo()
      },
      "TextStyle" -> new StackRouteConfig {
        override val screen = app.style.TextStyleDemo()
      },
      "ProfileCard" -> new StackRouteConfig {
        override val screen = ProfileCard()
      },
      // video
      "Video" -> new StackRouteConfig {
        override val screen = VideoDemo()
      }
    ),
    config = new StackNavigatorConfig {
      override val initialRouteName = "Showcase"
    }
  )
}
