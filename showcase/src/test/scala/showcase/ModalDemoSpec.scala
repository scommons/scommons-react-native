package showcase

import scommons.react.test.TestSpec
import scommons.react.test.util.TestRendererUtils
import scommons.reactnative.Modal._
import scommons.reactnative._
import showcase.ModalDemo.styles

class ModalDemoSpec extends TestSpec with TestRendererUtils {

  it should "set visible to true when press Show Modal" in {
    //given
    val renderer = createTestRenderer(<(ModalDemo())()())
    findComponents(renderer.root, raw.Modal) shouldBe Nil
    val showModal = inside(findComponents(renderer.root, raw.Button)) {
      case List(showModal) => showModal
    }
    
    //when
    showModal.props.onPress()
    
    //then
    val modal = inside(findComponents(renderer.root, raw.Modal)) {
      case List(modal) => modal
    }
    modal.props.visible shouldBe true
  }
  
  it should "set visible to false when press Hide Modal" in {
    //given
    val renderer = createTestRenderer(<(ModalDemo())()())
    val showModal = inside(findComponents(renderer.root, raw.Button)) {
      case List(showModal) => showModal
    }
    showModal.props.onPress()
    val modal = inside(findComponents(renderer.root, raw.Modal)) {
      case List(modal) => modal
    }
    modal.props.visible shouldBe true
    val hideModal = inside(findComponents(renderer.root, raw.Button)) {
      case List(hideModal, _) => hideModal
    }
    
    //when
    hideModal.props.onPress()
    
    //then
    findComponents(renderer.root, raw.Modal) shouldBe Nil
  }
  
  it should "render component without modal" in {
    //given
    val component = <(ModalDemo())()()

    //when
    val result = testRender(component)

    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.Button(^.title := "Show Modal", ^.color := "#0000ff")()
      )
    )
  }
  
  it should "render component with modal" in {
    //given
    val renderer = createTestRenderer(<(ModalDemo())()())
    val showModal = inside(findComponents(renderer.root, raw.Button)) {
      case List(showModal) => showModal
    }

    //when
    showModal.props.onPress()

    //then
    assertNativeComponent(renderer.root.children(0),
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
