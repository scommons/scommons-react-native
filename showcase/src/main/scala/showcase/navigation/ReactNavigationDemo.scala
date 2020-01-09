package showcase.navigation

import scommons.react._
import scommons.react.navigation._

object ReactNavigationDemo {

  def getAppContainer: ReactClass = createAppContainer(AppNavigator)

  lazy val AppNavigator: ReactClass = ReactNavigationStackDemo.getAppNavigator
}
