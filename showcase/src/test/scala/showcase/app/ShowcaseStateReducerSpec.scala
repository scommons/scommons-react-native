package showcase.app

import scommons.react.redux.task.FutureTask
import scommons.react.test.TestSpec
import showcase.app.config.ShowcaseConfig
import showcase.app.task.DemoTaskActions.SuccessfulFetchAction

import scala.concurrent.Future

class ShowcaseStateReducerSpec extends TestSpec {

  it should "return initial state" in {
    //when
    val result = ShowcaseStateReducer.reduce(None, "")

    //then
    inside(result) {
      case ShowcaseState(currentTask, config) =>
        currentTask shouldBe None
        config shouldBe ShowcaseConfig()
    }
  }

  it should "set currentTask when TaskAction" in {
    //given
    val initialState = ShowcaseStateReducer.reduce(None, "")
    val task = FutureTask("test task", Future.successful("test resp"))
    initialState.currentTask shouldBe None

    //when
    val result = ShowcaseStateReducer.reduce(Some(initialState), SuccessfulFetchAction(task))

    //then
    result.currentTask shouldBe Some(task)
  }
}
