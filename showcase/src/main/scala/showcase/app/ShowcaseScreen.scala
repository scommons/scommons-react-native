package showcase.app

import showcase.app.expo.av._
import showcase.app.style._
import showcase.app.task._
import scommons.react._
import scommons.react.navigation._
import scommons.react.navigation.stack._

case class ShowcaseScreenProps(navigate: String => Unit)

object ShowcaseScreen extends FunctionComponent[ShowcaseScreenProps] {

  protected def render(compProps: Props): ReactElement = {
    val props = compProps.wrapped
    
    <(ShowcaseListView())(^.wrapped := ShowcaseListViewProps(
      items = List(
        "ReactNative" -> "Demo core components",
        "Styles" -> "Demo style components",
        "Video" -> "Demo video components",
        "DemoTask" -> "Demo API task components"
      ),
      navigate = props.navigate
    ))()
  }

  private[app] lazy val demoTaskComp = new DemoTaskController(ShowcaseActions).apply()

  private[app] lazy val Stack = createStackNavigator()

  lazy val homeStackComp: ReactClass = new FunctionComponent[Unit] {
    protected def render(props: Props): ReactElement = {
      <(Stack.Navigator)(^.initialRouteName := "Showcase")(
        <(Stack.Screen)(^.name := "Showcase", ^.component := ShowcaseController())(),
        // styles
        StylesScreen.getStylesStack(Stack),
        // expo
        <(Stack.Screen)(^.name := "Video", ^.component := VideoDemo())(),
        // ui
        <(Stack.Screen)(^.name := "DemoTask", ^.component := demoTaskComp)()
      )
    }
  }.apply()

}
