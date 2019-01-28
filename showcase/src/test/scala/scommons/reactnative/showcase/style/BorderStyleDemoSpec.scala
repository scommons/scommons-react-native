package scommons.reactnative.showcase.style

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative._
import scommons.reactnative.showcase.style.BorderStyleDemo._

class BorderStyleDemoSpec extends TestSpec with ShallowRendererUtils {

  it should "render component" in {
    //given
    val component = <(BorderStyleDemo())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result, <("View")(^.rnStyle := styles.container)(), {
      case List(example1, example2, example3, example4, example5) =>
        example1.`type` shouldBe Example
        example1.props.style.borderWidth shouldBe 1
        
        example2.`type` shouldBe Example
        example2.props.style.borderWidth shouldBe 3
        example2.props.style.borderLeftWidth shouldBe 0
        
        example3.`type` shouldBe Example
        example3.props.style.borderWidth shouldBe 3
        example3.props.style.borderLeftColor shouldBe "red"
        
        example4.`type` shouldBe Example
        example4.props.style.borderLeftWidth shouldBe 3
        
        example5.`type` shouldBe Example
        example5.props.style.borderWidth shouldBe 1
        example5.props.style.borderStyle shouldBe "dashed"
    })
  }
}
