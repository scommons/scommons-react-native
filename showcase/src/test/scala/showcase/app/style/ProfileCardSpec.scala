package showcase.app.style

import scommons.react.test._
import scommons.reactnative._
import showcase.app.ShowcaseImages
import showcase.app.style.ProfileCard._

import scala.scalajs.js

class ProfileCardSpec extends TestSpec with TestRendererUtils {

  it should "render component" in {
    //given
    val component = <(ProfileCard())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.View(^.rnStyle := styles.container)(
        <.View(^.rnStyle := js.Array(styles.cardContainer, styles.cardContainerShadow))(
          <.View(^.rnStyle := js.Array(styles.cardImageContainer, styles.cardImageContainerShadow))(
            <.Image(^.rnStyle := styles.cardImage, ^.source := ShowcaseImages.User.Resource)()
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
    )
  }
}
