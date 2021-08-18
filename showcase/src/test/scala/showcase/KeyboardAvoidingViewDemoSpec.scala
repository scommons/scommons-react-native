package showcase

import scommons.react.test._
import scommons.reactnative.KeyboardAvoidingView._
import scommons.reactnative._
import showcase.KeyboardAvoidingViewDemo.styles

class KeyboardAvoidingViewDemoSpec extends TestSpec with TestRendererUtils {

  it should "render component" in {
    //given
    val component = <(KeyboardAvoidingViewDemo())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.KeyboardAvoidingView(
        ^.rnStyle := styles.container,
        ^.contentContainerStyle := styles.content,
        ^.behavior := {
          if (Platform.OS == Platform.ios) Behavior.padding
          else Behavior.height
        }
      )()
    )
  }
  
  it should "provide Behavior enum" in {
    //when & then
    Behavior.height shouldBe "height"
    Behavior.position shouldBe "position"
    Behavior.padding shouldBe "padding"
  }
}
