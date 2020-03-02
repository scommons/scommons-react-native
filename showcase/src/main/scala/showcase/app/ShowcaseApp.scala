package showcase.app

import io.github.shogowada.scalajs.reactjs.redux.ReactRedux._
import io.github.shogowada.scalajs.reactjs.redux.Redux
import scommons.react._

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel(name = "ShowcaseApp")
object ShowcaseApp extends FunctionComponent[Unit] {

  @JSExport("apply")
  override def apply(): ReactClass = super.apply()

  private val store = Redux.createStore(ShowcaseStateReducer.reduce)
  
  protected def render(props: Props): ReactElement = {
    <.Provider(^.store := store)(
      <.>()(
        <(ShowcaseRoot()).empty,
        <(ShowcaseTaskController()).empty
      )
    )
  }
}
