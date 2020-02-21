package showcase.app

import scommons.react.navigation.stack._
import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import showcase._
import showcase.app.style._
import showcase.app.video._

class ShowcaseAppSpec extends TestSpec with ShallowRendererUtils {

  it should "render component" in {
    //given
    val component = <(ShowcaseApp())()()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <("NavigationContainer")()(
        <("Navigator")(^.initialRouteName := "Showcase")(
          <("Screen")(^.name := "Showcase", ^.component := ShowcaseController())(),
          // RN components
          <("Screen")(^.name := "ReactNative", ^.component := ReactNativeDemoController())(),
          <("Screen")(^.name := "ActivityIndicator", ^.component := ActivityIndicatorDemo())(),
          <("Screen")(^.name := "Button", ^.component := ButtonDemo())(),
          <("Screen")(^.name := "FlatList", ^.component := FlatListDemo())(),
          <("Screen")(^.name := "Modal", ^.component := ModalDemo())(),
          <("Screen")(^.name := "Alert", ^.component := AlertDemo())(),
          //style
          <("Screen")(^.name := "Styles", ^.component := StylesScreenController())(),
          <("Screen")(^.name := "BorderStyle", ^.component := BorderStyleDemo())(),
          <("Screen")(^.name := "BorderRadius", ^.component := BorderRadiusDemo())(),
          <("Screen")(^.name := "MarginStyle", ^.component := MarginStyleDemo())(),
          <("Screen")(^.name := "PaddingStyle", ^.component := PaddingStyleDemo())(),
          <("Screen")(^.name := "PositionStyle", ^.component := PositionStyleDemo())(),
          <("Screen")(^.name := "Platform", ^.component := PlatformDemo())(),
          <("Screen")(^.name := "TextStyle", ^.component := app.style.TextStyleDemo())(),
          <("Screen")(^.name := "ProfileCard", ^.component := ProfileCard())(),
          // video
          <("Screen")(^.name := "Video", ^.component := VideoDemo())()
        )
      )
    )
  }
}
