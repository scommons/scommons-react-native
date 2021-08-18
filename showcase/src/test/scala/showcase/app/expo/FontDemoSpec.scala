package showcase.app.expo

import scommons.nodejs.test.AsyncTestSpec
import scommons.react.navigation._
import scommons.react.test._
import scommons.reactnative._
import showcase.app.expo.FontDemo.styles

class FontDemoSpec extends AsyncTestSpec
  with BaseTestSpec
  with TestRendererUtils {

  it should "load font asynchronously when mount" in {
    //when
    val result = testRender(<(FontDemo())()())
    
    //then
    eventually {
      assertNativeComponent(result,
        <.View(^.rnStyle := styles.container)(
          <.Text(^.rnStyle := new TextStyle {
            override val fontFamily = "Montserrat-Black"
            override val color = DefaultTheme.colors.text
          })(
            "Font: Montserrat-Black"
          )
        )
      )
    }
  }
  
  it should "render initial component" in {
    //given
    val component = <(FontDemo())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)()
    )
  }
}
