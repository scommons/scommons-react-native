package showcase.app

import showcase.api.task.DemoTaskApi
import showcase.app.task.DemoTaskActions

object ShowcaseActions
  extends DemoTaskActions {

  protected val client: DemoTaskApi = new DemoTaskApi {
  }
}
