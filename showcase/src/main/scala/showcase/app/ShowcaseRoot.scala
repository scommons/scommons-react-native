package showcase.app

import showcase.app.community._
import showcase.app.expo._
import scommons.react._
import scommons.react.navigation._
import scommons.react.navigation.tab.TabBarOptions._
import scommons.react.navigation.tab._
import scommons.reactnative._

import scala.scalajs.js

object ShowcaseRoot extends FunctionComponent[Unit] {

  private[app] lazy val Tab = createBottomTabNavigator()
  
  protected def render(props: Props): ReactElement = {
    <.NavigationContainer()(
      <(Tab.Navigator)(
        ^.initialRouteName := "Home",
        ^.tabLazy := false,
        ^.tabBarOptions := new TabBarOptions {
          //override val activeTintColor = "#e91e63"
          override val labelPosition = LabelPosition.`below-icon`
        }
      )(
        <(Tab.Screen)(
          ^.name := "Home",
          ^.component := ShowcaseScreen.homeStackComp,
          ^.options := new TabScreenOptions {
            override val tabBarIcon = { params =>
              <(ShowcaseIcons.FontAwesome5)(^.name := "home", ^.rnSize := params.size, ^.color := params.color)()
            }: js.Function1[TabBarIconParams, ReactElement]
          }
        )(),
        <(Tab.Screen)(
          ^.name := "react-native",
          ^.component := ReactNativeDemoScreen.reactNativeStackComp,
          ^.options := new TabScreenOptions {
            override val tabBarIcon = { params =>
              <(ShowcaseIcons.FontAwesome5)(^.name := "react", ^.rnSize := params.size, ^.color := params.color)()
            }: js.Function1[TabBarIconParams, ReactElement]
          }
        )(),
        <(Tab.Screen)(
          ^.name := "community",
          ^.component := CommunityDemoScreen.communityStackComp,
          ^.options := new TabScreenOptions {
            override val tabBarIcon = { params =>
              <(ShowcaseIcons.FontAwesome5)(^.name := "reacteurope", ^.rnSize := params.size, ^.color := params.color)()
            }: js.Function1[TabBarIconParams, ReactElement]
          }
        )(),
        <(Tab.Screen)(
          ^.name := "expo",
          ^.component := ExpoDemoScreen.expoStackComp,
          ^.options := new TabScreenOptions {
            override val tabBarIcon = { params =>
              <(ShowcaseIcons.Ionicons)(^.name := "ios-apps", ^.rnSize := params.size, ^.color := params.color)()
            }: js.Function1[TabBarIconParams, ReactElement]
          }
        )()
      )
    )
  }
}
