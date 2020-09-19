package showcase.app.ui

import showcase.app._
import scommons.react._
import scommons.react.navigation._
import scommons.react.navigation.stack.raw.StackNavigator

case class UiDemoScreenProps(navigate: String => Unit)

object UiDemoScreen extends FunctionComponent[UiDemoScreenProps] {
  
  protected def render(compProps: Props): ReactElement = {
    val props = compProps.wrapped

    <(ShowcaseListView())(^.wrapped := ShowcaseListViewProps(
      items = List(
        "ChoiceGroup" -> "Demo ChoiceGroup component"
      ),
      navigate = props.navigate
    ))()
  }

  def getUiStack(stack: StackNavigator): Seq[ReactElement] = List(
    <(stack.Screen)(^.name := "UI", ^.component := UiDemoController())(),
    <(stack.Screen)(^.name := "ChoiceGroup", ^.component := ChoiceGroupDemo())()
  )

}
