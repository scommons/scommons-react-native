package showcase.app

import scommons.expo.Asset
import scommons.reactnative.StaticResource

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/** @see https://reactnative.dev/docs/images.html#static-image-resources
  */
object ShowcaseImages {

  object User {
    val asset: Asset = Asset.fromModule(Resource)

    @js.native
    @JSImport("./showcase/app/user.png", JSImport.Namespace)
    object Resource extends StaticResource
  }

  object Expo {
    val asset: Asset = Asset.fromModule(Resource)

    @js.native
    @JSImport("./showcase/app/expo.png", JSImport.Namespace)
    object Resource extends StaticResource
  }
  
  def imagesToPreload: Seq[StaticResource] = Seq(
    User.Resource,
    Expo.Resource
  )
}
