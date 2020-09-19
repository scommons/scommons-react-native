package showcase.app

import showcase.app.style._
import showcase.app.task._
import showcase.app.ui._
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
        "Community" -> "Demo community components",
        "Expo" -> "Demo expo components",
        "Styles" -> "Demo different styles",
        "DemoTask" -> "Demo API tasks",
        "UI" -> "Demo common UI components"
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
        // ui
        <(Stack.Screen)(^.name := "DemoTask", ^.component := demoTaskComp)(),
        UiDemoScreen.getUiStack(Stack)
      )
    }
  }.apply()

}
