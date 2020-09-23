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
        "Styles" -> "Demo different styles",
        "DemoTask" -> "Demo API tasks",
        "UI" -> "Demo common UI components"
      ),
      navigate = props.navigate
    ))()
  }

  private[app] lazy val demoTaskComp = new DemoTaskController(ShowcaseActions).apply()

  def getHomeScreens(stack: StackNavigator): Seq[ReactElement] = {
    // styles
    StylesScreen.getStylesStack(stack) ++ List(
      // ui
      <(stack.Screen)(^.name := "DemoTask", ^.component := demoTaskComp)()
    ) ++
      UiDemoScreen.getUiStack(stack)
  }
}
