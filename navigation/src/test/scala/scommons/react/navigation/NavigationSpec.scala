package scommons.react.navigation

import io.github.shogowada.scalajs.reactjs.React.Props
import org.scalamock.scalatest.MockFactory
import org.scalatest.{FlatSpec, Inside, Matchers}
import scommons.react.navigation.NavigationSpec._
import scommons.react.navigation.stack.raw.ScreenOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportAll

class NavigationSpec extends FlatSpec
  with Matchers
  with Inside
  with MockFactory {

  it should "navigate to route when navigate" in {
    //given
    val native = mock[NavigationMock]
    val nav = Navigation(Props(js.Dynamic.literal(
      "navigation" -> native.asInstanceOf[raw.Navigation]
    )))
    val routeName = "TestRoute"

    //then
    (native.navigate(_: String)).expects(routeName)

    //when
    nav.navigate(routeName)
  }
  
  it should "navigate to route and pass params when navigate" in {
    //given
    val native = mock[NavigationMock]
    val nav = Navigation(Props(js.Dynamic.literal(
      "navigation" -> native.asInstanceOf[raw.Navigation]
    )))
    val routeName = "TestRoute"
    val params = TestParams("TestParams")

    //then
    (native.navigate(_: String, _: js.Any)).expects(routeName, params.asInstanceOf[js.Any])

    //when
    nav.navigate(routeName, params)
  }

  it should "call goBack when goBack" in {
    //given
    val native = mock[NavigationMock]
    val nav = Navigation(Props(js.Dynamic.literal(
      "navigation" -> native.asInstanceOf[raw.Navigation]
    )))

    //then
    (native.goBack _).expects()

    //when
    nav.goBack()
  }
  
  it should "return params when getParams" in {
    //given
    val route = mock[RouteMock]
    val nav = Navigation(Props(js.Dynamic.literal(
      "route" -> route.asInstanceOf[raw.Route]
    )))
    val params = TestParams("TestParams")

    //then
    (route.params _).expects().returning(params.asInstanceOf[js.Any])

    //when
    val result = nav.getParams[TestParams]
    
    //then
    result shouldBe params
  }

  it should "set params when setParams" in {
    //given
    val navigation = mock[NavigationMock]
    val nav = Navigation(Props(js.Dynamic.literal(
      "navigation" -> navigation.asInstanceOf[raw.Navigation]
    )))
    val params = TestParams("TestParams")

    //then
    (navigation.setParams _).expects(params.asInstanceOf[js.Any])

    //when
    nav.setParams(params)
  }

  it should "set options when setOptions" in {
    //given
    val navigation = mock[NavigationMock]
    val nav = Navigation(Props(js.Dynamic.literal(
      "navigation" -> navigation.asInstanceOf[raw.Navigation]
    )))
    val options = new ScreenOptions {
      override val title = "test"
    }

    //then
    (navigation.setOptions _).expects(options)

    //when
    nav.setOptions(options)
  }
}

object NavigationSpec {
  
  case class TestParams(name: String)

  @JSExportAll
  trait NavigationMock {

    def navigate(name: String): Unit
    def navigate(name: String, params: js.Any): Unit

    def goBack(): Unit

    def setParams(params: js.Any): Unit
    def setOptions(options: js.Object): Unit
  }

  @JSExportAll
  trait RouteMock {

    def params: js.Any
  }
}
