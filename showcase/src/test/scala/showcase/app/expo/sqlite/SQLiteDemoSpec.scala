package showcase.app.expo.sqlite

import scommons.nodejs.test.AsyncTestSpec
import scommons.react.navigation._
import scommons.react.test._
import scommons.reactnative._

class SQLiteDemoSpec extends AsyncTestSpec
  with BaseTestSpec
  with TestRendererUtils {

  it should "render initial component" in {
    //given
    val component = <(SQLiteDemo())()()

    //when
    val result = testRender(component)

    //then
    implicit val theme: Theme = DefaultTheme
    assertNativeComponent(result,
      <.View()(
        <.Text(^.rnStyle := themeTextStyle)(
          s"""DB log:
             |
             |
             |""".stripMargin
        )
      )
    )
  }
  
  it should "render full DB log eventually" in {
    //given
    val component = <(SQLiteDemo())()()

    //when
    val result = testRender(component)

    //then
    implicit val theme: Theme = DefaultTheme
    eventually {
      assertNativeComponent(result,
        <.View()(
          <.Text(^.rnStyle := themeTextStyle)(
            s"""DB log:
               |
               |DB is opened
               |select: rows: 0
               |tx is completed
               |""".stripMargin
          )
        )
      )
    }
  }
}
