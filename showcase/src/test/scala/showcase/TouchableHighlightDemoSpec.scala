package showcase

import scommons.react.test._
import scommons.reactnative.Style._
import scommons.reactnative._
import showcase.TouchableHighlightDemo.styles

class TouchableHighlightDemoSpec extends TestSpec with TestRendererUtils {

  it should "call onPress" in {
    //given
    val onPress = mockFunction[Unit]
    val props = TouchableHighlightDemoProps(onPress = onPress)
    val comp = testRender(<(TouchableHighlightDemo())(^.wrapped := props)())
    
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
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <("TouchableHighlight")(
        ^.rnStyle := styles.touchableHighlight,
        ^.underlayColor := Color.red
      )()
    )
  }
}
