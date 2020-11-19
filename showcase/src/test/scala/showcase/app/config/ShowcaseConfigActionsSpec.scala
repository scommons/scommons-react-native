package showcase.app.config

import scommons.react.test._
import showcase.app.config.ShowcaseConfigActions._

class ShowcaseConfigActionsSpec extends TestSpec {
  
  private lazy val actions = new ShowcaseConfigActions {}

  it should "dispatch ShowcaseThemeChangedAction when updateTheme" in {
    //given
    val dispatch = mockFunction[Any, Any]
    
    //then
    dispatch.expects(ShowcaseThemeChangedAction(true))
    
    //when
    actions.updateTheme(dispatch, darkTheme = true)
  }
}
