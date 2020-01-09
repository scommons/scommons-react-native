package showcase.navigation

import showcase.navigation.ReactNavigationStackDemoSpec._
import scommons.react._
import scommons.react.navigation.stack._
import scommons.react.navigation.stack.raw.{ReactNavigationStack => NativeReactNavigationStack}
import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportAll

class ReactNavigationStackDemoSpec extends TestSpec with ShallowRendererUtils {

  it should "call native createStackNavigator when getAppNavigator" in {
    //given
    val reactNavigationStackMock = mock[ReactNavigationStackMock]
    val nativeReactNavigationStack = NativeReactNavigationStack.asInstanceOf[js.Dynamic]
    val previous = nativeReactNavigationStack.createStackNavigator
    nativeReactNavigationStack.createStackNavigator = {
      reactNavigationStackMock.createStackNavigator:
        js.Function2[js.Dictionary[StackRouteConfig], StackNavigatorConfig, ReactClass]
    }
    var capturedRoutes: js.Dictionary[StackRouteConfig] = null
    var capturedConfig: StackNavigatorConfig = null
    
    //then
    (reactNavigationStackMock.createStackNavigator _).expects(*, *).onCall { (routes, config) =>
      capturedRoutes = routes
      capturedConfig = config
      
      ReactNavigationStackDemo.testScreen
    }

    //when
    ReactNavigationStackDemo.getAppNavigator
    
    //then
    val screenConfig = capturedRoutes("TestScreen")
    screenConfig.screen shouldBe ReactNavigationStackDemo.testScreen
    
    capturedConfig.initialRouteName shouldBe "TestScreen"
    
    //cleanup
    nativeReactNavigationStack.createStackNavigator = previous
  }
  
  it should "render testScreen component" in {
    //given
    val component = <(ReactNavigationStackDemo.testScreen)()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result, <.>()("Test"))
  }
}

object ReactNavigationStackDemoSpec {

  @JSExportAll
  trait ReactNavigationStackMock {

    def createStackNavigator(routes: js.Dictionary[StackRouteConfig],
                             config: StackNavigatorConfig): ReactClass
  }
}
