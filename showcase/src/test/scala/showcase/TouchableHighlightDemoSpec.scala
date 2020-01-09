package showcase

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative.Style._
import scommons.reactnative._
import showcase.TouchableHighlightDemo.styles

class TouchableHighlightDemoSpec extends TestSpec with ShallowRendererUtils {

  it should "call onPress" in {
    //given
    val onPress = mockFunction[Unit]
    val props = TouchableHighlightDemoProps(onPress = onPress)
    val comp = shallowRender(<(TouchableHighlightDemo())(^.wrapped := props)())
    
    //then
    onPress.expects()
    
    //when
    comp.props.onPress()
  }
  
  it should "render component" in {
    //given
    val props = TouchableHighlightDemoProps(() => ())
    val component = <(TouchableHighlightDemo())(^.wrapped := props)()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <("TouchableHighlight")(
        ^.rnStyle := styles.touchableHighlight,
        ^.underlayColor := Color.red
      )()
    )
  }
}
