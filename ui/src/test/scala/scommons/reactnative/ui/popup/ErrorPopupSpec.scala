package scommons.reactnative.ui.popup

import scommons.nodejs.test.AsyncTestSpec
import scommons.react.test.{BaseTestSpec, TestRendererUtils}
import scommons.reactnative.Alert._
import scommons.reactnative._
import scommons.reactnative.raw.{Alert => NativeAlert}
import scommons.reactnative.ui.popup.ErrorPopupSpec.setAlertMock

import scala.scalajs.js

class ErrorPopupSpec extends AsyncTestSpec
  with BaseTestSpec
  with TestRendererUtils {

  it should "show and close simple error alert" in {
    //given
    val onClose = mockFunction[Unit]
    val alertMock = mockFunction[String, String, js.Array[raw.AlertButton], raw.AlertOptions, Unit]
    setAlertMock(alertMock)
    val props = ErrorPopupProps("Test error", onClose = onClose)
    var testFinish = false
    
    //then
    onClose.expects()
    alertMock.expects(*, *, *, *).onCall { (title, message, buttons, options) =>
      //then
      title shouldBe "Error"
      message shouldBe "Test error"
      options.cancelable shouldBe false
      
      val closeBtn = inside(buttons.toList) {
        case List(btn) => btn
      }
      closeBtn.text shouldBe "Close"
      closeBtn.style shouldBe AlertButtonStyle.cancel
      
      //when
      closeBtn.onPress()
      
      //then
      testFinish = true
    }

    //when
    testRender(<(ErrorPopup())(^.wrapped := props)())
    
    //then
    eventually {
      testFinish shouldBe true
    }
  }
  
  it should "show and close error alert with Details button" in {
    //given
    val onClose = mockFunction[Unit]
    val alertMock = mockFunction[String, String, js.Array[raw.AlertButton], raw.AlertOptions, Unit]
    setAlertMock(alertMock)
    val props = ErrorPopupProps("Test error", onClose = onClose, details = Some("Test details"))
    var testFinish = false
    
    //then
    onClose.expects()
    alertMock.expects(*, *, *, *).onCall { (title, message, buttons, options) =>
      //then
      title shouldBe "Error"
      message shouldBe "Test error"
      options.cancelable shouldBe false
      
      val (detailsBtn, closeBtn) = inside(buttons.toList) {
        case List(detailsBtn, closeBtn) => (detailsBtn, closeBtn)
      }
      detailsBtn.text shouldBe "Details"
      detailsBtn.style shouldBe js.undefined
      
      closeBtn.text shouldBe "Close"
      closeBtn.style shouldBe AlertButtonStyle.cancel
      
      //when
      closeBtn.onPress()
      
      //then
      testFinish = true
    }

    //when
    testRender(<(ErrorPopup())(^.wrapped := props)())

    //then
    eventually {
      testFinish shouldBe true
    }
  }
  
  it should "show error details alert when press Details button" in {
    //given
    val onClose = mockFunction[Unit]
    val alertMock = mockFunction[String, String, js.Array[raw.AlertButton], raw.AlertOptions, Unit]
    setAlertMock(alertMock)
    val props = ErrorPopupProps("Test error", onClose = onClose, details = Some("Test details"))
    var testFinish = false
    
    //then
    onClose.expects()
    alertMock.expects(*, *, *, *).onCall { (title, message, buttons, options) =>
      //then
      title shouldBe "Error"
      message shouldBe "Test error"
      options.cancelable shouldBe false

      val (detailsBtn, closeBtn) = inside(buttons.toList) {
        case List(detailsBtn, closeBtn) => (detailsBtn, closeBtn)
      }
      detailsBtn.text shouldBe "Details"
      detailsBtn.style shouldBe js.undefined

      closeBtn.text shouldBe "Close"
      closeBtn.style shouldBe AlertButtonStyle.cancel

      //when
      detailsBtn.onPress()
    }
    alertMock.expects(*, *, *, *).onCall { (title, message, buttons, options) =>
      //then
      title shouldBe "Error"
      message shouldBe "Test error\n\nTest details"
      options.cancelable shouldBe false
      
      val closeBtn = inside(buttons.toList) {
        case List(btn) => btn
      }
      closeBtn.text shouldBe "Close"
      closeBtn.style shouldBe AlertButtonStyle.cancel
      
      //when
      closeBtn.onPress()
      
      //then
      testFinish = true
    }

    //when
    testRender(<(ErrorPopup())(^.wrapped := props)())

    //then
    eventually {
      testFinish shouldBe true
    }
  }
}

object ErrorPopupSpec {

  def setAlertMock(alertMock: (String, String, js.Array[raw.AlertButton], raw.AlertOptions) => Unit): Unit = {
    NativeAlert.asInstanceOf[js.Dynamic].updateDynamic("alert")(alertMock: js.Function)
  }
}
