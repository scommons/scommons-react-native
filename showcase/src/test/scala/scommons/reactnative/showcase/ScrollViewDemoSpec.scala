package scommons.reactnative.showcase

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative.ScrollView._
import scommons.reactnative._
import scommons.reactnative.showcase.ScrollViewDemo._

class ScrollViewDemoSpec extends TestSpec with ShallowRendererUtils {

  it should "render component" in {
    //given
    val component = <(ScrollViewDemo())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <("ScrollView")(
        ^.rnStyle := styles.scrollView,
        ^.keyboardShouldPersistTaps := KeyboardShouldPersistTaps.always
      )()
    )
  }
  
  it should "provide KeyboardShouldPersistTaps enum" in {
    //when & then
    KeyboardShouldPersistTaps.never shouldBe "never"
    KeyboardShouldPersistTaps.always shouldBe "always"
    KeyboardShouldPersistTaps.handled shouldBe "handled"
  }
}
