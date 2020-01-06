package scommons.reactnative.showcase

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative._
import scommons.reactnative.showcase.ImageDemo._
import scommons.reactnative.showcase.style.StyleImages

class ImageDemoSpec extends TestSpec with ShallowRendererUtils {

  it should "render component" in {
    //given
    val component = <(ImageDemo())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <("Image")(
        ^.rnStyle := styles.image,
        ^.source := StyleImages.User
      )()
    )
  }
}
