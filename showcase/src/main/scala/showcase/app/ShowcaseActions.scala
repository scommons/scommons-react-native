package showcase.app

import showcase.api.task.DemoTaskApi
import showcase.app.config.ShowcaseConfigActions
import showcase.app.task.DemoTaskActions

object ShowcaseActions
  extends DemoTaskActions
  with ShowcaseConfigActions {

  protected val client: DemoTaskApi = new DemoTaskApi {
  }
}
