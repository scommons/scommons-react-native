package showcase.app.ui

import showcase.app.ui.ChoiceGroupDemo._
import scommons.react._
import scommons.react.test._
import scommons.reactnative._
import scommons.reactnative.ui._

class ChoiceGroupDemoSpec extends TestSpec
  with BaseTestSpec
  with ShallowRendererUtils {

  it should "select single item when single select" in {
    //given
    val singleSelectComp = ChoiceGroup
    val renderer = createRenderer()
    renderer.render(<(ChoiceGroupDemo())()())
    val choiceComp = findComponentProps(renderer.getRenderOutput(), singleSelectComp)

    //when & then
    choiceComp.onSelectChange(Set("1"))
    inside(findComponentProps(renderer.getRenderOutput(), singleSelectComp)) { case choice1 =>
      choice1.selectedIds shouldBe Set("1")
    
      //when & then
      choice1.onSelectChange(Set("2"))
      inside(findComponentProps(renderer.getRenderOutput(), singleSelectComp)) { case choice2 =>
        choice2.selectedIds shouldBe Set("2")
      }
    }
  }

  it should "select multiple items when multi select" in {
    //given
    val multiSelectComp = choiceGroupComp
    val renderer = createRenderer()
    renderer.render(<(ChoiceGroupDemo())()())
    val choiceComp = findComponentProps(renderer.getRenderOutput(), multiSelectComp)

    //when & then
    choiceComp.onSelectChange(Set(1))
    inside(findComponentProps(renderer.getRenderOutput(), multiSelectComp)) { case choice1 =>
      choice1.selectedIds shouldBe Set(1)
    
      //when & then
      choice1.onSelectChange(Set(1, 2))
      inside(findComponentProps(renderer.getRenderOutput(), multiSelectComp)) { case choice2 =>
        choice2.selectedIds shouldBe Set(1, 2)
      }
    }
  }

  it should "render initial component" in {
    //given
    val component = <(ChoiceGroupDemo())()()

    //when
    val result = shallowRender(component)

    //then
    assertChoiceGroup(result)
  }
  
  private def assertChoiceGroup(result: ShallowInstance): Unit = {
    assertNativeComponent(result, <.View(^.rnStyle := styles.container)(), { case List(t1, c1, t2, c2) =>
      assertNativeComponent(t1, <.Text(^.rnStyle := styles.title)("Single-select (simple):"))

      assertComponent(c1, ChoiceGroup) {
        case ChoiceGroupProps(items, keyExtractor, _, _, selectedIds, _, multiSelect, style) =>
          items shouldBe List(
            ChoiceItemData("1", "item1"),
            ChoiceItemData("2", "item2")
          )
          keyExtractor(ChoiceItemData("1", "item1")) shouldBe "1"
          selectedIds shouldBe Set.empty
          multiSelect shouldBe false
          style shouldBe Some(styles.choiceGroup)
      }
      
      assertNativeComponent(t2, <.Text(^.rnStyle := styles.title)("Multi-select (with custom data):"))

      assertComponent(c2, choiceGroupComp) {
        case ChoiceGroupProps(items, keyExtractor, _, labelRenderer, selectedIds, _, multiSelect, style) =>
          val data = ChoiceData(1, "option 1", 0.1)
          
          items shouldBe List(data, ChoiceData(2, "option 2", 0.2))
          keyExtractor(data) shouldBe 1

          assertNativeComponent(wrapAndRender(labelRenderer(data)),
            <.Text(^.rnStyle := styles.label)(data.name)
          )
          
          selectedIds shouldBe Set.empty
          multiSelect shouldBe true
          style shouldBe Some(styles.choiceGroup)
      }
    })
  }

  private def wrapAndRender(element: ReactElement): ShallowInstance = {
    val wrapper = new FunctionComponent[Unit] {
      protected def render(props: Props): ReactElement = {
        element
      }
    }.apply()

    shallowRender(<(wrapper)()())
  }
}
