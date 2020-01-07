package scommons.reactnative.showcase

import scommons.react._
import scommons.react.navigation.StackRouteConfig
import scommons.react.navigation.raw.{ReactNavigation, ReactNavigationStack}

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel(name = "ShowcaseApp")
object ShowcaseApp extends FunctionComponent[Unit] {

  @JSExport("apply")
  override def apply(): ReactClass = super.apply()

  private lazy val AppContainer = ReactNavigation.createAppContainer(
    ReactNavigationStack.createStackNavigator(routes)
  )
  
  protected def render(props: Props): ReactElement = {
    <(AppContainer)()()
  }
  
  private lazy val routes = new Routes
  private class Routes extends js.Object {
    val Root = new StackRouteConfig {
      override val screen = ShowcaseRoot()
    }
  }
}
