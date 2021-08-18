package showcase

import scommons.react.test._
import scommons.reactnative.AndroidTextStyle._
import scommons.reactnative.IOSTextStyle._
import scommons.reactnative.Style._
import scommons.reactnative.TextStyle._
import scommons.reactnative._

import scala.scalajs.js

class TextStyleDemoSpec extends TestSpec with TestRendererUtils {

  it should "render component and set text style" in {
    //given
    val component = <(TextStyleDemo())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <("Text")(
        ^.rnStyle := js.Dynamic.literal(
          "fontFamily" -> Platform.select {
            case Platform.ios | Platform.web => "American Typewriter"
            case Platform.android => "monospace"
          },
          "fontSize" -> 14,
          "fontStyle" -> FontStyle.italic,
          "fontWeight" -> FontWeight.`100`,
          "lineHeight" -> 12,
          "textAlign" -> TextAlign.center,
          "textDecorationLine" -> TextDecorationLine.underline,
          "textShadowColor" -> Color.red,
          "textShadowOffset" -> js.Dynamic.literal(
            "width" -> 1,
            "height" -> 2
          ).asInstanceOf[ShadowOffset],
          "textShadowRadius" -> 11,
          // android
          "textAlignVertical" -> TextAlignVertical.center,
          // ios
          "letterSpacing" -> 2,
          "textDecorationColor" -> Color.blue,
          "textDecorationStyle" -> TextDecorationStyle.dashed,
          "writingDirection" -> WritingDirection.auto
    ).asInstanceOf[Style]
      )()
    )
  }
  
  it should "provide FontStyle enum" in {
    //when & then
    FontStyle.normal shouldBe "normal"
    FontStyle.italic shouldBe "italic"
  }
  
  it should "provide FontWeight enum" in {
    //when & then
    FontWeight.normal shouldBe "normal"
    FontWeight.bold shouldBe "bold"
    FontWeight.`100` shouldBe "100"
    FontWeight.`200` shouldBe "200"
    FontWeight.`300` shouldBe "300"
    FontWeight.`400` shouldBe "400"
    FontWeight.`500` shouldBe "500"
    FontWeight.`600` shouldBe "600"
    FontWeight.`700` shouldBe "700"
    FontWeight.`800` shouldBe "800"
    FontWeight.`900` shouldBe "900"
  }
  
  it should "provide TextAlign enum" in {
    //when & then
    TextAlign.auto shouldBe "auto"
    TextAlign.center shouldBe "center"
    TextAlign.right shouldBe "right"
    TextAlign.left shouldBe "left"
    // iOS only
    TextAlign.justify shouldBe "justify"
  }
  
  it should "provide TextDecorationLine enum" in {
    //when & then
    TextDecorationLine.none shouldBe "none"
    TextDecorationLine.underline shouldBe "underline"
    TextDecorationLine.`line-through` shouldBe "line-through"
    TextDecorationLine.`underline line-through` shouldBe "underline line-through"
  }
  
  it should "provide TextAlignVertical enum" in {
    //when & then
    TextAlignVertical.auto shouldBe "auto"
    TextAlignVertical.top shouldBe "top"
    TextAlignVertical.bottom shouldBe "bottom"
    TextAlignVertical.center shouldBe "center"
  }
  
  it should "provide TextDecorationStyle enum" in {
    //when & then
    TextDecorationStyle.solid shouldBe "solid"
    TextDecorationStyle.double shouldBe "double"
    TextDecorationStyle.dotted shouldBe "dotted"
    TextDecorationStyle.dashed shouldBe "dashed"
  }
  
  it should "provide WritingDirection enum" in {
    //when & then
    WritingDirection.auto shouldBe "auto"
    WritingDirection.ltr shouldBe "ltr"
    WritingDirection.rtl shouldBe "rtl"
  }
}
