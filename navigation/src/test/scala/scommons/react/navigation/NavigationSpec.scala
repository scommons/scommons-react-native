package scommons.react.navigation

import io.github.shogowada.scalajs.reactjs.React.Props
import org.scalamock.scalatest.MockFactory
import org.scalatest.{FlatSpec, Inside, Matchers}
import scommons.react.navigation.NavigationSpec._
import scommons.react.navigation.stack.raw.StackScreenOptions

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
    val params = testParams

    //then
    (native.navigate(_: String, _: js.Any)).expects(routeName, *).onCall { (_, dict) =>
      dict.asInstanceOf[js.Dictionary[String]].toMap shouldBe testParams
    }

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
  
  it should "return empty Map if params is undefined when getParams" in {
    //given
    val route = mock[RouteMock]
    val nav = Navigation(Props(js.Dynamic.literal(
      "route" -> route.asInstanceOf[raw.Route]
    )))

    //then
    (route.params _).expects().returning(js.undefined)

    //when
    val result = nav.getParams
    
    //then
    result shouldBe Map.empty
  }

  it should "return empty Map if params is null when getParams" in {
    //given
    val route = mock[RouteMock]
    val nav = Navigation(Props(js.Dynamic.literal(
      "route" -> route.asInstanceOf[raw.Route]
    )))

    //then
    (route.params _).expects().returning(null)

    //when
    val result = nav.getParams
    
    //then
    result shouldBe Map.empty
  }

  it should "return params when getParams" in {
    //given
    val route = mock[RouteMock]
    val nav = Navigation(Props(js.Dynamic.literal(
      "route" -> route.asInstanceOf[raw.Route]
    )))
    val params = testParams

    //then
    (route.params _).expects().returning(js.Dictionary(params.toSeq: _*))

    //when
    val result = nav.getParams
    
    //then
    result shouldBe params
  }

  it should "set params when setParams" in {
    //given
    val navigation = mock[NavigationMock]
    val nav = Navigation(Props(js.Dynamic.literal(
      "navigation" -> navigation.asInstanceOf[raw.Navigation]
    )))
    val params = testParams

    //then
    (navigation.setParams _).expects(*).onCall { dict: js.Any =>
      dict.asInstanceOf[js.Dictionary[String]].toMap shouldBe testParams
      ()
    }

    //when
    nav.setParams(params)
  }

  it should "set options when setOptions" in {
    //given
    val navigation = mock[NavigationMock]
    val nav = Navigation(Props(js.Dynamic.literal(
      "navigation" -> navigation.asInstanceOf[raw.Navigation]
    )))
    val options = new StackScreenOptions {
      override val title = "test"
    }

    //then
    (navigation.setOptions _).expects(options)

    //when
    nav.setOptions(options)
  }
}

object NavigationSpec {
  
  val testParams = Map(
    "name" -> "test"
  )

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
