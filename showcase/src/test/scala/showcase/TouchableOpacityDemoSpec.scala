package showcase

import scommons.react.test._
import scommons.reactnative._
import showcase.TouchableOpacityDemo.styles

class TouchableOpacityDemoSpec extends TestSpec with TestRendererUtils {

  it should "call onPress" in {
    //given
    val onPress = mockFunction[Unit]
    val props = TouchableOpacityDemoProps(onPress = onPress)
    val comp = testRender(<(TouchableOpacityDemo())(^.wrapped := props)())
    
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
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <("TouchableOpacity")(
        ^.rnStyle := styles.touchableOpacity,
        ^.activeOpacity := 0.5
      )()
    )
  }
}
