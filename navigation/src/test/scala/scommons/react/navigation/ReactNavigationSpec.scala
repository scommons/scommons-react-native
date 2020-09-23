package scommons.react.navigation

import org.scalamock.scalatest.MockFactory
import org.scalatest._
import scommons.react.navigation.ReactNavigationSpec._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportAll

class ReactNavigationSpec extends FlatSpec
  with Matchers
  with Inside
  with MockFactory {
  
  private val route = js.Dynamic.literal(
    "name" -> "test"
  ).asInstanceOf[raw.Route]
  
  it should "return None if native returns null when getFocusedRouteNameFromRoute" in {
    //given
    val nativeMock = mock[ReactNavigationMock]
    val nav = TestReactNavigation(nativeMock.asInstanceOf[raw.ReactNavigation])

    (nativeMock.getFocusedRouteNameFromRoute _).expects(route).returning(null)
    
    //when & then
    nav.getFocusedRouteNameFromRoute(route) shouldBe None
  }
  
  it should "return None if native returns undefined when getFocusedRouteNameFromRoute" in {
    //given
    val nativeMock = mock[ReactNavigationMock]
    val nav = TestReactNavigation(nativeMock.asInstanceOf[raw.ReactNavigation])

    (nativeMock.getFocusedRouteNameFromRoute _).expects(route).returning(js.undefined)
    
    //when & then
    nav.getFocusedRouteNameFromRoute(route) shouldBe None
  }
  
  it should "return Some if native returns string when getFocusedRouteNameFromRoute" in {
    //given
    val nativeMock = mock[ReactNavigationMock]
    val nav = TestReactNavigation(nativeMock.asInstanceOf[raw.ReactNavigation])
    val routeName = "some RouteName"

    (nativeMock.getFocusedRouteNameFromRoute _).expects(route).returning(routeName)
    
    //when & then
    nav.getFocusedRouteNameFromRoute(route) shouldBe Some(routeName)
  }
  
  it should "return false if native returns false when useIsFocused" in {
    //given
    val nativeMock = mock[ReactNavigationMock]
    val nav = TestReactNavigation(nativeMock.asInstanceOf[raw.ReactNavigation])
    val result = false

    (nativeMock.useIsFocused _).expects().returning(result)
    
    //when & then
    nav.useIsFocused() shouldBe result
  }
  
  it should "return true if native returns true when useIsFocused" in {
    //given
    val nativeMock = mock[ReactNavigationMock]
    val nav = TestReactNavigation(nativeMock.asInstanceOf[raw.ReactNavigation])
    val result = true

    (nativeMock.useIsFocused _).expects().returning(result)
    
    //when & then
    nav.useIsFocused() shouldBe result
  }
}

object ReactNavigationSpec {

  @JSExportAll
  trait ReactNavigationMock {

    def getFocusedRouteNameFromRoute(route: raw.Route): js.Any

    def useIsFocused(): Boolean
  }

  case class TestReactNavigation(mock: raw.ReactNavigation) extends ReactNavigation {
    protected def native: raw.ReactNavigation = mock
  }
}
