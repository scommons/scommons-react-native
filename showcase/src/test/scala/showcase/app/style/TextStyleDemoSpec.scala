package showcase.app.style

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative.IOSTextStyle._
import scommons.reactnative.Style._
import scommons.reactnative.TextStyle._
import scommons.reactnative._
import showcase.app.style.TextStyleDemo._

import scala.scalajs.js

class TextStyleDemoSpec extends TestSpec with ShallowRendererUtils {

  it should "render LeftText component" in {
    //given
    val style = new TextStyle {
      override val fontStyle = FontStyle.italic
    }
    val component = <(LeftText())(^.rnStyle := style)("test child")
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <.Text(^.rnStyle := js.Array(
        styles.leftText,
        style
      ))(
        "test child"
      )
    )
  }
  
  it should "render main component" in {
    //given
    val component = <(TextStyleDemo())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.screen)(
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
    )
  }
}
