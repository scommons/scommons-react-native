package showcase.app.community

import scommons.react.test._
import scommons.reactnative._
import scommons.reactnative.svg._
import showcase.app.community.SvgCssDemo._

class SvgCssDemoSpec extends TestSpec with TestRendererUtils {

  it should "render component" in {
    //given
    val component = <(SvgCssDemo())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.View()(
        <.SvgCss(^.xml := xml, ^.width := 32, ^.height := 32)()
      )
    )
  }
}
