package showcase

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative.Style._
import scommons.reactnative._

import scala.scalajs.js

class StyleDemoSpec extends TestSpec with ShallowRendererUtils {

  it should "render component and set common style" in {
    //given
    val component = <(StyleDemo())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <("Text")(
        ^.rnStyle := js.Dynamic.literal(
          "borderBottomRightRadius" -> 1,
          "borderBottomWidth" -> 2,
          "borderColor" -> Color.red,
          "borderLeftColor" -> Color.blue,
          "borderLeftWidth" -> 3,
          "borderRadius" -> 4,
          "borderRightWidth" -> 5,
          "borderStyle" -> BorderStyle.dashed,
          "borderTopColor" -> Color.yellow,
          "borderTopLeftRadius" -> 6,
          "borderTopRightRadius" -> 7,
          "borderTopWidth" -> 8,
          "borderWidth" -> 9,
          "margin" -> 10,
          "marginBottom" -> 11,
          "marginEnd" -> 12,
          "marginHorizontal" -> 13,
          "marginLeft" -> 14,
          "marginRight" -> 15,
          "marginStart" -> 16,
          "marginTop" -> 17,
          "marginVertical" -> 18,
          "padding" -> 19,
          "paddingBottom" -> 20,
          "paddingEnd" -> 21,
          "paddingHorizontal" -> 22,
          "paddingLeft" -> 23,
          "paddingRight" -> 24,
          "paddingStart" -> 25,
          "paddingTop" -> 26,
          "paddingVertical" -> 27,
          "shadowColor" -> Color.gray,
          "shadowOffset" -> js.Dynamic.literal(
            "width" -> 1,
            "height" -> 2
          ).asInstanceOf[ShadowOffset],
          "shadowOpacity" -> 0.2,
          "shadowRadius" -> 28,
          "backgroundColor" -> Color.white,
          "color" -> Color.black,
          "position" -> Position.absolute,
          "width" -> 30,
          "height" -> 31,
          "left" -> 32,
          "right" -> 33,
          "top" -> 34,
          "bottom" -> 35,
          "elevation" -> 40
    ).asInstanceOf[Style]
      )()
    )
  }
  
  it should "provide BorderStyle enum" in {
    //when & then
    BorderStyle.solid shouldBe "solid"
    BorderStyle.dotted shouldBe "dotted"
    BorderStyle.dashed shouldBe "dashed"
  }
  
  it should "provide Position enum" in {
    //when & then
    Position.relative shouldBe "relative"
    Position.absolute shouldBe "absolute"
  }
}
