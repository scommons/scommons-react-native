package scommons.reactnative.safearea

import org.scalamock.scalatest.MockFactory
import org.scalatest._
import scommons.reactnative.safearea.SafeArea._
import scommons.reactnative.safearea.SafeAreaSpec._

import scala.scalajs.js.annotation.JSExportAll

class SafeAreaSpec extends FlatSpec
  with Matchers
  with Inside
  with MockFactory {

  it should "return native result when useSafeAreaInsets" in {
    //given
    val nativeMock = mock[SafeAreaMock]
    val sa = TestSafeArea(nativeMock.asInstanceOf[raw.SafeArea])
    val insetsMock = mock[SafeAreaInsetsMock]
    val insets = insetsMock.asInstanceOf[SafeAreaInsets]
    
    (nativeMock.useSafeAreaInsets _).expects().returning(insets)
    
    //when & then
    sa.useSafeAreaInsets() should be theSameInstanceAs insets
  }

  it should "provide SafeAreaMode enum" in {
    //when & then
    SafeAreaMode.padding shouldBe "padding"
    SafeAreaMode.margin shouldBe "margin"
  }
  
  it should "provide SafeAreaEdge enum" in {
    //when & then
    SafeAreaEdge.top shouldBe "top"
    SafeAreaEdge.left shouldBe "left"
    SafeAreaEdge.bottom shouldBe "bottom"
    SafeAreaEdge.right shouldBe "right"
  }
}

object SafeAreaSpec {

  @JSExportAll
  trait SafeAreaMock {

    def useSafeAreaInsets(): SafeAreaInsets
  }

  @JSExportAll
  trait SafeAreaInsetsMock
  
  case class TestSafeArea(mock: raw.SafeArea) extends SafeArea {
    protected def native: raw.SafeArea = mock
  }
}
