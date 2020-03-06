package showcase.app

import scommons.react._

case class ReactNativeDemoScreenProps(navigate: String => Unit)

object ReactNativeDemoScreen extends FunctionComponent[ReactNativeDemoScreenProps] {
  
  protected def render(compProps: Props): ReactElement = {
    val props = compProps.wrapped

    <(ShowcaseListView())(^.wrapped := ShowcaseListViewProps(
      items = List(
        "ActivityIndicator" -> "Demo ActivityIndicator component",
        "Button" -> "Demo Button component",
        "FlatList" -> "Demo FlatList component",
        "Modal" -> "Demo Modal component",
        "Picker" -> "Demo Picker component",
        "Alert" -> "Demo Alert component"
      ),
      navigate = props.navigate
    ))()
  }
}
