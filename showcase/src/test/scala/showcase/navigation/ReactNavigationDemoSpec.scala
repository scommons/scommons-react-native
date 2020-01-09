package showcase.navigation

import showcase.navigation.ReactNavigationDemoSpec._
import scommons.react._
import scommons.react.navigation.raw.{ReactNavigation => NativeReactNavigation}
import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportAll

class ReactNavigationDemoSpec extends TestSpec with ShallowRendererUtils {

  it should "call native createAppContainer when getAppContainer" in {
    //given
    val reactNavigationMock = mock[ReactNavigationMock]
    val nativeReactNavigation = NativeReactNavigation.asInstanceOf[js.Dynamic]
    val previous = nativeReactNavigation.createAppContainer
    nativeReactNavigation.createAppContainer = {
      reactNavigationMock.createAppContainer: js.Function1[ReactClass, ReactClass]
    }
    
    //then
    (reactNavigationMock.createAppContainer _).expects(ReactNavigationDemo.AppNavigator)

    //when
    ReactNavigationDemo.getAppContainer
    
    //cleanup
    nativeReactNavigation.createAppContainer = previous
  }
  
  it should "pass down AppNavigator routes and config to the mock component" in {
    //given
    val appContainer = ReactNavigationDemo.getAppContainer

    //when
    val result = shallowRender(<(appContainer)()())

    //then
    result.`type` shouldBe "View"
    result.props.routes.TestScreen.screen shouldBe ReactNavigationStackDemo.testScreen
    result.props.config.initialRouteName shouldBe "TestScreen"
  }
}

object ReactNavigationDemoSpec {

  @JSExportAll
  trait ReactNavigationMock {

    def createAppContainer(comp: ReactClass): ReactClass
  }
}
