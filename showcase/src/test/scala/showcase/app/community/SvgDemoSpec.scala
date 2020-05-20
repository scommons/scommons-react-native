package showcase.app.community

import scommons.react.test._
import scommons.react.test.dom._
import scommons.reactnative._
import showcase.app.community.SvgDemo._

class SvgDemoSpec extends AsyncTestSpec with ShallowRendererUtils {

  it should "render component" in {
    //given
    val component = <(SvgDemo())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.Text(^.rnStyle := styles.title)("SvgXml:"),
        <(SvgXmlDemo())()(),

        <.Text(^.rnStyle := styles.title)("SvgCss:"),
        <(SvgCssDemo())()()
      )
    )
  }
}
