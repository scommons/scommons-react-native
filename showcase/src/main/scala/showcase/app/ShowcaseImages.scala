package showcase.app

import scommons.reactnative.StaticResource

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/** @see https://reactnative.dev/docs/images.html#static-image-resources
  */
object ShowcaseImages {

  @js.native
  @JSImport("./showcase/app/user.png", JSImport.Namespace)
  object User extends StaticResource
  
  @js.native
  @JSImport("./showcase/app/expo.png", JSImport.Namespace)
  object Expo extends StaticResource
}
