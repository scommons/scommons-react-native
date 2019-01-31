package scommons.reactnative.showcase.style

import io.github.shogowada.scalajs.reactjs.React
import io.github.shogowada.scalajs.reactjs.classes.ReactClass
import scommons.react.UiComponent
import scommons.reactnative._

import scala.scalajs.js

object ProfileCard extends UiComponent[Unit] {

  protected def create(): ReactClass = React.createClass[PropsType, Unit] { _ =>
    <.View(^.rnStyle := styles.container)(
      <.View(^.rnStyle := styles.cardContainer)(
        <.View(^.rnStyle := styles.cardImageContainer)(
          <.Image(^.rnStyle := styles.cardImage, ^.source := StyleImages.User)()
        )
      )
    )
  }

  private val profileCardColor = "dodgerblue"

  private[style] lazy val styles = StyleSheet.create(Styles)
  
  private[style] object Styles extends js.Object {
    val container: Style = new Style {
      override val flex = 1
      override val justifyContent = "center"
      override val alignItems = "center"
    }
    val cardContainer: Style = new Style {
      override val borderColor = "black"
      override val borderWidth = 3
      override val borderStyle = "solid"
      override val borderRadius = 20
      override val backgroundColor = profileCardColor
      override val width = 300
      override val height = 400
    }
    val cardImageContainer: Style = new Style {
      override val backgroundColor = "white"
      override val borderWidth = 3
      override val borderColor = "black"
      override val width = 120
      override val height = 120
      override val borderRadius = 60
    }
    val cardImage: Style = new Style {
      override val width = 80
      override val height = 80
    }
  }
}
