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
        "Image" -> "Demo Image component",
        "Modal" -> "Demo Modal component",
        "Alert" -> "Demo Alert component",
        "Switch" -> "Demo Switch component",
        "Platform" -> "Demo Platform API"
      ),
      navigate = props.navigate
    ))()
  }

  private[app] lazy val switchComp = new SwitchController(ShowcaseActions).apply()

  def getReactNativeScreens(stack: StackNavigator): Seq[ReactElement] = Seq(
    <(stack.Screen)(^.name := "ActivityIndicator", ^.component := ActivityIndicatorDemo())(),
    <(stack.Screen)(^.name := "Button", ^.component := ButtonDemo())(),
    <(stack.Screen)(^.name := "FlatList", ^.component := FlatListDemo())(),
    <(stack.Screen)(^.name := "Image", ^.component := ImageDemo())(),
    <(stack.Screen)(^.name := "Modal", ^.component := ModalDemo())(),
    <(stack.Screen)(^.name := "Alert", ^.component := AlertDemo())(),
    <(stack.Screen)(^.name := "Switch", ^.component := switchComp)(),
    <(stack.Screen)(^.name := "Platform", ^.component := PlatformDemo())()
  )
}
