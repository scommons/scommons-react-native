package scommons.react.navigation

import org.scalamock.scalatest.MockFactory
import org.scalatest._
import scommons.react.navigation.ReactNavigationSpec._
import scommons.reactnative.Style

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

  it should "return native theme when useTheme" in {
    //given
    val nativeMock = mock[ReactNavigationMock]
    val nav = TestReactNavigation(nativeMock.asInstanceOf[raw.ReactNavigation])
    val theme = js.Dynamic.literal().asInstanceOf[Theme]

    (nativeMock.useTheme _).expects().returning(theme)

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
  trait ReactNavigationMock {

    def getFocusedRouteNameFromRoute(route: raw.Route): js.Any

    def useIsFocused(): Boolean

    def useTheme(): Theme
  }

  case class TestReactNavigation(mock: raw.ReactNavigation) extends ReactNavigation {
    protected def native: raw.ReactNavigation = mock
  }
}
