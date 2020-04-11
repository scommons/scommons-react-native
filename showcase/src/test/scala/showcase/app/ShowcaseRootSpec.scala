package showcase.app

import scommons.react.navigation._
import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import showcase.app.ShowcaseRoot._

class ShowcaseRootSpec extends TestSpec with ShallowRendererUtils {

  it should "render component" in {
    //given
    val component = <(ShowcaseRoot())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <.NavigationContainer()(
        <(Tab.Navigator)(^.initialRouteName := "Home")(
          <(Tab.Screen)(^.name := "Home", ^.component := ShowcaseScreen.homeStackComp)(),
          <(Tab.Screen)(^.name := "react-native", ^.component := ReactNativeDemoScreen.reactNativeStackComp)()
        )
      )
    )
  }
}
