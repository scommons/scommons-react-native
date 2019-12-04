package scommons.reactnative.showcase.style

import scommons.react._
import scommons.reactnative._

import scala.scalajs.js

object ProfileCard extends FunctionComponent[Unit] {

  protected def render(props: Props): ReactElement = {
    <.View(^.rnStyle := styles.container)(
      <.View(^.rnStyle := styles.cardContainer)(
        <.View(^.rnStyle := styles.cardImageContainer)(
          <.Image(^.rnStyle := styles.cardImage, ^.source := StyleImages.User)()
        ),
        <.View()(
          <.Text(^.rnStyle := styles.cardName)(
            "John Doe"
          )
        ),
        <.View(^.rnStyle := styles.cardOccupationContainer)(
          <.Text(^.rnStyle := styles.cardOccupation)(
            "React Native Developer"
          )
        ),
        <.View()(
          <.Text(^.rnStyle := styles.cardDescription)(
            "John is a really great JavaScript developer. He" +
              " loves using JS to build React Native applications" +
              " for iOS and Android."
          )
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
      override val alignItems = "center"
      override val borderColor = "black"
      override val borderWidth = 3
      override val borderStyle = "solid"
      override val borderRadius = 20
      override val backgroundColor = profileCardColor
      override val width = 300
      override val height = 400
    }
    val cardImageContainer: Style = new Style {
      override val alignItems = "center"
      override val backgroundColor = "white"
      override val borderWidth = 3
      override val borderColor = "black"
      override val width = 120
      override val height = 120
      override val borderRadius = 60
      override val marginTop = 30
      override val paddingTop = 15
    }
    val cardImage: Style = new Style {
      override val width = 80
      override val height = 80
    }
    val cardName: Style = new Style {
      override val color = "white"
      override val marginTop = 30
    }
    val cardOccupationContainer: Style = new Style {
      override val borderColor = "black"
      override val borderBottomWidth = 3
    }
    val cardOccupation: Style = new Style {
      override val marginTop = 10
      override val marginBottom = 10
    }
    val cardDescription: Style = new Style {
      override val marginTop = 10
      override val marginRight = 40
      override val marginLeft = 40
      override val marginBottom = 10
    }
  }
}
