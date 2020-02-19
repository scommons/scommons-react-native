package showcase.app.style

import scommons.react._
import scommons.reactnative._

import scala.scalajs.js

object ProfileCard extends FunctionComponent[Unit] {

  protected def render(props: Props): ReactElement = {
    <.View(^.rnStyle := styles.container)(
      <.View(^.rnStyle := js.Array(styles.cardContainer, styles.cardContainerShadow))(
        <.View(^.rnStyle := js.Array(styles.cardImageContainer, styles.cardImageContainerShadow))(
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

  import Style._

  private val profileCardColor = Color.dodgerblue

  private[style] lazy val styles = StyleSheet.create(new Styles)
  private[style] class Styles extends js.Object {
    import TextStyle._
    import ViewStyle._
    
    val container: Style = new ViewStyle {
      override val flex = 1
      override val justifyContent = JustifyContent.center
      override val alignItems = AlignItems.center
    }
    val cardContainer: Style = new ViewStyle {
      override val alignItems = AlignItems.center
      override val borderColor = Color.black
      override val borderWidth = 3
      override val borderStyle = BorderStyle.solid
      override val borderRadius = 20
      override val backgroundColor = profileCardColor
      override val width = 300
      override val height = 400
    }
    val cardContainerShadow: Style = Platform.select {
      case Platform.ios | Platform.web => new ViewStyle {
        override val shadowColor = Color.black
        override val shadowOffset = new ShadowOffset {
          override val height = 10
        }
        override val shadowOpacity = 1
      }
      case Platform.android => new ViewStyle {
        override val elevation = 15
      }
    }
    val cardImageContainer: Style = new ViewStyle {
      override val alignItems = AlignItems.center
      override val backgroundColor = Color.white
      override val borderWidth = 3
      override val borderColor = Color.black
      override val width = 120
      override val height = 120
      override val borderRadius = 60
      override val marginTop = 30
      override val paddingTop = 15
    }
    val cardImageContainerShadow: Style = Platform.select {
      case Platform.ios | Platform.web => new ViewStyle {
        override val shadowColor = Color.black
        override val shadowOffset = new ShadowOffset {
          override val height = 10
        }
        override val shadowOpacity = 1
      }
      case Platform.android => new ViewStyle {
        override val borderWidth = 3
        override val borderColor = Color.black
        override val elevation = 15
      }
    }
    val cardImage: Style = new Style {
      override val width = 80
      override val height = 80
    }
    val cardName: Style = new TextStyle {
      override val color = Color.white
      override val fontWeight = FontWeight.bold
      override val fontSize = 24
      override val marginTop = 30
      override val textShadowColor = Color.black
      override val textShadowOffset = new ShadowOffset {
        override val height = 2
        override val width = 2
      }
      override val textShadowRadius = 3
    }
    val cardOccupationContainer: Style = new ViewStyle {
      override val borderColor = Color.black
      override val borderBottomWidth = 3
    }
    val cardOccupation: Style = new TextStyle {
      override val fontWeight = FontWeight.bold
      override val marginTop = 10
      override val marginBottom = 10
    }
    val cardDescription: Style = new TextStyle {
      override val fontStyle = FontStyle.italic
      override val marginTop = 10
      override val marginRight = 40
      override val marginLeft = 40
      override val marginBottom = 10
    }
  }
}
