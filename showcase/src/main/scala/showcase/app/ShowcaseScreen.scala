package showcase.app

import scommons.react._

case class ShowcaseScreenProps(navigate: String => Unit)

object ShowcaseScreen extends FunctionComponent[ShowcaseScreenProps] {

  protected def render(compProps: Props): ReactElement = {
    val props = compProps.wrapped
    
    <(ShowcaseListView())(^.wrapped := ShowcaseListViewProps(
      items = List(
        "ReactNative" -> "Demo core components",
        "Styles" -> "Demo style components",
        "Video" -> "Demo video components"
      ),
      navigate = props.navigate
    ))()
  }
}
