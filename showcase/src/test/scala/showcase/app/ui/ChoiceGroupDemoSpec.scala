package showcase.app.ui

import showcase.app.ui.ChoiceGroupDemo._
import scommons.react._
import scommons.react.navigation._
import scommons.react.test._
import scommons.reactnative._
import scommons.reactnative.ui._

class ChoiceGroupDemoSpec extends TestSpec with TestRendererUtils {

  ChoiceGroupDemo.customChoiceGroupComp = () => "CustomChoiceGroup".asInstanceOf[ReactClass]
  ChoiceGroupDemo.choiceGroupComp = () => "ChoiceGroup".asInstanceOf[ReactClass]

  it should "select single item when single select" in {
    //given
    val singleSelectComp = choiceGroupComp
    val renderer = createTestRenderer(<(ChoiceGroupDemo())()())
    val choiceComp = findComponentProps(renderer.root, singleSelectComp)

    //when & then
    choiceComp.onSelectChange(Set("1"))
    inside(findComponentProps(renderer.root, singleSelectComp)) { case choice1 =>
      choice1.selectedIds shouldBe Set("1")
    
      //when & then
      choice1.onSelectChange(Set("2"))
      inside(findComponentProps(renderer.root, singleSelectComp)) { case choice2 =>
        choice2.selectedIds shouldBe Set("2")
      }
    }
  }

  it should "select multiple items when multi select" in {
    //given
    val multiSelectComp = customChoiceGroupComp
    val renderer = createTestRenderer(<(ChoiceGroupDemo())()())
    val choiceComp = findComponentProps(renderer.root, multiSelectComp)

    //when & then
    choiceComp.onSelectChange(Set(1))
    inside(findComponentProps(renderer.root, multiSelectComp)) { case choice1 =>
      choice1.selectedIds shouldBe Set(1)
    
      //when & then
      choice1.onSelectChange(Set(1, 2))
      inside(findComponentProps(renderer.root, multiSelectComp)) { case choice2 =>
        choice2.selectedIds shouldBe Set(1, 2)
      }
    }
  }

  it should "render initial component" in {
    //given
    val component = <(ChoiceGroupDemo())()()

    //when
    val result = testRender(component)

    //then
    assertChoiceGroup(result)
  }
  
  private def assertChoiceGroup(result: TestInstance): Unit = {
    implicit val theme: Theme = DefaultTheme
    
    assertNativeComponent(result, <.View(^.rnStyle := styles.container)(), { case List(t1, c1, t2, c2) =>
      assertNativeComponent(t1, <.Text(themeStyle(styles.title, themeTextStyle))(
        "Single-select (simple):"
      ))

      assertTestComponent(c1, choiceGroupComp) {
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
      
      assertNativeComponent(t2, <.Text(themeStyle(styles.title, themeTextStyle))(
        "Multi-select (with custom data):"
      ))

      assertTestComponent(c2, customChoiceGroupComp) {
        case ChoiceGroupProps(items, keyExtractor, _, labelRenderer, selectedIds, _, multiSelect, style) =>
          val data = ChoiceData(1, "option 1", 0.1)
          
          items shouldBe List(data, ChoiceData(2, "option 2", 0.2))
          keyExtractor(data) shouldBe 1

          assertNativeComponent(wrapAndRender(labelRenderer(data, theme)),
            <.Text(themeStyle(styles.label, themeTextStyle))(data.name)
          )
          
          selectedIds shouldBe Set.empty
          multiSelect shouldBe true
          style shouldBe Some(styles.choiceGroup)
      }
    })
  }

  private def wrapAndRender(element: ReactElement): TestInstance = {
    val wrapper = new FunctionComponent[Unit] {
      protected def render(props: Props): ReactElement = {
        element
      }
    }.apply()

    testRender(<(wrapper)()())
  }
}
