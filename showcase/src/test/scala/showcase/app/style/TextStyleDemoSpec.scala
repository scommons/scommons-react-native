package showcase.app.style

import scommons.react.test._
import scommons.reactnative.IOSTextStyle._
import scommons.reactnative.Style._
import scommons.reactnative.TextStyle._
import scommons.reactnative._
import showcase.app.style.TextStyleDemo._

import scala.scalajs.js

class TextStyleDemoSpec extends TestSpec with TestRendererUtils {

  TextStyleDemo.leftTextComp = mockUiComponent("LeftText")

  it should "render LeftText component" in {
    //given
    val style = new TextStyle {
      override val fontStyle = FontStyle.italic
    }
    val component = <(LeftText())(^.rnStyle := style)("test child")
    
    //when
    val result = testRender(component)
    
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
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.screen)(
        <.View(^.rnStyle := styles.container)(
          <(leftTextComp())(^.rnStyle := new TextStyle {
            override val fontStyle = FontStyle.italic
          })(
            "A) Italic"
          ),
          <(leftTextComp())(^.rnStyle := new TextStyle {
            override val textDecorationLine = TextDecorationLine.`underline line-through`
          })(
            "B) Underline and Line Through"
          ),
          <(leftTextComp())(^.rnStyle := new IOSTextStyle {
            override val textDecorationLine = TextDecorationLine.`underline line-through`
            override val textDecorationColor = Color.red
            override val textDecorationStyle = TextDecorationStyle.dotted
          })(
            "C) Underline and Line Through"
          ),
          <(leftTextComp())(^.rnStyle := new TextStyle {
            override val textShadowColor = Color.red
            override val textShadowOffset = new ShadowOffset {
              override val width = -2
              override val height = -2
            }
            override val textShadowRadius = 4
          })(
            "D) Text Shadow"
          ),
          <(leftTextComp())(^.rnStyle := new IOSTextStyle {
            override val letterSpacing = 5
          })(
            "E) Letter Spacing"
          ),
          <(leftTextComp())(^.rnStyle := new TextStyle {
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
