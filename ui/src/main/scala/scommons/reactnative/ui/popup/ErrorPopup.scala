package scommons.reactnative.ui.popup

import scommons.react._
import scommons.react.hooks._
import scommons.reactnative.Alert._
import scommons.reactnative._

case class ErrorPopupProps(error: String,
                           onClose: () => Unit,
                           details: Option[String] = None)

object ErrorPopup extends FunctionComponent[ErrorPopupProps] {

  protected def render(compProps: Props): ReactElement = {
    val (showDetails, setShowDetails) = useState(false)
      
    val props = compProps.wrapped
    val closeBtn = AlertButton("Close", props.onClose, Some(AlertButtonStyle.cancel))
    
    def showAlert(): Unit = {
      Alert.alert(
        title = "Error",
        message =
          if (showDetails) getFullText(props)
          else props.error,
        buttons =
          if (props.details.isDefined && !showDetails) {
            val detailsBtn = AlertButton("Details", onPress = { () =>
              setShowDetails(!showDetails)
            })
            
            List(detailsBtn, closeBtn)
          }
          else List(closeBtn)
      )
    }
    
    useEffect({ () =>
      if (!showDetails) {
        // fix Alert is not showing just after loading modal is closed
        setTimeout({ () =>
          showAlert()
        }, 100)
      }
      else {
        showAlert()
      }
      ()
    }, List(showDetails))
    
    <.>()()
  }

  private def getFullText(props: ErrorPopupProps): String = {
    s"${props.error}\n\n${props.details.getOrElse("")}"
  }
}
