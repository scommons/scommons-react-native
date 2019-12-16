package scommons.reactnative.showcase.style

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative._
import scommons.reactnative.showcase.style.TextStyleDemo._

class TextStyleDemoSpec extends TestSpec with ShallowRendererUtils {

  it should "render component" in {
    //given
    val component = <(TextStyleDemo())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <(LeftText())(^.rnStyle := new TextStyle {
          override val fontStyle = "italic"
        })(
          "A) Italic"
        ),
        <(LeftText())(^.rnStyle := new TextStyle {
          override val textDecorationLine = "underline line-through"
        })(
          "B) Underline and Line Through"
        ),
        <(LeftText())(^.rnStyle := new IOSTextStyle {
          override val textDecorationLine = "underline line-through"
          override val textDecorationColor = "red"
          override val textDecorationStyle = "dotted"
        })(
          "C) Underline and Line Through"
        ),
        <(LeftText())(^.rnStyle := new TextStyle {
          override val textShadowColor = "red"
          override val textShadowOffset = new Style.ShadowOffset {
            override val width = -2
            override val height = -2
          }
          override val textShadowRadius = 4
        })(
          "D) Text Shadow"
        ),
        <(LeftText())(^.rnStyle := new IOSTextStyle {
          override val letterSpacing = 5
        })(
          "E) Letter Spacing"
        ),
        <(LeftText())(^.rnStyle := new TextStyle {
          override val textAlign = "center"
          override val fontWeight = "bold"
        })(
          s"${Platform.OS}"
        )
      )
    )
  }
}
