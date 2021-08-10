package showcase

import io.github.shogowada.scalajs.reactjs.redux.Redux.Dispatch
import scommons.react.navigation._
import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative.Switch._
import scommons.reactnative._
import showcase.SwitchDemo.styles
import showcase.app.config.ShowcaseConfigActions

class SwitchDemoSpec extends TestSpec with ShallowRendererUtils {

  it should "call updateTheme when onValueChange" in {
    //given
    val dispatch = mockFunction[Any, Any]
    val updateThemeMock = mockFunction[Dispatch, Boolean, Unit]
    val actions = new ShowcaseConfigActions {
      override def updateTheme(dispatch: Dispatch, darkTheme: Boolean): Unit = {
        updateThemeMock(dispatch, darkTheme)
      }
    }
    val props = SwitchDemoProps(dispatch, actions, darkTheme = false)
    val comp = shallowRender(<(SwitchDemo())(^.wrapped := props)())
    val List(switchComp) = findComponents(comp, <.Switch.reactClass)
    val darkTheme = true

    //then
    updateThemeMock.expects(*, *).onCall { (resDispatch, resDarkTheme) =>
      resDispatch shouldBe dispatch
      resDarkTheme shouldBe darkTheme
    }
    
    //when
    switchComp.props.onValueChange(darkTheme)
  }

  it should "render component" in {
    //given
    val dispatch = mockFunction[Any, Any]
    val actions = mock[ShowcaseConfigActions]
    val props = SwitchDemoProps(dispatch, actions, darkTheme = false)
    val component = <(SwitchDemo())(^.wrapped := props)()
    
    //when
    val result = shallowRender(component)
    
    //then
    implicit val theme: Theme = DefaultTheme
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.Text(^.rnStyle := themeTextStyle)("Dark Theme"),
        <.Switch(
          ^.trackColor := new TrackColor {
            val `false`: String = "#767577"
            val `true`: String = "#81b0ff"
          },
          ^.thumbColor := "#f4f3f4",
          ^("ios_backgroundColor") := "#3e3e3e",
          ^.switchValue := false
        )()
      )
    )
  }
}
