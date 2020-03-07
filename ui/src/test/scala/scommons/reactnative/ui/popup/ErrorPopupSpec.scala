package scommons.reactnative.ui.popup

import scommons.react.test.dom.AsyncTestSpec
import scommons.react.test.util.TestRendererUtils
import scommons.reactnative.Alert._
import scommons.reactnative._
import scommons.reactnative.raw.{Alert => NativeAlert}
import scommons.reactnative.ui.popup.ErrorPopupSpec.AlertMock

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportAll

class ErrorPopupSpec extends AsyncTestSpec with TestRendererUtils {

  it should "show and close simple error alert" in {
    //given
    val onClose = mockFunction[Unit]
    val alert = mock[AlertMock]
    NativeAlert.asInstanceOf[js.Dynamic].updateDynamic("alert")(alert.alert _)
    val props = ErrorPopupProps("Test error", onClose = onClose)
    var testFinish = false
    
    //then
    onClose.expects()
    (alert.alert _).expects("Error", "Test error", *, *).onCall { (_, _, buttons, options) =>
      //then
      options.cancelable shouldBe false
      
      val List(closeBtn) = buttons.toList
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
    val alert = mock[AlertMock]
    NativeAlert.asInstanceOf[js.Dynamic].updateDynamic("alert")(alert.alert _)
    val props = ErrorPopupProps("Test error", onClose = onClose, details = Some("Test details"))
    var testFinish = false
    
    //then
    onClose.expects()
    (alert.alert _).expects("Error", "Test error", *, *).onCall { (_, _, buttons, options) =>
      //then
      options.cancelable shouldBe false
      
      val List(detailsBtn, closeBtn) = buttons.toList
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
    val alert = mock[AlertMock]
    NativeAlert.asInstanceOf[js.Dynamic].updateDynamic("alert")(alert.alert _)
    val props = ErrorPopupProps("Test error", onClose = onClose, details = Some("Test details"))
    var testFinish = false
    
    //then
    onClose.expects()
    (alert.alert _).expects("Error", "Test error", *, *).onCall { (_, _, buttons, options) =>
      //then
      options.cancelable shouldBe false

      val List(detailsBtn, closeBtn) = buttons.toList
      detailsBtn.text shouldBe "Details"
      detailsBtn.style shouldBe js.undefined

      closeBtn.text shouldBe "Close"
      closeBtn.style shouldBe AlertButtonStyle.cancel

      //when
      detailsBtn.onPress()
    }
    (alert.alert _).expects("Error", "Test error\n\nTest details", *, *).onCall { (_, _, buttons, options) =>
      //then
      options.cancelable shouldBe false
      
      val List(closeBtn) = buttons.toList
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

  @JSExportAll
  trait AlertMock {

    def alert(title: String,
              message: String,
              buttons: js.Array[raw.AlertButton],
              options: raw.AlertOptions
             ): Unit
  }
}
