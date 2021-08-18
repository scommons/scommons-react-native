package showcase.app.ui

import scommons.react._
import scommons.react.hooks._
import scommons.react.navigation._
import scommons.reactnative._
import scommons.reactnative.ui._

import scala.scalajs.js

object ChoiceGroupDemo extends FunctionComponent[Unit] {

  case class ChoiceData(id: Int, name: String, info: Double)
  
  private[ui] var customChoiceGroupComp: UiComponent[ChoiceGroupProps[Int, ChoiceData]] =
    new ChoiceGroup[Int, ChoiceData]
  private[ui] var choiceGroupComp: UiComponent[ChoiceGroupProps[String, ChoiceItemData]] = ChoiceGroup

  protected def render(props: Props): ReactElement = {
    implicit val theme: Theme = useTheme()
    val (singleSelectIds, setSingleSelectIds) = useState(Set.empty[String])
    val (multiSelectIds, setMultiSelectIds) = useState(Set.empty[Int])
    
    <.View(^.rnStyle := styles.container)(
      <.Text(themeStyle(styles.title, themeTextStyle))(
        "Single-select (simple):"
      ),
      <(choiceGroupComp())(^.wrapped := ChoiceGroupProps(
        items = List(
          ChoiceItemData("1", "item1"),
          ChoiceItemData("2", "item2")
        ),
        selectedIds = singleSelectIds,
        onSelectChange = setSingleSelectIds,
        style = Some(styles.choiceGroup)
      ))(),
      
      <.Text(themeStyle(styles.title, themeTextStyle))(
        "Multi-select (with custom data):"
      ),
      <(customChoiceGroupComp())(^.wrapped := new ChoiceGroupProps[Int, ChoiceData](
        items = List(
          ChoiceData(1, "option 1", 0.1),
          ChoiceData(2, "option 2", 0.2)
        ),
        keyExtractor = _.id,
        iconRenderer = ChoiceGroupProps.defaultIconRenderer(multiSelect = true),
        labelRenderer = { (data, t) =>
          implicit val theme: Theme = t
          <.Text(themeStyle(styles.label, themeTextStyle))(data.name)
        },
        selectedIds = multiSelectIds,
        onSelectChange = setMultiSelectIds,
        multiSelect = true,
        style = Some(styles.choiceGroup)
      ))()
    )
  }

  private[ui] lazy val styles = StyleSheet.create(new Styles)
  private[ui] class Styles extends js.Object {
    import ViewStyle._

    val container: Style = new ViewStyle {
      override val flex = 1
      override val margin = 5
    }
    val title: Style = new TextStyle {
      override val marginTop = 15
      override val marginBottom = 5
    }
    val choiceGroup: Style = new ViewStyle {
      override val alignSelf = AlignSelf.center
      override val margin = 5
      override val padding = 5
    }
    val label: Style = new ViewStyle {
      override val marginHorizontal = 5
      override val paddingHorizontal = 5
    }
  }
}
