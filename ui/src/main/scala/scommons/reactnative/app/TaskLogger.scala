package scommons.reactnative.app

import scommons.react._
import scommons.react.hooks._

case class TaskLoggerProps(text: String)

object TaskLogger extends FunctionComponent[TaskLoggerProps] {

  private[app] var logger: String => Unit = println
  
  protected def render(compProps: Props): ReactElement = {
    val props = compProps.wrapped

    useEffect({ () =>
      if (props.text.nonEmpty) {
        logger(props.text)
      }
    }, List(props.text))
    
    <.>()()
  }
}
