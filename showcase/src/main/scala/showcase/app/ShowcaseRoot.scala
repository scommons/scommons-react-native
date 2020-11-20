package showcase.app

import showcase.app.community._
import showcase.app.expo._
import scommons.react._
import scommons.react.navigation._
import scommons.react.navigation.stack._
import scommons.react.navigation.tab.TabBarOptions._
import scommons.react.navigation.tab._
import scommons.reactnative._
import scommons.reactnative.safearea._

import scala.scalajs.js

case class ShowcaseRootProps(darkTheme: Boolean)

object ShowcaseRoot extends FunctionComponent[ShowcaseRootProps] {

  protected def render(compProps: Props): ReactElement = {
    val props = compProps.wrapped

    def getScreenTitle(navProps: NavigationProps): String = {
      val routeName = getFocusedRouteNameFromRoute(navProps.route)
        .getOrElse(navProps.route.name)
      
      routeName match {
        case "App" => "Showcase"
        case "Home" => "Showcase"
        case _ => routeName
      }
    }

    <.>()(
      <.StatusBar(^.barStyle := {
        if (props.darkTheme) StatusBar.BarStyle.`light-content`
        else StatusBar.BarStyle.`dark-content`
      })(),
      
      <.SafeAreaProvider()(
        <.NavigationContainer(^.theme := {
          if (props.darkTheme) DarkTheme
          else DefaultTheme
        })(
          <(AppStack.Navigator)(
            ^.screenOptions := { navProps =>
              val screenTitle = getScreenTitle(navProps)
              val options = new StackScreenOptions {
                val headerBackTitleVisible = false
                override val title = screenTitle
              }
              options
            }
          )(
            <(AppStack.Screen)(^.name := "App", ^.component := homeTabComp)(),
            
            ShowcaseScreen.getHomeScreens(AppStack),
            ReactNativeDemoScreen.getReactNativeScreens(AppStack),
            CommunityDemoScreen.getCommunityScreens(AppStack),
            ExpoDemoScreen.getExpoScreens(AppStack)
          )
        )
      )
    )
  }

  private[app] lazy val AppStack = createStackNavigator()
  
  private[app] lazy val HomeTab = createBottomTabNavigator()
  private[app] lazy val homeTabComp: ReactClass = new FunctionComponent[Unit] {
    protected def render(props: Props): ReactElement = {
      <(HomeTab.Navigator)(
        ^.initialRouteName := "Home",
        ^.tabLazy := false,
        ^.tabBarOptions := new TabBarOptions {
          //override val activeTintColor = "#e91e63"
          override val labelPosition = LabelPosition.`below-icon`
        }
      )(
        <(HomeTab.Screen)(
          ^.name := "Home",
          ^.component := ShowcaseController(),
          ^.options := new TabScreenOptions {
            override val tabBarIcon = { params =>
              <(ShowcaseIcons.FontAwesome5)(^.name := "home", ^.rnSize := params.size, ^.color := params.color)()
            }: js.Function1[TabBarIconParams, ReactElement]
          }
        )(),
        <(HomeTab.Screen)(
          ^.name := "react-native",
          ^.component := ReactNativeDemoController(),
          ^.options := new TabScreenOptions {
            override val tabBarIcon = { params =>
              <(ShowcaseIcons.FontAwesome5)(^.name := "react", ^.rnSize := params.size, ^.color := params.color)()
            }: js.Function1[TabBarIconParams, ReactElement]
          }
        )(),
        <(HomeTab.Screen)(
          ^.name := "community",
          ^.component := CommunityDemoController(),
          ^.options := new TabScreenOptions {
            override val tabBarIcon = { params =>
              <(ShowcaseIcons.FontAwesome5)(^.name := "reacteurope", ^.rnSize := params.size, ^.color := params.color)()
            }: js.Function1[TabBarIconParams, ReactElement]
          }
        )(),
        <(HomeTab.Screen)(
          ^.name := "expo",
          ^.component := ExpoDemoController(),
          ^.options := new TabScreenOptions {
            override val tabBarIcon = { params =>
              <(ShowcaseIcons.Ionicons)(^.name := "ios-apps", ^.rnSize := params.size, ^.color := params.color)()
            }: js.Function1[TabBarIconParams, ReactElement]
          }
        )()
      )
    }
  }.apply()
}
