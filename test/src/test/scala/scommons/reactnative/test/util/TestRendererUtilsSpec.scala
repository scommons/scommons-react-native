package scommons.reactnative.test.util

import io.github.shogowada.scalajs.reactjs.React
import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.scalajs.reactjs.classes.ReactClass
import org.scalatest.{Failed, OutcomeOf}
import scommons.react.UiComponent
import scommons.react.test.TestSpec
import scommons.reactnative.test.util.TestRendererUtilsSpec._

class TestRendererUtilsSpec extends TestSpec
  with TestRendererUtils
  with OutcomeOf {

  it should "return top child instance when render" in {
    //when
    val comp = render(<(TestComp())(^.wrapped := Comp1Props(1))("test1 child"))

    //then
    assertNativeComponent(comp, <.p(^.className := "test1")(), { case List(child) =>
      child shouldBe "test1 child"
    })
  }

  it should "fail if comp not found when findComponentProps" in {
    //given
    val comp = render(<(emptyComp)()())
    val searchComp = TestComp

    //when
    val e = the[IllegalStateException] thrownBy {
      findComponentProps(comp, searchComp)
    }

    //then
    e.getMessage shouldBe s"UiComponent $searchComp not found"
  }

  it should "return props when findComponentProps" in {
    //given
    val comp = render(<(comp2Class)()())

    //when
    val result = findComponentProps(comp, TestComp)

    //then
    result shouldBe Comp1Props(1)
  }

  it should "return components props when findProps" in {
    //given
    val comp = render(<(comp2Class)()())

    //when
    val result = findProps(comp, TestComp)

    //then
    result shouldBe List(
      Comp1Props(1),
      Comp1Props(2)
    )
  }

  it should "return wrapped props when getComponentProps" in {
    //given
    val props = Comp1Props(1)
    val root = createRenderer(<(TestComp())(^.wrapped := props)("test1 child")).root
    
    //when
    val result = getComponentProps[Comp1Props](root)

    //then
    result shouldBe props
  }

  it should "not find component when findComponents" in {
    //given
    val comp = render(<(TestComp())(^.wrapped := Comp1Props(123))())

    //when & then
    findComponents(comp, TestComp()) shouldBe Nil
    findComponents(comp, comp2Class) shouldBe Nil
  }

  it should "find all components when findComponents" in {
    //given
    val comp = render(<(comp2Class)(^.wrapped := Comp2Props(true))())

    //when
    val results = findComponents(comp, TestComp())

    //then
    results.map(getComponentProps[Comp1Props]) shouldBe List(Comp1Props(1), Comp1Props(2))
  }

  it should "not fail if non-empty when assertComponent" in {
    //given
    val comp = render(<(comp2Class)(^.wrapped := Comp2Props(true))())

    //when
    assertNativeComponent(comp, <.div(^.className := "test2")(), { case List(comp1, _) =>
      assertComponent(comp1, TestComp) { props: Comp1Props =>
        props shouldBe Comp1Props(1)
      }
    })
  }

  it should "assert props and children when assertComponent" in {
    //given
    val comp = render(<(comp2Class)(^.wrapped := Comp2Props(true))())

    //when & then
    assertNativeComponent(comp, <.div(^.className := "test2")(), { case List(comp1, comp2) =>
      assertComponent(comp1, TestComp)({ props =>
        props shouldBe Comp1Props(1)
      }, { case List(child) =>
        assertNativeComponent(child, <.p(^.className := "test1")("test2 child1"))
      })

      assertComponent(comp2, TestComp)({ props =>
        props shouldBe Comp1Props(2)
      }, { case List(child) =>
        assertNativeComponent(child, <.p(^.className := "test1")("test2 child2"))
      })
    })
  }

  it should "fail if non-empty when assertNativeComponent" in {
    //given
    val comp = render(<(TestComp())(^.wrapped := Comp1Props(1))("test1 child"))

    //when
    val Failed(e) = outcomeOf {
      assertNativeComponent(comp, <.p(^.className := "test1")())
    }

    //then
    e.getMessage should include ("""List("test1 child") was not equal to List()""")
  }

  it should "assert props and children when assertNativeComponent" in {
    //given
    val id = System.currentTimeMillis().toString
    val compClass = React.createClass[Unit, Unit] { _ =>
      <.div(
        ^.className := "test1 test2",
        ^.style := Map("display" -> "none"),
        ^.id := id,
        ^.hidden := true,
        ^.height := 10
      )(
        <.div()("child1"),
        <.div()("child2")
      )
    }
    val comp = render(<(compClass)()())

    //when & then
    assertNativeComponent(comp, <.div(
      ^.className := "test1 test2",
      ^.style := Map("display" -> "none"),
      ^.id := id,
      ^.hidden := true,
      ^.height := 10
    )(
      <.div()("child1"),
      <.div()("child2")
    ))
  }
}

object TestRendererUtilsSpec {

  case class Comp1Props(a: Int)
  case class Comp2Props(b: Boolean)

  object TestComp extends UiComponent[Comp1Props] {

    protected def create(): ReactClass = React.createClass[Comp1Props, Unit] { self =>
      <.p(^.className := "test1")(self.props.children)
    }
  }

  private val emptyComp = React.createClass[Comp1Props, Unit] { _ =>
    <.div.empty
  }

  private val comp2Class = React.createClass[Comp2Props, Unit] { _ =>
    <.div(^.className := "test2")(
      <(TestComp())(^.wrapped := Comp1Props(1))("test2 child1"),
      <(TestComp())(^.wrapped := Comp1Props(2))("test2 child2")
    )
  }
}
