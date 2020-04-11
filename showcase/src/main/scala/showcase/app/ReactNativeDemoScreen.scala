package showcase.app

import showcase._
import scommons.react._
import scommons.react.navigation._
import scommons.react.navigation.stack._

case class ReactNativeDemoScreenProps(navigate: String => Unit)

object ReactNativeDemoScreen extends FunctionComponent[ReactNativeDemoScreenProps] {
  
  protected def render(compProps: Props): ReactElement = {
    val props = compProps.wrapped

    <(ShowcaseListView())(^.wrapped := ShowcaseListViewProps(
      items = List(
        "ActivityIndicator" -> "Demo ActivityIndicator component",
        "Button" -> "Demo Button component",
        "FlatList" -> "Demo FlatList component",
        "Modal" -> "Demo Modal component",
        "Picker" -> "Demo Picker component",
        "Alert" -> "Demo Alert component",
        "Platform" -> "Demo Platform API"
      ),
      navigate = props.navigate
    ))()
  }

  private[app] lazy val Stack = createStackNavigator()

  lazy val reactNativeStackComp: ReactClass = new FunctionComponent[Unit] {
    protected def render(props: Props): ReactElement = {
      <(Stack.Navigator)(^.initialRouteName := "ReactNative")(
        <(Stack.Screen)(^.name := "ReactNative", ^.component := ReactNativeDemoController())(),
        <(Stack.Screen)(^.name := "ActivityIndicator", ^.component := ActivityIndicatorDemo())(),
        <(Stack.Screen)(^.name := "Button", ^.component := ButtonDemo())(),
        <(Stack.Screen)(^.name := "FlatList", ^.component := FlatListDemo())(),
        <(Stack.Screen)(^.name := "Modal", ^.component := ModalDemo())(),
        <(Stack.Screen)(^.name := "Picker", ^.component := PickerDemo())(),
        <(Stack.Screen)(^.name := "Alert", ^.component := AlertDemo())(),
        <(Stack.Screen)(^.name := "Platform", ^.component := PlatformDemo())()
      )
    }
  }.apply()

}
