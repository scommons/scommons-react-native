package scommons.reactnative.ui.popup

import scommons.react.test.TestSpec
import scommons.react.test.raw.ShallowInstance
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative.ActivityIndicator._
import scommons.reactnative.Modal._
import scommons.reactnative._
import scommons.reactnative.ui.popup.LoadingPopup._

class LoadingPopupSpec extends TestSpec with ShallowRendererUtils {

  it should "render component with custom props" in {
    //given
    val props = LoadingPopupProps(
      size = ActivityIndicatorSize.large,
      color = Style.Color.yellow
    )
    val component = <(LoadingPopup())(^.wrapped := props)()

    //when
    val result = shallowRender(component)

    //then
    assertLoadingPopup(result, props)
  }
  
  it should "render component with default props" in {
    //given
    val props = LoadingPopupProps()
    val component = <(LoadingPopup())(^.wrapped := props)()

    //when
    val result = shallowRender(component)

    //then
    assertLoadingPopup(result, props)
  }
  
  private def assertLoadingPopup(result: ShallowInstance, props: LoadingPopupProps): Unit = {
    assertNativeComponent(result,
      <.Modal(
        ^.animationType := AnimationType.none,
        ^.transparent := true,
        ^.visible := true
      )(
        <.View(^.rnStyle := styles.container)(
          <.ActivityIndicator(^.aiSize := props.size, ^.color := props.color)()
        )
      )
    )
  }
}
