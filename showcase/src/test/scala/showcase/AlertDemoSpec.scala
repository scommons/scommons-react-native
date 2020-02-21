package showcase

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative.Alert.AlertButtonStyle
import scommons.reactnative._
import scommons.reactnative.raw.{Alert => NativeAlert}
import showcase.AlertDemo.styles
import showcase.AlertDemoSpec.AlertMock

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportAll

class AlertDemoSpec extends TestSpec with ShallowRendererUtils {

  it should "call alert() and okHandler when press 2-Button Alert and OK button" in {
    //given
    val alert = mock[AlertMock]
    NativeAlert.asInstanceOf[js.Dynamic].updateDynamic("alert")(alert.alert _)
    val okHandler = mockFunction[Unit]
    AlertDemo.okHandler = okHandler
    val renderer = createRenderer()
    renderer.render(<(AlertDemo())()())
    val List(showAlert, _) = findComponents(renderer.getRenderOutput(), raw.Button)

    //then
    okHandler.expects()
    
    (alert.alert _).expects(*, *, *, *).onCall { (title, message, buttons, options) =>
      //then
      title shouldBe "Alert Title"
      message shouldBe "My Alert Msg"

      inside(buttons.toList) { case List(cancel, ok) =>
        cancel.text shouldBe "Cancel"
        cancel.style shouldBe AlertButtonStyle.cancel
        
        ok.text shouldBe "OK"
        ok.style shouldBe js.undefined
        //when
        ok.onPress()
      }
      
      options.cancelable shouldBe false
    }
    
    //when
    showAlert.props.onPress()
  }

  it should "render component" in {
    //given
    val component = <(AlertDemo())()()

    //when
    val result = shallowRender(component)

    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.Button(^.title := "2-Button Alert", ^.color := "#0000ff")(),
        <.Button(^.title := "3-Button Alert", ^.color := "#0000ff")()
      )
    )
  }

  it should "provide AlertButtonStyle enum" in {
    //when & then
    AlertButtonStyle.default shouldBe "default"
    AlertButtonStyle.cancel shouldBe "cancel"
    AlertButtonStyle.destructive shouldBe "destructive"
  }
}

object AlertDemoSpec {

  @JSExportAll
  trait AlertMock {
    
    def alert(title: String,
              message: String,
              buttons: js.Array[raw.AlertButton],
              options: raw.AlertOptions
             ): Unit
  }
}
