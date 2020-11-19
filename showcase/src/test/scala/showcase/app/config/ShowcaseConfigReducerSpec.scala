package showcase.app.config

import scommons.react.test._
import showcase.app.config.ShowcaseConfigActions._

class ShowcaseConfigReducerSpec extends TestSpec {

  it should "return default state when state is None" in {
    //when & then
    ShowcaseConfigReducer(None, "") shouldBe ShowcaseConfig()
  }

  it should "return current state for all other actions" in {
    //given
    val currState = ShowcaseConfig()
    val action = "some other action"

    //when
    val result = ShowcaseConfigReducer(Some(currState), action)

    //then
    result should be theSameInstanceAs currState
  }

  it should "set darkTheme when ShowcaseThemeChangedAction" in {
    //when & then
    ShowcaseConfigReducer(Some(ShowcaseConfig()), ShowcaseThemeChangedAction(true)) shouldBe {
      ShowcaseConfig(
        darkTheme = true
      )
    }
  }
}
