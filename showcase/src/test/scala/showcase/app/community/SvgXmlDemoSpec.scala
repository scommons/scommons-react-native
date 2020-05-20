package showcase.app.community

import scommons.react.test._
import scommons.react.test.dom._
import scommons.reactnative._
import scommons.reactnative.svg._
import showcase.app.community.SvgXmlDemo._

class SvgXmlDemoSpec extends AsyncTestSpec with ShallowRendererUtils {

  it should "render component" in {
    //given
    val component = <(SvgXmlDemo())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.SvgXml(^.rnStyle := styles.container, ^.xml := xml)()
      )
    )
  }
}
