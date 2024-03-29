package scommons.react.navigation

import org.scalamock.scalatest.MockFactory
import org.scalatest._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import scommons.react.navigation.ReactNavigationSpec._
import scommons.reactnative.Style

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportAll

class ReactNavigationSpec extends AnyFlatSpec
  with Matchers
  with Inside
  with MockFactory {
  
  private val route = js.Dynamic.literal(
    "name" -> "test"
  ).asInstanceOf[raw.Route]
  
  it should "return None if native returns null when getFocusedRouteNameFromRoute" in {
    //given
    val getFocusedRouteNameFromRouteMock = mockFunction[raw.Route, js.Any]
    val useIsFocusedMock = mockFunction[Boolean]
    val useThemeMock = mockFunction[Theme]
    val nativeMock = new ReactNavigationMock(getFocusedRouteNameFromRouteMock, useIsFocusedMock, useThemeMock)
    val nav = TestReactNavigation(nativeMock.asInstanceOf[raw.ReactNavigation])

    getFocusedRouteNameFromRouteMock.expects(route).returning(null)
    
    //when & then
    nav.getFocusedRouteNameFromRoute(route) shouldBe None
  }
  
  it should "return None if native returns undefined when getFocusedRouteNameFromRoute" in {
    //given
    val getFocusedRouteNameFromRouteMock = mockFunction[raw.Route, js.Any]
    val useIsFocusedMock = mockFunction[Boolean]
    val useThemeMock = mockFunction[Theme]
    val nativeMock = new ReactNavigationMock(getFocusedRouteNameFromRouteMock, useIsFocusedMock, useThemeMock)
    val nav = TestReactNavigation(nativeMock.asInstanceOf[raw.ReactNavigation])

    getFocusedRouteNameFromRouteMock.expects(route).returning(js.undefined)
    
    //when & then
    nav.getFocusedRouteNameFromRoute(route) shouldBe None
  }
  
  it should "return Some if native returns string when getFocusedRouteNameFromRoute" in {
    //given
    val getFocusedRouteNameFromRouteMock = mockFunction[raw.Route, js.Any]
    val useIsFocusedMock = mockFunction[Boolean]
    val useThemeMock = mockFunction[Theme]
    val nativeMock = new ReactNavigationMock(getFocusedRouteNameFromRouteMock, useIsFocusedMock, useThemeMock)
    val nav = TestReactNavigation(nativeMock.asInstanceOf[raw.ReactNavigation])
    val routeName = "some RouteName"

    getFocusedRouteNameFromRouteMock.expects(route).returning(routeName)
    
    //when & then
    nav.getFocusedRouteNameFromRoute(route) shouldBe Some(routeName)
  }
  
  it should "return false if native returns false when useIsFocused" in {
    //given
    val getFocusedRouteNameFromRouteMock = mockFunction[raw.Route, js.Any]
    val useIsFocusedMock = mockFunction[Boolean]
    val useThemeMock = mockFunction[Theme]
    val nativeMock = new ReactNavigationMock(getFocusedRouteNameFromRouteMock, useIsFocusedMock, useThemeMock)
    val nav = TestReactNavigation(nativeMock.asInstanceOf[raw.ReactNavigation])
    val result = false

    useIsFocusedMock.expects().returning(result)
    
    //when & then
    nav.useIsFocused() shouldBe result
  }
  
  it should "return true if native returns true when useIsFocused" in {
    //given
    val getFocusedRouteNameFromRouteMock = mockFunction[raw.Route, js.Any]
    val useIsFocusedMock = mockFunction[Boolean]
    val useThemeMock = mockFunction[Theme]
    val nativeMock = new ReactNavigationMock(getFocusedRouteNameFromRouteMock, useIsFocusedMock, useThemeMock)
    val nav = TestReactNavigation(nativeMock.asInstanceOf[raw.ReactNavigation])
    val result = true

    useIsFocusedMock.expects().returning(result)
    
    //when & then
    nav.useIsFocused() shouldBe result
  }

  it should "return native theme when useTheme" in {
    //given
    val getFocusedRouteNameFromRouteMock = mockFunction[raw.Route, js.Any]
    val useIsFocusedMock = mockFunction[Boolean]
    val useThemeMock = mockFunction[Theme]
    val nativeMock = new ReactNavigationMock(getFocusedRouteNameFromRouteMock, useIsFocusedMock, useThemeMock)
    val nav = TestReactNavigation(nativeMock.asInstanceOf[raw.ReactNavigation])
    val theme = js.Dynamic.literal().asInstanceOf[Theme]

    useThemeMock.expects().returning(theme)

    //when & then
    nav.useTheme() should be theSameInstanceAs theme
  }
  
  it should "return array of light and dark styles if dark theme when themeStyle" in {
    //given
    val lightStyle = new Style {}
    val darkStyle = new Style {}
    val nativeMock = mock[ReactNavigationMock]
    val nav = TestReactNavigation(nativeMock.asInstanceOf[raw.ReactNavigation])
    implicit val theme: Theme = js.Dynamic.literal("dark" -> true).asInstanceOf[Theme]

    //when
    val result = nav.themeStyle(lightStyle, darkStyle)
    
    //then
    result.name shouldBe "style"
    result.value.asInstanceOf[js.Array[Style]].toList shouldBe List(lightStyle, darkStyle)
  }
  
  it should "return light style if non-dark theme when themeStyle" in {
    //given
    val lightStyle = new Style {}
    val darkStyle = new Style {}
    val nativeMock = mock[ReactNavigationMock]
    val nav = TestReactNavigation(nativeMock.asInstanceOf[raw.ReactNavigation])
    implicit val theme: Theme = js.Dynamic.literal("dark" -> false).asInstanceOf[Theme]

    //when
    val result = nav.themeStyle(lightStyle, darkStyle)
    
    //then
    result.name shouldBe "style"
    result.value should be theSameInstanceAs lightStyle
  }
  
  it should "cache style for the same theme when themeTextStyle" in {
    //given
    val nativeMock = mock[ReactNavigationMock]
    val nav = TestReactNavigation(nativeMock.asInstanceOf[raw.ReactNavigation])
    implicit val theme: Theme = js.Dynamic.literal("colors" -> js.Dynamic.literal(
      "text" -> "test_color_1"
    )).asInstanceOf[Theme]

    //when
    val result = nav.themeTextStyle

    //then
    result.color shouldBe "test_color_1"

    //when & then
    nav.themeTextStyle should be theSameInstanceAs result
  }
}

object ReactNavigationSpec {

  @JSExportAll
  class ReactNavigationMock(
                             getFocusedRouteNameFromRouteMock: raw.Route => js.Any,
                             useIsFocusedMock: () => Boolean,
                             useThemeMock: () => Theme
                           ) {

    def getFocusedRouteNameFromRoute(route: raw.Route): js.Any = getFocusedRouteNameFromRouteMock(route)

    def useIsFocused(): Boolean = useIsFocusedMock()

    def useTheme(): Theme = useThemeMock()
  }

  case class TestReactNavigation(mock: raw.ReactNavigation) extends ReactNavigation {
    protected def native: raw.ReactNavigation = mock
  }
}
