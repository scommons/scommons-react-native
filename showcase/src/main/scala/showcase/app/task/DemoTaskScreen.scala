package showcase.app.task

import io.github.shogowada.scalajs.reactjs.redux.Redux.Dispatch
import scommons.react._
import scommons.reactnative._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js
import scala.util.Success

case class DemoTaskScreenProps(dispatch: Dispatch,
                               actions: DemoTaskActions)

object DemoTaskScreen extends FunctionComponent[DemoTaskScreenProps] {

  protected def render(compProps: Props): ReactElement = {
    val props = compProps.wrapped

    <.View(^.rnStyle := styles.container)(
      <.Button(^.title := "Successful Request", ^.color := "#00ff00", ^.onPress := { () =>
        val action = props.actions.successfulAction(props.dispatch)
        props.dispatch(action)

        action.task.future.andThen { case Success(resp) =>
          Alert.alert(
            title = "Successful Request",
            message = resp
          )
        }
      })(),
      <.Button(^.title := "Timed-out Request", ^.color := "#0000ff", ^.onPress := { () =>
        props.dispatch(props.actions.timedoutAction())
      })(),
      <.Button(^.title := "Failed Request", ^.color := "#ff0000", ^.onPress := { () =>
        props.dispatch(props.actions.failedAction())
      })()
    )
  }

  private[task] lazy val styles = StyleSheet.create(new Styles)
  private[task] class Styles extends js.Object {

    val container: Style = new ViewStyle {
      override val marginTop = 22
      override val flex = 1
    }
  }
}
