package showcase

import scommons.react.test.TestSpec
import scommons.react.test.util.TestRendererUtils
import scommons.reactnative.Alert.AlertButtonStyle
import scommons.reactnative._
import scommons.reactnative.raw.{Alert => NativeAlert}
import showcase.AlertDemo.styles
import showcase.AlertDemoSpec.setAlertMock

import scala.scalajs.js

class AlertDemoSpec extends TestSpec with TestRendererUtils {

  it should "call alert() and okHandler when press 2-Button Alert and OK button" in {
    //given
    val alertMock = mockFunction[String, String, js.Array[raw.AlertButton], raw.AlertOptions, Unit]
    setAlertMock(alertMock)
    val okHandler = mockFunction[Unit]
    AlertDemo.okHandler = okHandler
    val comp = testRender(<(AlertDemo())()())
    val showAlert = inside(findComponents(comp, raw.Button)) {
      case List(showAlert, _) => showAlert
    }

    //then
    okHandler.expects()
    
    alertMock.expects(*, *, *, *).onCall { (title, message, buttons, options) =>
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
    val result = testRender(component)

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

  def setAlertMock(alertMock: (String, String, js.Array[raw.AlertButton], raw.AlertOptions) => Unit): Unit = {
    NativeAlert.asInstanceOf[js.Dynamic].updateDynamic("alert")(alertMock: js.Function)
  }
}
