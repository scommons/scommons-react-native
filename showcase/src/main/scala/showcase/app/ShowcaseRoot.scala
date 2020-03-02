package showcase.app

import showcase._
import showcase.app.style._
import showcase.app.video._
import showcase.app.task._
import scommons.react._
import scommons.react.navigation._
import scommons.react.navigation.stack._

object ShowcaseRoot extends FunctionComponent[Unit] {

  private[app] lazy val Stack = createStackNavigator()
  
  private[app] lazy val demoTaskComp = new DemoTaskController(ShowcaseActions).apply()
  
  protected def render(props: Props): ReactElement = {
    <.NavigationContainer()(
      <(Stack.Navigator)(^.initialRouteName := "Showcase")(
        <(Stack.Screen)(^.name := "Showcase", ^.component := ShowcaseController())(),
        // RN components
        <(Stack.Screen)(^.name := "ReactNative", ^.component := ReactNativeDemoController())(),
        <(Stack.Screen)(^.name := "ActivityIndicator", ^.component := ActivityIndicatorDemo())(),
        <(Stack.Screen)(^.name := "Button", ^.component := ButtonDemo())(),
        <(Stack.Screen)(^.name := "FlatList", ^.component := FlatListDemo())(),
        <(Stack.Screen)(^.name := "Modal", ^.component := ModalDemo())(),
        <(Stack.Screen)(^.name := "Alert", ^.component := AlertDemo())(),
        //style
        <(Stack.Screen)(^.name := "Styles", ^.component := StylesScreenController())(),
        <(Stack.Screen)(^.name := "BorderStyle", ^.component := BorderStyleDemo())(),
        <(Stack.Screen)(^.name := "BorderRadius", ^.component := BorderRadiusDemo())(),
        <(Stack.Screen)(^.name := "MarginStyle", ^.component := MarginStyleDemo())(),
        <(Stack.Screen)(^.name := "PaddingStyle", ^.component := PaddingStyleDemo())(),
        <(Stack.Screen)(^.name := "PositionStyle", ^.component := PositionStyleDemo())(),
        <(Stack.Screen)(^.name := "Platform", ^.component := PlatformDemo())(),
        <(Stack.Screen)(^.name := "TextStyle", ^.component := app.style.TextStyleDemo())(),
        <(Stack.Screen)(^.name := "ProfileCard", ^.component := ProfileCard())(),
        // video
        <(Stack.Screen)(^.name := "Video", ^.component := VideoDemo())(),
        // task
        <(Stack.Screen)(^.name := "DemoTask", ^.component := demoTaskComp)()
      )
    )
  }
}
