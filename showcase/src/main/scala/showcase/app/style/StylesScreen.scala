package showcase.app.style

import showcase.app._
import scommons.react._

case class StylesScreenProps(navigate: String => Unit)

object StylesScreen extends FunctionComponent[StylesScreenProps] {
  
  protected def render(compProps: Props): ReactElement = {
    val props = compProps.wrapped

    <(ShowcaseListView())(^.wrapped := ShowcaseListViewProps(
      items = List(
        "BorderStyle" -> "Demo border styles",
        "BorderRadius" -> "Demo border radius styles",
        "MarginStyle" -> "Demo margin styles",
        "PaddingStyle" -> "Demo padding styles",
        "PositionStyle" -> "Demo position styles",
        "Platform" -> "Demo platform-specific styles",
        "TextStyle" -> "Demo text styles",
        "ProfileCard" -> "Demo ProfileCard component"
      ),
      navigate = props.navigate
    ))()
  }
}
