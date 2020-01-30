package showcase

import showcase.FlatListDemo._
import showcase.FlatListDemoSpec.FlatListDataMock
import scommons.react._
import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative.FlatList.FlatListData
import scommons.reactnative._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportAll

class FlatListDemoSpec extends TestSpec with ShallowRendererUtils {

  it should "render item when renderItem" in {
    //given
    val comp = shallowRender(<(FlatListDemo())()())
    val List(flatList) = findComponents(comp, scommons.reactnative.raw.FlatList)
    val data = mock[FlatListDataMock]
    (data.item _).expects().returning(dataList.head)
    
    //when
    val result = flatList.props.renderItem(data.asInstanceOf[FlatListData[Data]])
    
    //then
    val wrapper = new FunctionComponent[ItemProps] {
      protected def render(compProps: Props): ReactElement = {
        result.asInstanceOf[ReactElement]
      }
    }
    assertComponent(shallowRender(<(wrapper())()()), Item) {
      case ItemProps(title) =>
        title shouldBe "First Item"
    }
  }
  
  it should "return data.id from keyExtractor" in {
    //given
    val comp = shallowRender(<(FlatListDemo())()())
    val List(flatList) = findComponents(comp, scommons.reactnative.raw.FlatList)
    val data = dataList.head
    
    //when
    val result = flatList.props.keyExtractor(data.asInstanceOf[js.Any])
    
    //then
    result shouldBe data.id
  }
  
  it should "render Item component" in {
    //given
    val props = ItemProps("Test title")
    val component = <(Item())(^.wrapped := props)()

    //when
    val result = shallowRender(component)

    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.item)(
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
          ^.flatListData := js.Array(dataList: _*)
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
