package showcase.app.community

import showcase.app.{ShowcaseListView, ShowcaseListViewProps}
import scommons.react._
import scommons.react.navigation._
import scommons.react.navigation.stack._

case class CommunityDemoScreenProps(navigate: String => Unit)

object CommunityDemoScreen extends FunctionComponent[CommunityDemoScreenProps] {
  
  protected def render(compProps: Props): ReactElement = {
    val props = compProps.wrapped

    <(ShowcaseListView())(^.wrapped := ShowcaseListViewProps(
      items = List(
        "Svg" -> "Demo Svg components",
        "WebView" -> "Demo WebView components",
        "HTMLView" -> "Demo HTMLView components",
        "SyntaxHighlighter" -> "Demo SyntaxHighlighter components"
      ),
      navigate = props.navigate
    ))()
  }

  def getCommunityScreens(stack: StackNavigator): Seq[ReactElement] = Seq(
    <(stack.Screen)(^.name := "Svg", ^.component := SvgDemo())(),
    <(stack.Screen)(^.name := "WebView", ^.component := WebViewDemo())(),
    <(stack.Screen)(^.name := "HTMLView", ^.component := HTMLViewDemo())(),
    <(stack.Screen)(^.name := "SyntaxHighlighter", ^.component := SyntaxHighlighterDemo())()
  )
}
