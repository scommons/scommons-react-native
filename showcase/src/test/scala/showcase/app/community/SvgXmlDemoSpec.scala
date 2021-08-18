package showcase.app.community

import scommons.react.test._
import scommons.reactnative._
import scommons.reactnative.svg._
import showcase.app.community.SvgXmlDemo._

class SvgXmlDemoSpec extends TestSpec with TestRendererUtils {

  it should "render component" in {
    //given
    val component = <(SvgXmlDemo())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.View()(
        <.SvgXml(^.rnStyle := styles.svg, ^.xml := xml)()
      )
    )
  }
}
