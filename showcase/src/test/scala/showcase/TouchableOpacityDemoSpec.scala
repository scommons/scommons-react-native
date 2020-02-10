package showcase

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative._
import showcase.TouchableOpacityDemo.styles

class TouchableOpacityDemoSpec extends TestSpec with ShallowRendererUtils {

  it should "call onPress" in {
    //given
    val onPress = mockFunction[Unit]
    val props = TouchableOpacityDemoProps(onPress = onPress)
    val comp = shallowRender(<(TouchableOpacityDemo())(^.wrapped := props)())
    
    //then
    onPress.expects()
    
    //when
    comp.props.onPress()
  }
  
  it should "render component" in {
    //given
    val props = TouchableOpacityDemoProps(() => ())
    val component = <(TouchableOpacityDemo())(^.wrapped := props)()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <("TouchableOpacity")(
        ^.rnStyle := styles.touchableOpacity,
        ^.activeOpacity := 0.5
      )()
    )
  }
}
