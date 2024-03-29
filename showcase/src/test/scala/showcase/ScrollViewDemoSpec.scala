package showcase

import scommons.react.test._
import scommons.reactnative.ScrollView._
import scommons.reactnative._
import showcase.ScrollViewDemo.styles

class ScrollViewDemoSpec extends TestSpec with TestRendererUtils {

  it should "render component" in {
    //given
    val component = <(ScrollViewDemo())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.ScrollView(
        ^.rnStyle := styles.scrollView,
        ^.contentContainerStyle := styles.content,
        ^.keyboardDismissMode := KeyboardDismissMode.`on-drag`,
        ^.keyboardShouldPersistTaps := KeyboardShouldPersistTaps.handled
      )()
    )
  }
  
  it should "provide KeyboardShouldPersistTaps enum" in {
    //when & then
    KeyboardShouldPersistTaps.never shouldBe "never"
    KeyboardShouldPersistTaps.always shouldBe "always"
    KeyboardShouldPersistTaps.handled shouldBe "handled"
  }
  
  it should "provide KeyboardDismissMode enum" in {
    //when & then
    KeyboardDismissMode.none shouldBe "none"
    KeyboardDismissMode.`on-drag` shouldBe "on-drag"
  }
}
