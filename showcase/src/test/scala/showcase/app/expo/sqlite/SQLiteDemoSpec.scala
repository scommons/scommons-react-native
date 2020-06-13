package showcase.app.expo.sqlite

import scommons.react.test._
import scommons.react.test.dom.AsyncTestSpec
import scommons.reactnative._

class SQLiteDemoSpec extends AsyncTestSpec
  with ShallowRendererUtils
  with TestRendererUtils {

  it should "render initial component" in {
    //given
    val component = <(SQLiteDemo())()()

    //when
    val result = shallowRender(component)

    //then
    assertNativeComponent(result,
      <.View()(
        <.Text()("DB log:"),
        <.Text()("")
      )
    )
  }
  
  it should "render full DB log eventually" in {
    //given
    val component = <(SQLiteDemo())()()

    //when
    val result = testRender(component)

    //then
    eventually {
      assertNativeComponent(result,
        <.View()(
          <.Text()("DB log:"),
          <.Text()(""),
          <.Text()("DB is opened"),
          <.Text()("select: rows: 0"),
          <.Text()("tx is completed")
        )
      )
    }
  }
}
