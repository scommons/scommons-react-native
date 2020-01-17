package showcase.app

import showcase.PlatformDemo
import showcase.app.style._
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
        override val screen = TextStyleDemo()
      },
      "ProfileCard" -> new StackRouteConfig {
        override val screen = ProfileCard()
      }
    ),
    config = new StackNavigatorConfig {
      override val initialRouteName = "Showcase"
    }
  )
}
