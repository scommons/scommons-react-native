package showcase.app.community

import scommons.nodejs.test.AsyncTestSpec
import scommons.react.test._
import scommons.reactnative._
import scommons.reactnative.svg._
import showcase.app.community.SvgXmlDemo._

class SvgXmlDemoSpec extends AsyncTestSpec
  with BaseTestSpec
  with ShallowRendererUtils {

  it should "render component" in {
    //given
    val component = <(SvgXmlDemo())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <.View()(
        <.SvgXml(^.rnStyle := styles.svg, ^.xml := xml)()
      )
    )
  }
}
