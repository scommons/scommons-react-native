package showcase

import showcase.FlatListDemo._
import showcase.FlatListDemoSpec.FlatListDataMock
import org.scalatest.Succeeded
import scommons.nodejs.test.AsyncTestSpec
import scommons.react._
import scommons.react.test._
import scommons.reactnative.FlatList.FlatListData
import scommons.reactnative._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportAll

class FlatListDemoSpec extends AsyncTestSpec
  with BaseTestSpec
  with ShallowRendererUtils
  with TestRendererUtils {

  it should "set refreshing when onRefresh" in {
    //given
    val renderer = createTestRenderer(<(FlatListDemo())()())
    val List(flatList) = findComponents(renderer.root, <.FlatList.reactClass)
    flatList.props.refreshing shouldBe false

    //when
    flatList.props.onRefresh()

    //then
    flatList.props.refreshing shouldBe true
    
    eventually {
      flatList.props.refreshing shouldBe false
    }
  }

  it should "render item, select and un-select it when onPress" in {
    //given
    val renderer = createRenderer()
    renderer.render(<(FlatListDemo())()())
    val data = mock[FlatListDataMock]
    (data.item _).expects().repeated(3)
      .returning(dataList.head)
    
    def renderItem(flatList: ShallowInstance): ShallowInstance = {
      val wrapper = new FunctionComponent[ItemProps] {
        protected def render(compProps: Props): ReactElement = {
          val result = flatList.props.renderItem(data.asInstanceOf[FlatListData[Data]])
          result.asInstanceOf[ReactElement]
        }
      }

      shallowRender(<(wrapper())()())
    }
    
    //when & then
    val List(flatList) = findComponents(renderer.getRenderOutput(), <.FlatList.reactClass)
    assertComponent(renderItem(flatList), Item) {
      case ItemProps(title, selected, onPress) =>
        title shouldBe "First Item"
        selected shouldBe false

        //when
        onPress()
        Succeeded
    }

    //then
    val List(selectedList) = findComponents(renderer.getRenderOutput(), <.FlatList.reactClass)
    assertComponent(renderItem(selectedList), Item) {
      case ItemProps(title, selected, onPress) =>
        title shouldBe "First Item"
        selected shouldBe true

        //when
        onPress()
        Succeeded
    }
    
    //then
    val List(unselectedList) = findComponents(renderer.getRenderOutput(), <.FlatList.reactClass)
    assertComponent(renderItem(unselectedList), Item) {
      case ItemProps(title, selected, _) =>
        title shouldBe "First Item"
        selected shouldBe false
    }
  }
  
  it should "return data.id from keyExtractor" in {
    //given
    val comp = shallowRender(<(FlatListDemo())()())
    val List(flatList) = findComponents(comp, <.FlatList.reactClass)
    val data = dataList.head
    
    //when
    val result = flatList.props.keyExtractor(data.asInstanceOf[js.Any])
    
    //then
    result shouldBe data.id
  }
  
  it should "render un-selected Item component" in {
    //given
    val props = ItemProps("Test title", selected = false, () => ())
    val component = <(Item())(^.wrapped := props)()

    //when
    val result = shallowRender(component)

    //then
    assertNativeComponent(result,
      <.TouchableOpacity(^.rnStyle := styles.item)(
        <.Text(^.rnStyle := styles.title)(props.title)
      )
    )
  }
  
  it should "render selected Item component" in {
    //given
    val props = ItemProps("Test title", selected = true, () => ())
    val component = <(Item())(^.wrapped := props)()

    //when
    val result = shallowRender(component)

    //then
    assertNativeComponent(result,
      <.TouchableOpacity(^.rnStyle := js.Array(styles.item, styles.selectedItem))(
        <.Text(^.rnStyle := styles.title)(props.title)
      )
    )
  }
  
  it should "render main component" in {
    //given
    val component = <(FlatListDemo())()()

    //when
    val result = shallowRender(component)

    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.FlatList(
          ^.flatListData := js.Array(dataList: _*),
          ^.extraData := Set.empty[String]
        )()
      )
    )
  }
}

object FlatListDemoSpec {

  @JSExportAll
  trait FlatListDataMock {
    def item: Data
  }
}
