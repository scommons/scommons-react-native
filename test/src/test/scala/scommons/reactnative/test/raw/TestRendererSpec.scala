package scommons.reactnative.test.raw

import io.github.shogowada.scalajs.reactjs.React
import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import scommons.react.test.TestSpec

class TestRendererSpec extends TestSpec {

  it should "render and mount component" in {
    //given
    var isMounted = false
    val compClass = React.createClass[Unit, Unit](
      componentDidMount = { _ =>
        isMounted = true
      },
      render = { _ =>
        <.div(^("testProp") := "test")(
          <.span()("Test")
        )
      }
    )
    
    //when
    val result = TestRenderer.create(<(compClass)()()).root
    
    //then
    isMounted shouldBe true
    result.`type` shouldBe compClass
    
    val container = result.children(0)
    container.`type` shouldBe "div"
    container.props.testProp shouldBe "test"
  }
  
  it should "update component" in {
    //given
    var isUpdated = false
    val compClass = React.createClass[Unit, Unit](
      componentDidUpdate = { (_, _, _) =>
        isUpdated = true
      },
      render = { self =>
        <.div(^("testProp") := self.props.native.test.asInstanceOf[String])(
          <.span()("Test")
        )
      }
    )
    val renderer = TestRenderer.create(<(compClass)(^("test") := "test")())
    isUpdated shouldBe false
    
    //when
    renderer.update(<(compClass)(^("test") := "updated")())
    
    //then
    val result = renderer.root
    isUpdated shouldBe true
    result.`type` shouldBe compClass
    
    val container = result.children(0)
    container.`type` shouldBe "div"
    container.props.testProp shouldBe "updated"
  }
  
  it should "unmount component" in {
    //given
    var isUnmounted = false
    val compClass = React.createClass[Unit, Unit](
      componentWillUnmount = { _ =>
        isUnmounted = true
      },
      render = { _ =>
        <.div(^("testProp") := "test")(
          <.span()("Test")
        )
      }
    )
    val renderer = TestRenderer.create(<(compClass)()())
    isUnmounted shouldBe false
    
    //when
    renderer.unmount()
    
    //then
    isUnmounted shouldBe true
  }
}
