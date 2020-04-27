package showcase.app.expo

import showcase.app.expo.av._
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
        "Video" -> "Demo video components"
      ),
      navigate = props.navigate
    ))()
  }

  private[expo] lazy val Stack = createStackNavigator()

  lazy val expoStackComp: ReactClass = new FunctionComponent[Unit] {
    protected def render(props: Props): ReactElement = {
      <(Stack.Navigator)(^.initialRouteName := "Expo")(
        <(Stack.Screen)(^.name := "Expo", ^.component := ExpoDemoController())(),
        <(Stack.Screen)(^.name := "Asset", ^.component := AssetDemo())(),
        <(Stack.Screen)(^.name := "Font", ^.component := FontDemo())(),
        <(Stack.Screen)(^.name := "Video", ^.component := VideoDemo())()
      )
    }
  }.apply()

}
