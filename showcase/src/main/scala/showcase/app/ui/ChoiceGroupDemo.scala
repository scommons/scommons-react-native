package showcase.app.ui

import scommons.react._
import scommons.react.hooks._
import scommons.reactnative._
import scommons.reactnative.ui._

import scala.scalajs.js

object ChoiceGroupDemo extends FunctionComponent[Unit] {

  case class ChoiceData(id: Int, name: String, info: Double)
  
  private[ui] lazy val choiceGroupComp = new ChoiceGroup[Int, ChoiceData]

  protected def render(props: Props): ReactElement = {
    val (singleSelectIds, setSingleSelectIds) = useState(Set.empty[String])
    val (multiSelectIds, setMultiSelectIds) = useState(Set.empty[Int])
    
    <.View(^.rnStyle := styles.container)(
      <.Text(^.rnStyle := styles.title)(
        "Single-select (simple):"
      ),
      <(ChoiceGroup())(^.wrapped := ChoiceGroupProps(
        items = List(
          ChoiceItemData("1", "item1"),
          ChoiceItemData("2", "item2")
        ),
        selectedIds = singleSelectIds,
        onSelectChange = setSingleSelectIds,
        style = Some(styles.choiceGroup)
      ))(),
      
      <.Text(^.rnStyle := styles.title)(
        "Multi-select (with custom data):"
      ),
      <(choiceGroupComp())(^.wrapped := new ChoiceGroupProps[Int, ChoiceData](
        items = List(
          ChoiceData(1, "option 1", 0.1),
          ChoiceData(2, "option 2", 0.2)
        ),
        keyExtractor = _.id,
        iconRenderer = ChoiceGroupProps.defaultIconRenderer(multiSelect = true),
        labelRenderer = { data =>
          <.Text(^.rnStyle := styles.label)(data.name)
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
