package scommons.reactnative.ui

import scommons.expo._
import scommons.react._
import scommons.react.navigation._
import scommons.react.test._
import scommons.reactnative._

import scala.scalajs.js

class ChoiceGroupSpec extends TestSpec with ShallowRendererUtils {

  private lazy val items = List(
    ChoiceItemData("1", "item1"),
    ChoiceItemData("2", "item2"),
    ChoiceItemData("3", "item3")
  )
  
  it should "call onSelectChange when single select" in {
    //given
    val onSelectChange = mockFunction[Set[String], Unit]
    val props = ChoiceGroupProps(items, selectedIds = Set("2"), onSelectChange = onSelectChange)
    val comp = shallowRender(<(ChoiceGroup())(^.wrapped := props)())
    val touch = findComponents(comp, <.TouchableOpacity.reactClass).head

    //then
    onSelectChange.expects(Set("1"))
    
    //when
    touch.props.onPress()
  }
  
  it should "not call onSelectChange if already selected when single select" in {
    //given
    val onSelectChange = mockFunction[Set[String], Unit]
    val props = ChoiceGroupProps(items, selectedIds = Set("1"), onSelectChange = onSelectChange)
    val comp = shallowRender(<(ChoiceGroup())(^.wrapped := props)())
    val touch = findComponents(comp, <.TouchableOpacity.reactClass).head

    //then
    onSelectChange.expects(*).never()
    
    //when
    touch.props.onPress()
  }
  
  it should "call onSelectChange and select item when multi select" in {
    //given
    val onSelectChange = mockFunction[Set[String], Unit]
    val props = ChoiceGroupProps(
      items = items,
      selectedIds = Set("2"),
      onSelectChange = onSelectChange,
      multiSelect = true
    )
    val comp = shallowRender(<(ChoiceGroup())(^.wrapped := props)())
    val touch = findComponents(comp, <.TouchableOpacity.reactClass).head

    //then
    onSelectChange.expects(Set("1", "2"))
    
    //when
    touch.props.onPress()
  }
  
  it should "call onSelectChange and un-select if already selected when multi select" in {
    //given
    val onSelectChange = mockFunction[Set[String], Unit]
    val props = ChoiceGroupProps(
      items,
      selectedIds = Set("1", "2"),
      onSelectChange = onSelectChange,
      multiSelect = true
    )
    val comp = shallowRender(<(ChoiceGroup())(^.wrapped := props)())
    val touch = findComponents(comp, <.TouchableOpacity.reactClass).head

    //then
    onSelectChange.expects(Set("2"))
    
    //when
    touch.props.onPress()
  }
  
  it should "render single select component" in {
    //given
    val props = ChoiceGroupProps(items, selectedIds = Set("1"), style = Some(new Style {}))
    val component = <(ChoiceGroup())(^.wrapped := props)()

    //when
    val result = shallowRender(component)

    //then
    assertChoiceGroup(result, props)
  }
  
  it should "render multi select component" in {
    //given
    val props = ChoiceGroupProps(items, selectedIds = Set("2", "3"), multiSelect = true)
    val component = <(ChoiceGroup())(^.wrapped := props)()

    //when
    val result = shallowRender(component)

    //then
    assertChoiceGroup(result, props)
  }
  
  private def assertChoiceGroup(result: ShallowInstance,
                                props: ChoiceGroupProps[String, ChoiceItemData]): Unit = {

    implicit val theme: Theme = DefaultTheme
    val multiSelect = props.multiSelect
    
    def renderItem(data: ChoiceItemData, top: Boolean = false): ReactElement = {
      val key = props.keyExtractor(data)
      val isSelected = props.selectedIds.contains(key)

      <.TouchableOpacity(
        ^.key := s"$key",
        if (!top) {
          ^.rnStyle := js.Array(ChoiceGroup.styles.item, ChoiceGroup.styles.nonTopItem)
        }
        else ^.rnStyle := ChoiceGroup.styles.item
      )(
        <(VectorIcons.Ionicons)(
          ^.name := {
            if (multiSelect) {
              if (isSelected) "md-checkbox-outline"
              else "md-square-outline"
            }
            else {
              if (isSelected) "md-radio-button-on"
              else "md-radio-button-off"
            }
          },
          ^.rnSize := 24,
          ^.color := theme.colors.primary
        )(),
        <.Text(themeStyle(ChoiceGroup.styles.label, themeTextStyle))(data.text)
      )
    }

    val List(item1, item2, item3) = items
    
    assertNativeComponent(result,
      <.View(props.style.map(^.rnStyle := _))(
        renderItem(item1, top = true),
        renderItem(item2),
        renderItem(item3)
      )
    )
  }
}
