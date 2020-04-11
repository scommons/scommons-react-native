package showcase.app.style

import showcase.app._
import scommons.react._
import scommons.react.navigation._
import scommons.react.navigation.stack.raw.StackNavigator

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
        "TextStyle" -> "Demo text styles",
        "ProfileCard" -> "Demo ProfileCard component"
      ),
      navigate = props.navigate
    ))()
  }

  def getStylesStack(stack: StackNavigator): Seq[ReactElement] = List(
    <(stack.Screen)(^.name := "Styles", ^.component := StylesScreenController())(),
    <(stack.Screen)(^.name := "BorderStyle", ^.component := BorderStyleDemo())(),
    <(stack.Screen)(^.name := "BorderRadius", ^.component := BorderRadiusDemo())(),
    <(stack.Screen)(^.name := "MarginStyle", ^.component := MarginStyleDemo())(),
    <(stack.Screen)(^.name := "PaddingStyle", ^.component := PaddingStyleDemo())(),
    <(stack.Screen)(^.name := "PositionStyle", ^.component := PositionStyleDemo())(),
    <(stack.Screen)(^.name := "TextStyle", ^.component := TextStyleDemo())(),
    <(stack.Screen)(^.name := "ProfileCard", ^.component := ProfileCard())(),
  )

}
