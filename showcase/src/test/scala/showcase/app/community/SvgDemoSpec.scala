package showcase.app.community

import scommons.react.navigation._
import scommons.react.test._
import scommons.reactnative._
import showcase.app.community.SvgDemo._

class SvgDemoSpec extends TestSpec with TestRendererUtils {

  SvgDemo.svgXmlDemoComp = mockUiComponent("SvgXmlDemo")
  SvgDemo.svgCssDemoComp = mockUiComponent("SvgCssDemo")

  it should "render component" in {
    //given
    val component = <(SvgDemo())()()
    
    //when
    val result = testRender(component)
    
    //then
    implicit val theme: Theme = DefaultTheme
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.Text(themeStyle(styles.title, themeTextStyle))("SvgXml:"),
        <(svgXmlDemoComp())()(),

        <.Text(themeStyle(styles.title, themeTextStyle))("SvgCss:"),
        <(svgCssDemoComp())()()
      )
    )
  }
}
