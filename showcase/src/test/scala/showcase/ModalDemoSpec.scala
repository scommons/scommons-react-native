package showcase

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative.Modal._
import scommons.reactnative._
import showcase.ModalDemo.styles

class ModalDemoSpec extends TestSpec with ShallowRendererUtils {

  it should "set visible to true when press Show Modal" in {
    //given
    val renderer = createRenderer()
    renderer.render(<(ModalDemo())()())
    findComponents(renderer.getRenderOutput(), raw.Modal) shouldBe Nil
    val List(showModal) = findComponents(renderer.getRenderOutput(), raw.Button)
    
    //when
    showModal.props.onPress()
    
    //then
    val List(modal) = findComponents(renderer.getRenderOutput(), raw.Modal)
    modal.props.visible shouldBe true
  }
  
  it should "set visible to false when press Hide Modal" in {
    //given
    val renderer = createRenderer()
    renderer.render(<(ModalDemo())()())
    val List(showModal) = findComponents(renderer.getRenderOutput(), raw.Button)
    showModal.props.onPress()
    val List(modal) = findComponents(renderer.getRenderOutput(), raw.Modal)
    modal.props.visible shouldBe true
    val List(hideModal, _) = findComponents(renderer.getRenderOutput(), raw.Button)
    
    //when
    hideModal.props.onPress()
    
    //then
    findComponents(renderer.getRenderOutput(), raw.Modal) shouldBe Nil
  }
  
  it should "render component without modal" in {
    //given
    val component = <(ModalDemo())()()

    //when
    val result = shallowRender(component)

    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.Button(^.title := "Show Modal", ^.color := "#0000ff")()
      )
    )
  }
  
  it should "render component with modal" in {
    //given
    val renderer = createRenderer()
    renderer.render(<(ModalDemo())()())
    val List(showModal) = findComponents(renderer.getRenderOutput(), raw.Button)

    //when
    showModal.props.onPress()

    //then
    assertNativeComponent(renderer.getRenderOutput(),
      <.View(^.rnStyle := styles.container)(
        <.Modal(
          ^.animationType := AnimationType.slide,
          ^.transparent := false,
          ^.visible := true
        )(
          <.View(^.rnStyle := styles.container)(
            <.View()(
              <.Text()("Hello World!"),
              <.Button(^.title := "Hide Modal", ^.color := "#0000ff")()
            )
          )
        ),

        <.Button(^.title := "Show Modal", ^.color := "#0000ff")()
      )
    )
  }
}
