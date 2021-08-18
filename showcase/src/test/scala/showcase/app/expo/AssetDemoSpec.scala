package showcase.app.expo

import scommons.nodejs.test.AsyncTestSpec
import scommons.react.navigation._
import scommons.react.test._
import scommons.reactnative._
import showcase.app.ShowcaseImages
import showcase.app.expo.AssetDemo.styles

class AssetDemoSpec extends AsyncTestSpec
  with BaseTestSpec
  with TestRendererUtils {

  it should "load asset asynchronously when mount" in {
    //when
    val result = testRender(<(AssetDemo())()())
    
    //then
    implicit val theme: Theme = DefaultTheme
    eventually {
      assertNativeComponent(result,
        <.View(^.rnStyle := styles.container)(
          <.Image(
            ^.source := ShowcaseImages.Expo.Resource,
            ^.rnStyle := new Style {
              override val width = 50
              override val height = 50
            }
          )(),

          <.Text(^.rnStyle := themeTextStyle)(
            s"""Asset props:
               |name: test
               |type: asset
               |width: 50
               |height: 50
               |""".stripMargin
          )
        )
      )
    }
  }
  
  it should "render initial component" in {
    //given
    val component = <(AssetDemo())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)()
    )
  }
}
