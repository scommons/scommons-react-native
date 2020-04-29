package showcase.app.expo

import scommons.react.test._
import scommons.react.test.dom._
import scommons.reactnative._
import showcase.app.ShowcaseImages
import showcase.app.expo.AssetDemo.styles

class AssetDemoSpec extends AsyncTestSpec
  with ShallowRendererUtils
  with TestRendererUtils {

  it should "load asset asynchronously when mount" in {
    //when
    val result = testRender(<(AssetDemo())()())
    
    //then
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

          <.Text()("Asset props:"),
          <.Text()(s"name: test"),
          <.Text()(s"type: asset"),
          <.Text()(s"width: 50"),
          <.Text()(s"height: 50")
        )
      )
    }
  }
  
  it should "render initial component" in {
    //given
    val component = <(AssetDemo())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)()
    )
  }
}
