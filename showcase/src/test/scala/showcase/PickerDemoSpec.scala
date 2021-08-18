package showcase

import scommons.react.navigation._
import scommons.react.test._
import scommons.reactnative._
import showcase.PickerDemo.styles

class PickerDemoSpec extends TestSpec with TestRendererUtils {

  it should "set selectedValue when onValueChange" in {
    //given
    val renderer = createTestRenderer(<(PickerDemo())()())
    val List(picker) = findComponents(renderer.root, <.Picker.reactClass)
    picker.props.selectedValue shouldBe "1"
    
    //when
    picker.props.onValueChange("2", 1)
    
    //then
    val List(updated) = findComponents(renderer.root, <.Picker.reactClass)
    updated.props.selectedValue shouldBe "2"
  }
  
  it should "render component" in {
    //given
    val component = <(PickerDemo())()()

    //when
    val result = testRender(component)

    //then
    assertNativeComponent(result,
      <.Picker(
        ^.selectedValue := "1",
        ^.rnStyle := styles.picker
      )(
        <.PickerItem(^.color := DefaultTheme.colors.primary, ^.label := "Java", ^.value := 1)(),
        <.PickerItem(^.color := DefaultTheme.colors.primary, ^.label := "JavaScript", ^.value := 2)()
      )
    )
  }
}
