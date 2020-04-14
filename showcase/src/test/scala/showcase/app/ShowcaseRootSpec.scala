package showcase.app

import showcase.app.ShowcaseRoot._
import scommons.expo.VectorIcons._
import scommons.react._
import scommons.react.navigation._
import scommons.react.navigation.tab.TabBarOptions._
import scommons.react.navigation.tab._
import scommons.react.test.TestSpec
import scommons.react.test.raw.ShallowInstance
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative._

import scala.scalajs.js.Dynamic.literal

class ShowcaseRootSpec extends TestSpec with ShallowRendererUtils {

  it should "render component" in {
    //given
    val component = <(ShowcaseRoot())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertShowcaseRoot(result)
  }

  private def assertShowcaseRoot(result: ShallowInstance): Unit = {
    
    def renderIcon(tab: ShallowInstance, size: Int, color: String): ShallowInstance = {
      val iconComp = tab.props.options.tabBarIcon(literal("size" -> size, "color" -> color))
      
      val wrapper = new FunctionComponent[Unit] {
        protected def render(props: Props): ReactElement = {
          iconComp.asInstanceOf[ReactElement]
        }
      }
      
      shallowRender(<(wrapper()).empty)
    }
    
    assertNativeComponent(result, <.NavigationContainer()(), { case List(navigator) =>
      assertNativeComponent(navigator,
        <(Tab.Navigator)(
          ^.initialRouteName := "Home",
          ^.tabLazy := false,
          ^.tabBarOptions := new TabBarOptions {
            override val labelPosition = LabelPosition.`below-icon`
          }
        )()
        , { case List(tab1, tab2) =>
          assertNativeComponent(tab1,
            <(Tab.Screen)(^.name := "Home", ^.component := ShowcaseScreen.homeStackComp)()
          )
          assertNativeComponent(renderIcon(tab1, 16, "green"),
            <(FontAwesome5)(^.name := "home", ^.rnSize := 16, ^.color := "green")()
          )
          
          assertNativeComponent(tab2,
            <(Tab.Screen)(^.name := "react-native", ^.component := ReactNativeDemoScreen.reactNativeStackComp)()
          )
          assertNativeComponent(renderIcon(tab2, 32, "red"),
            <(FontAwesome5)(^.name := "react", ^.rnSize := 32, ^.color := "red")()
          )
        })
    })
  }
}
