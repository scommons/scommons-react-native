package showcase

import scommons.react._
import scommons.react.hooks._
import scommons.reactnative._
import scommons.react.navigation._

import scala.scalajs.js

/** @see https://reactnative.dev/docs/picker
  */
object PickerDemo extends FunctionComponent[Unit] {

  protected def render(props: Props): ReactElement = {
    val theme = useTheme()
    val (language, setLanguage) = useState("1")
    
    <.Picker(
      ^.selectedValue := language,
      ^.rnStyle := styles.picker,
      ^.onValueChange := { (itemValue, itemIndex) =>
        //println(s"itemIndex: $itemIndex")
        setLanguage(itemValue)
      }
    )(
      <.PickerItem(^.color := theme.colors.primary, ^.label := "Java", ^.value := 1)(),
      <.PickerItem(^.color := theme.colors.primary, ^.label := "JavaScript", ^.value := 2)()
    )
  }

  private[showcase] lazy val styles = StyleSheet.create(new Styles)
  private[showcase] class Styles extends js.Object {
    
    val picker: Style = new ViewStyle {
      override val height = 50
      override val width = 100
    }
  }
}
