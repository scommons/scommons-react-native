package showcase.app

import showcase.app.style.StylesScreen
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
        override val screen = ShowcaseScreen()
      },
      "Styles" -> new StackRouteConfig {
        override val screen = StylesScreen()
      }
    ),
    config = new StackNavigatorConfig {
      override val initialRouteName = "Showcase"
    }
  )
}
