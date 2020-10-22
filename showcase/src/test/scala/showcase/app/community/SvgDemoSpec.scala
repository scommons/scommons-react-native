package showcase.app.community

import scommons.react.navigation._
import scommons.react.test._
import scommons.reactnative._
import showcase.app.community.SvgDemo._

class SvgDemoSpec extends TestSpec
  with BaseTestSpec
  with ShallowRendererUtils {

  it should "render component" in {
    //given
    val component = <(SvgDemo())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    implicit val theme: Theme = DefaultTheme
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.Text(themeStyle(styles.title, themeTextStyle))("SvgXml:"),
        <(SvgXmlDemo())()(),

        <.Text(themeStyle(styles.title, themeTextStyle))("SvgCss:"),
        <(SvgCssDemo())()()
      )
    )
  }
}
