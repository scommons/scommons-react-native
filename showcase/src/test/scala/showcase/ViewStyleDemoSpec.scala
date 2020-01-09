package showcase

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative.ViewStyle._
import scommons.reactnative._

import scala.scalajs.js

class ViewStyleDemoSpec extends TestSpec with ShallowRendererUtils {

  it should "render component and set view style" in {
    //given
    val component = <(ViewStyleDemo())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <("View")(
        ^.rnStyle := js.Dynamic.literal(
          "alignContent" -> AlignContent.center,
          "alignItems" -> AlignItems.baseline,
          "alignSelf" -> AlignSelf.stretch,
          "flex" -> 1,
          "flexBasis" -> 2,
          "flexDirection" -> FlexDirection.row,
          "flexGrow" -> 0.3,
          "flexShrink" -> 0.4,
          "flexWrap" -> FlexWrap.wrap,
          "justifyContent" -> JustifyContent.`space-evenly`
        ).asInstanceOf[Style]
      )()
    )
  }
  
  it should "provide AlignItems enum" in {
    //when & then
    AlignItems.stretch shouldBe "stretch"
    AlignItems.`flex-start` shouldBe "flex-start"
    AlignItems.`flex-end` shouldBe "flex-end"
    AlignItems.center shouldBe "center"
    AlignItems.baseline shouldBe "baseline"
  }
  
  it should "provide AlignSelf enum" in {
    //when & then
    AlignSelf.auto shouldBe "auto"
    AlignSelf.stretch shouldBe "stretch"
    AlignSelf.center shouldBe "center"
    AlignSelf.`flex-start` shouldBe "flex-start"
    AlignSelf.`flex-end` shouldBe "flex-end"
  }
  
  it should "provide FlexDirection enum" in {
    //when & then
    FlexDirection.column shouldBe "column"
    FlexDirection.row shouldBe "row"
    FlexDirection.`row-reverse` shouldBe "row-reverse"
    FlexDirection.`column-reverse` shouldBe "column-reverse"
  }
  
  it should "provide FlexWrap enum" in {
    //when & then
    FlexWrap.nowrap shouldBe "nowrap"
    FlexWrap.wrap shouldBe "wrap"
  }
  
  it should "provide JustifyContent enum" in {
    //when & then
    JustifyContent.`flex-start` shouldBe "flex-start"
    JustifyContent.`flex-end` shouldBe "flex-end"
    JustifyContent.center shouldBe "center"
    JustifyContent.`space-between` shouldBe "space-between"
    JustifyContent.`space-around` shouldBe "space-around"
    JustifyContent.`space-evenly` shouldBe "space-evenly"
  }
  
  it should "provide AlignContent enum" in {
    //when & then
    AlignContent.`flex-start` shouldBe "flex-start"
    AlignContent.`flex-end` shouldBe "flex-end"
    AlignContent.`stretch` shouldBe "stretch"
    AlignContent.center shouldBe "center"
    AlignContent.`space-between` shouldBe "space-between"
    AlignContent.`space-around` shouldBe "space-around"
  }
}
