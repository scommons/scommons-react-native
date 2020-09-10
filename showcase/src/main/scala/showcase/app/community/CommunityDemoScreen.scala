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
        "WebView" -> "Demo WebView components"
      ),
      navigate = props.navigate
    ))()
  }

  private[community] lazy val Stack = createStackNavigator()

  lazy val communityStackComp: ReactClass = new FunctionComponent[Unit] {
    protected def render(props: Props): ReactElement = {
      <(Stack.Navigator)(^.initialRouteName := "Community")(
        <(Stack.Screen)(^.name := "Community", ^.component := CommunityDemoController())(),
        <(Stack.Screen)(^.name := "Svg", ^.component := SvgDemo())(),
        <(Stack.Screen)(^.name := "WebView", ^.component := WebViewDemo())()
      )
    }
  }.apply()

}
