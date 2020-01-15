package scommons.react.navigation

import io.github.shogowada.scalajs.reactjs.React.Props
import org.scalamock.scalatest.MockFactory
import org.scalatest.{FlatSpec, Inside, Matchers}
import scommons.react.navigation.NavigationSpec._

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
    val native = mock[NavigationMock]
    val state = mock[NavigationStateMock]
    val nav = Navigation(Props(js.Dynamic.literal(
      "navigation" -> native.asInstanceOf[raw.Navigation]
    )))
    val params = TestParams("TestParams")

    //then
    (native.state _).expects().returning(state.asInstanceOf[raw.NavigationState])
    (state.params _).expects().returning(params.asInstanceOf[js.Any])

    //when
    val result = nav.getParams[TestParams]
    
    //then
    result shouldBe params
  }
}

object NavigationSpec {
  
  case class TestParams(name: String)

  @JSExportAll
  trait NavigationMock {

    def navigate(routeName: String): Unit
    def navigate(routeName: String, params: js.Any): Unit

    def goBack(): Unit

    def state: raw.NavigationState
  }

  @JSExportAll
  trait NavigationStateMock {

    def params: js.Any
  }
}
