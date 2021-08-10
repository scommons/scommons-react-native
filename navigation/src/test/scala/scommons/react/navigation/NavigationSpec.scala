package scommons.react.navigation

import io.github.shogowada.scalajs.reactjs.React.Props
import org.scalamock.scalatest.MockFactory
import org.scalatest.Inside
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import scommons.react.navigation.NavigationSpec._
import scommons.react.navigation.stack.raw.StackScreenOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportAll

class NavigationSpec extends AnyFlatSpec
  with Matchers
  with Inside
  with MockFactory {

  it should "navigate to route when navigate" in {
    //given
    val navigateMock = mockFunction[String, Unit]
    val navigate2Mock = mockFunction[String, js.Any, Unit]
    val goBackMock = mockFunction[Unit]
    val setParamsMock = mockFunction[js.Any, Unit]
    val setOptionsMock = mockFunction[js.Object, Unit]
    val native = new NavigationMock(navigateMock, navigate2Mock, goBackMock, setParamsMock, setOptionsMock)
    val nav = Navigation(Props(js.Dynamic.literal(
      "navigation" -> native.asInstanceOf[raw.Navigation]
    )))
    val routeName = "TestRoute"

    //then
    navigateMock.expects(routeName)

    //when
    nav.navigate(routeName)
  }
  
  it should "navigate to route and pass params when navigate" in {
    //given
    val navigateMock = mockFunction[String, Unit]
    val navigate2Mock = mockFunction[String, js.Any, Unit]
    val goBackMock = mockFunction[Unit]
    val setParamsMock = mockFunction[js.Any, Unit]
    val setOptionsMock = mockFunction[js.Object, Unit]
    val native = new NavigationMock(navigateMock, navigate2Mock, goBackMock, setParamsMock, setOptionsMock)
    val nav = Navigation(Props(js.Dynamic.literal(
      "navigation" -> native.asInstanceOf[raw.Navigation]
    )))
    val routeName = "TestRoute"
    val params = testParams

    //then
    navigate2Mock.expects(routeName, *).onCall { (_, dict) =>
      dict.asInstanceOf[js.Dictionary[String]].toMap shouldBe testParams
    }

    //when
    nav.navigate(routeName, params)
  }

  it should "call goBack when goBack" in {
    //given
    val navigateMock = mockFunction[String, Unit]
    val navigate2Mock = mockFunction[String, js.Any, Unit]
    val goBackMock = mockFunction[Unit]
    val setParamsMock = mockFunction[js.Any, Unit]
    val setOptionsMock = mockFunction[js.Object, Unit]
    val native = new NavigationMock(navigateMock, navigate2Mock, goBackMock, setParamsMock, setOptionsMock)
    val nav = Navigation(Props(js.Dynamic.literal(
      "navigation" -> native.asInstanceOf[raw.Navigation]
    )))

    //then
    goBackMock.expects()

    //when
    nav.goBack()
  }
  
  it should "return empty Map if params is undefined when getParams" in {
    //given
    val route = new RouteMock(
      paramsMock = js.undefined
    )
    val nav = Navigation(Props(js.Dynamic.literal(
      "route" -> route.asInstanceOf[raw.Route]
    )))

    //when
    val result = nav.getParams
    
    //then
    result shouldBe Map.empty
  }

  it should "return empty Map if params is null when getParams" in {
    //given
    val route = new RouteMock(
      paramsMock = null
    )
    val nav = Navigation(Props(js.Dynamic.literal(
      "route" -> route.asInstanceOf[raw.Route]
    )))

    //when
    val result = nav.getParams
    
    //then
    result shouldBe Map.empty
  }

  it should "return params when getParams" in {
    //given
    val route = new RouteMock(
      paramsMock = js.Dictionary(testParams.toSeq: _*)
    )
    val nav = Navigation(Props(js.Dynamic.literal(
      "route" -> route.asInstanceOf[raw.Route]
    )))

    //when
    val result = nav.getParams
    
    //then
    result shouldBe testParams
  }

  it should "set params when setParams" in {
    //given
    val navigateMock = mockFunction[String, Unit]
    val navigate2Mock = mockFunction[String, js.Any, Unit]
    val goBackMock = mockFunction[Unit]
    val setParamsMock = mockFunction[js.Any, Unit]
    val setOptionsMock = mockFunction[js.Object, Unit]
    val native = new NavigationMock(navigateMock, navigate2Mock, goBackMock, setParamsMock, setOptionsMock)
    val nav = Navigation(Props(js.Dynamic.literal(
      "navigation" -> native.asInstanceOf[raw.Navigation]
    )))
    val params = testParams

    //then
    setParamsMock.expects(*).onCall { dict: js.Any =>
      dict.asInstanceOf[js.Dictionary[String]].toMap shouldBe testParams
      ()
    }

    //when
    nav.setParams(params)
  }

  it should "set options when setOptions" in {
    //given
    val navigateMock = mockFunction[String, Unit]
    val navigate2Mock = mockFunction[String, js.Any, Unit]
    val goBackMock = mockFunction[Unit]
    val setParamsMock = mockFunction[js.Any, Unit]
    val setOptionsMock = mockFunction[js.Object, Unit]
    val native = new NavigationMock(navigateMock, navigate2Mock, goBackMock, setParamsMock, setOptionsMock)
    val nav = Navigation(Props(js.Dynamic.literal(
      "navigation" -> native.asInstanceOf[raw.Navigation]
    )))
    val options = new StackScreenOptions {
      override val title = "test"
    }

    //then
    setOptionsMock.expects(options)

    //when
    nav.setOptions(options)
  }
}

object NavigationSpec {
  
  val testParams = Map(
    "name" -> "test"
  )

  @JSExportAll
  class NavigationMock(
                        navigateMock: String => Unit,
                        navigate2Mock: (String, js.Any) => Unit,
                        goBackMock: () => Unit,
                        setParamsMock: js.Any => Unit,
                        setOptionsMock: js.Object => Unit
                      ) {

    def navigate(name: String): Unit = navigateMock(name)
    def navigate(name: String, params: js.Any): Unit = navigate2Mock(name, params)

    def goBack(): Unit = goBackMock()

    def setParams(params: js.Any): Unit = setParamsMock(params)
    def setOptions(options: js.Object): Unit = setOptionsMock(options)
  }

  @JSExportAll
  class RouteMock(paramsMock: js.Any) {

    def params: js.Any = paramsMock
  }
}
