package showcase.app

import scommons.react._
import scommons.react.navigation._

trait BaseRouteController[R, P] extends UiComponent[Unit] { self =>

  protected def create(): ReactClass = new FunctionComponent[Unit] {
    
    override protected def displayName: String = self.displayName
    
    protected def render(props: Props): ReactElement = {
      <(uiComponent())(
        ^.wrapped := mapRouteToProps(Navigation(props))
      )()
    }
  }.apply()

  def uiComponent: UiComponent[P]

  def mapRouteToProps(nav: Navigation): P
}
