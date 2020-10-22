package scommons.reactnative.ui

import scommons.expo._
import scommons.react._
import scommons.react.navigation._
import scommons.reactnative._

import scala.scalajs.js

case class ChoiceGroupProps[K, T](items: Seq[T],
                                  keyExtractor: T => K,
                                  iconRenderer: (Boolean, Theme) => ReactElement,
                                  labelRenderer: (T, Theme) => ReactElement,
                                  selectedIds: Set[K],
                                  onSelectChange: Set[K] => Unit,
                                  multiSelect: Boolean,
                                  style: Option[Style])

object ChoiceGroupProps {

  def defaultIconRenderer(multiSelect: Boolean,
                          size: Int = 24,
                          color: Option[String] = None
                         ): (Boolean, Theme) => ReactElement = { (isSelected, theme) =>
    
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
      ^.rnSize := size,
      ^.color := color.getOrElse(theme.colors.primary)
    )()
  }
  
  def apply(items: List[ChoiceItemData],
            selectedIds: Set[String] = Set.empty,
            onSelectChange: Set[String] => Unit = _ => (),
            multiSelect: Boolean = false,
            style: Option[Style] = None
           ): ChoiceGroupProps[String, ChoiceItemData] = {

    new ChoiceGroupProps[String, ChoiceItemData](
      items = items,
      keyExtractor = _.id,
      iconRenderer = defaultIconRenderer(multiSelect),
      labelRenderer = { (data, theme) =>
        implicit val t: Theme = theme
        <.Text(themeStyle(ChoiceGroup.styles.label, themeTextStyle))(data.text)
      },
      selectedIds = selectedIds,
      onSelectChange = onSelectChange,
      multiSelect = multiSelect,
      style = style
    )
  }
}

class ChoiceGroup[K, T] extends FunctionComponent[ChoiceGroupProps[K, T]] {

  protected def render(compProps: Props): ReactElement = {
    val theme = useTheme()
    val props = compProps.wrapped

    def renderItem(data: T, index: Int): ReactElement = {
      val key = props.keyExtractor(data)
      val isSelected = props.selectedIds.contains(key)

      <.TouchableOpacity(
        ^.key := s"$key",
        if (index > 0) {
          ^.rnStyle := js.Array(ChoiceGroup.styles.item, ChoiceGroup.styles.nonTopItem)
        }
        else ^.rnStyle := ChoiceGroup.styles.item,
        ^.onPress := onPress(props, key, data)
      )(
        props.iconRenderer(isSelected, theme),
        props.labelRenderer(data, theme)
      )
    }

    <.View(props.style.map(^.rnStyle := _))(
      props.items.zipWithIndex.map { case (data, index) =>
        renderItem(data, index)
      }
    )
  }

  private def onPress(props: ChoiceGroupProps[K, T], key: K, row: T): () => Unit = { () =>
    val isSelected = props.selectedIds.contains(key)

    if (props.multiSelect) {
      val newIds =
        if (isSelected) props.selectedIds - key
        else props.selectedIds + key

      props.onSelectChange(newIds)
    }
    else {
      if (!isSelected) {
        props.onSelectChange(Set(key))
      }
    }
  }
}

object ChoiceGroup extends ChoiceGroup[String, ChoiceItemData] {

  private[ui] lazy val styles = StyleSheet.create(new Styles)
  private[ui] class Styles extends js.Object {
    import ViewStyle._

    val item: Style = new ViewStyle {
      override val flexDirection = FlexDirection.row
      override val alignItems = AlignItems.center
    }
    val nonTopItem: Style = new ViewStyle {
      override val marginTop = 10
    }
    val label: Style = new TextStyle {
      override val marginHorizontal = 5
      override val paddingHorizontal = 5
    }
  }
}
