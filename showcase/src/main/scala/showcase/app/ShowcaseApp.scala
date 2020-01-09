package showcase.app

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
        override val screen = ShowcaseRoot()
      }
    ),
    config = new StackNavigatorConfig {
      override val initialRouteName = "Showcase"
    }
  )
}
