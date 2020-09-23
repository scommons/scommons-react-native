package showcase.app.expo

import showcase.app.expo.av._
import showcase.app.expo.sqlite._
import showcase.app.{ShowcaseListView, ShowcaseListViewProps}
import scommons.react._
import scommons.react.navigation._
import scommons.react.navigation.stack._

case class ExpoDemoScreenProps(navigate: String => Unit)

object ExpoDemoScreen extends FunctionComponent[ExpoDemoScreenProps] {
  
  protected def render(compProps: Props): ReactElement = {
    val props = compProps.wrapped

    <(ShowcaseListView())(^.wrapped := ShowcaseListViewProps(
      items = List(
        "Asset" -> "Demo Asset API",
        "Font" -> "Demo Font API",
        "Video" -> "Demo video components",
        "SQLite" -> "Demo SQLite API"
      ),
      navigate = props.navigate
    ))()
  }

  def getExpoScreens(stack: StackNavigator): Seq[ReactElement] = Seq(
    <(stack.Screen)(^.name := "Asset", ^.component := AssetDemo())(),
    <(stack.Screen)(^.name := "Font", ^.component := FontDemo())(),
    <(stack.Screen)(^.name := "Video", ^.component := VideoDemo())(),
    <(stack.Screen)(^.name := "SQLite", ^.component := SQLiteDemo())()
  )
}
