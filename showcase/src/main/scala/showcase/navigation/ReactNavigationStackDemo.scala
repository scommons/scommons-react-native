package showcase.navigation

import scommons.react._
import scommons.react.navigation.stack._

object ReactNavigationStackDemo {

  def getAppNavigator: ReactClass = createStackNavigator(
    routes = Map(
      "TestScreen" -> new StackRouteConfig {
        override val screen = testScreen
      }
    ),
    config = new StackNavigatorConfig {
      override val initialRouteName = "TestScreen"
    }
  )

  lazy val testScreen = new FunctionComponent[Unit] {
    override protected def render(props: Props): ReactElement = {
      <.>()("Test")
    }
  }.apply()
}
