package showcase.app

import showcase.app.ShowcaseRoot._
import showcase.app.community._
import showcase.app.expo._
import scommons.react._
import scommons.react.navigation._
import scommons.react.navigation.tab.TabBarOptions._
import scommons.react.navigation.tab._
import scommons.react.test._
import scommons.reactnative._

import scala.scalajs.js
import scala.scalajs.js.Dynamic.literal

class ShowcaseRootSpec extends TestSpec with ShallowRendererUtils {

  it should "render dynamic App screens titles" in {
    //given
    val comp = shallowRender(<(ShowcaseRoot())()())
    val List(appStackNav) = findComponents(comp, AppStack.Navigator)

    def navProps(route: String): js.Dynamic = {
      js.Dynamic.literal(
        "navigation" -> js.Dynamic.literal(),
        "route" -> js.Dynamic.literal(
          "name" -> route
        )
      )
    }
    
    //when & then
    inside(appStackNav.props.screenOptions(navProps("App"))) { case opts =>
      opts.headerBackTitleVisible shouldBe false
      opts.title shouldBe "Showcase"
    }
    
    //when & then
    inside(appStackNav.props.screenOptions(navProps("Home"))) { case opts =>
      opts.headerBackTitleVisible shouldBe false
      opts.title shouldBe "Showcase"
    }
    
    //when & then
    inside(appStackNav.props.screenOptions(navProps("Other"))) { case opts =>
      opts.headerBackTitleVisible shouldBe false
      opts.title shouldBe "Other"
    }
  }

  it should "render App stack component" in {
    //given
    val component = <(ShowcaseRoot())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result, <.NavigationContainer()(
      <(AppStack.Navigator)()(
        <(AppStack.Screen)(^.name := "App", ^.component := homeTabComp)(),
        
        ShowcaseScreen.getHomeScreens(AppStack),
        ReactNativeDemoScreen.getReactNativeScreens(AppStack),
        CommunityDemoScreen.getCommunityScreens(AppStack),
        ExpoDemoScreen.getExpoScreens(AppStack)
      )
    ))
  }

  it should "render Home tab component" in {
    //given
    val component = <(homeTabComp)()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <(HomeTab.Navigator)(
        ^.initialRouteName := "Home",
        ^.tabLazy := false,
        ^.tabBarOptions := new TabBarOptions {
          override val labelPosition = LabelPosition.`below-icon`
        }
      )(), { case List(tab1, tab2, tab3, tab4) =>
        assertNativeComponent(tab1,
          <(HomeTab.Screen)(^.name := "Home", ^.component := ShowcaseController())()
        )
        assertNativeComponent(renderIcon(tab1, 16, "green"),
          <(ShowcaseIcons.FontAwesome5)(^.name := "home", ^.rnSize := 16, ^.color := "green")()
        )
        
        assertNativeComponent(tab2,
          <(HomeTab.Screen)(^.name := "react-native", ^.component := ReactNativeDemoController())()
        )
        assertNativeComponent(renderIcon(tab2, 32, "red"),
          <(ShowcaseIcons.FontAwesome5)(^.name := "react", ^.rnSize := 32, ^.color := "red")()
        )
        
        assertNativeComponent(tab3,
          <(HomeTab.Screen)(^.name := "community", ^.component := CommunityDemoController())()
        )
        assertNativeComponent(renderIcon(tab3, 48, "blue"),
          <(ShowcaseIcons.FontAwesome5)(^.name := "reacteurope", ^.rnSize := 48, ^.color := "blue")()
        )
        
        assertNativeComponent(tab4,
          <(HomeTab.Screen)(^.name := "expo", ^.component := ExpoDemoController())()
        )
        assertNativeComponent(renderIcon(tab4, 64, "white"),
          <(ShowcaseIcons.Ionicons)(^.name := "ios-apps", ^.rnSize := 64, ^.color := "white")()
        )
      }
    )
  }

  private def renderIcon(tab: ShallowInstance, size: Int, color: String): ShallowInstance = {
    val iconComp = tab.props.options.tabBarIcon(literal("size" -> size, "color" -> color))

    val wrapper = new FunctionComponent[Unit] {
      protected def render(props: Props): ReactElement = {
        iconComp.asInstanceOf[ReactElement]
      }
    }

    shallowRender(<(wrapper()).empty)
  }
}
