package showcase

import scommons.react.test._
import scommons.react.test.dom._
import scommons.reactnative._
import showcase.ImageDemo.styles
import showcase.app.ShowcaseImages

class ImageDemoSpec extends AsyncTestSpec
  with ShallowRendererUtils
  with TestRendererUtils {

  it should "render second image asynchronously" in {
    //when
    val result = testRender(<(ImageDemo())()())

    //then
    eventually {
      assertNativeComponent(result,
        <.View(^.rnStyle := styles.container)(
          <.Image(
            ^.source := ShowcaseImages.User.Resource,
            ^.rnStyle := new Style {
              override val width = 50
              override val height = 50
            }
          )(),
          
          <.Image(
            ^.source := new UriResource {
              override val uri = "test/asset/uri"
            },
            ^.rnStyle := new Style {
              override val width = 50
              override val height = 50
            }
          )()
        )
      )
    }
  }

  it should "render initial component" in {
    //given
    val component = <(ImageDemo())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.Image(
          ^.source := ShowcaseImages.User.Resource,
          ^.rnStyle := new Style {
            override val width = 50
            override val height = 50
          }
        )()
      )
    )
  }
}
