package scommons.reactnative.showcase.style

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative.IOSTextStyle._
import scommons.reactnative.Style._
import scommons.reactnative.TextStyle._
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
          override val fontStyle = FontStyle.italic
        })(
          "A) Italic"
        ),
        <(LeftText())(^.rnStyle := new TextStyle {
          override val textDecorationLine = TextDecorationLine.`underline line-through`
        })(
          "B) Underline and Line Through"
        ),
        <(LeftText())(^.rnStyle := new IOSTextStyle {
          override val textDecorationLine = TextDecorationLine.`underline line-through`
          override val textDecorationColor = Color.red
          override val textDecorationStyle = TextDecorationStyle.dotted
        })(
          "C) Underline and Line Through"
        ),
        <(LeftText())(^.rnStyle := new TextStyle {
          override val textShadowColor = Color.red
          override val textShadowOffset = new ShadowOffset {
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
          override val textAlign = TextAlign.center
          override val fontWeight = FontWeight.bold
        })(
          s"${Platform.OS}"
        )
      )
    )
  }
}
