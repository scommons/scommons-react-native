package scommons.reactnative.safearea

import org.scalamock.scalatest.MockFactory
import org.scalatest._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import scommons.reactnative.safearea.SafeArea.{SafeAreaEdge, SafeAreaMode}
import scommons.reactnative.safearea.SafeAreaSpec._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportAll

class SafeAreaSpec extends AnyFlatSpec
  with Matchers
  with Inside
  with MockFactory {

  it should "return native result when useSafeAreaInsets" in {
    //given
    val useSafeAreaInsetsMock = mockFunction[SafeAreaInsets]
    val sa = new TestSafeArea(createSafeArea(useSafeAreaInsetsMock))
    val insetsMock = mock[SafeAreaInsetsMock]
    val insets = insetsMock.asInstanceOf[SafeAreaInsets]
    
    useSafeAreaInsetsMock.expects().returning(insets)
    
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

  def createSafeArea(useSafeAreaInsetsMock: () => SafeAreaInsets): raw.SafeArea = {
    js.Dynamic.literal(
      "useSafeAreaInsets" -> (useSafeAreaInsetsMock: js.Function)
    ).asInstanceOf[raw.SafeArea]
  }

  @JSExportAll
  trait SafeAreaInsetsMock
  
  class TestSafeArea(mock: raw.SafeArea) extends SafeArea {
    protected def native: raw.SafeArea = mock
  }
}
