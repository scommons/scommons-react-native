package showcase

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative.Switch._
import scommons.reactnative._
import showcase.SwitchDemo.styles

class SwitchDemoSpec extends TestSpec with ShallowRendererUtils {

  it should "set value when onValueChange" in {
    //given
    val renderer = createRenderer()
    renderer.render(<(SwitchDemo())()())
    val List(comp) = findComponents(renderer.getRenderOutput(), <.Switch.reactClass)
    comp.props.selectDynamic("value") shouldBe false

    //when
    comp.props.onValueChange(true)

    //then
    val List(updated) = findComponents(renderer.getRenderOutput(), <.Switch.reactClass)
    updated.props.selectDynamic("value") shouldBe true
  }

  it should "render component" in {
    //given
    val component = <(SwitchDemo())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.Text()("Dark Theme"),
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
