package showcase.app

import scommons.react._
import scommons.react.navigation._
import scommons.react.navigation.tab._

object ShowcaseRoot extends FunctionComponent[Unit] {

  private[app] lazy val Tab = createBottomTabNavigator()
  
  protected def render(props: Props): ReactElement = {
    <.NavigationContainer()(
      <(Tab.Navigator)(^.initialRouteName := "Home")(
        <(Tab.Screen)(^.name := "Home", ^.component := ShowcaseScreen.homeStackComp)(),
        <(Tab.Screen)(^.name := "react-native", ^.component := ReactNativeDemoScreen.reactNativeStackComp)()
      )
    )
  }
}
