package showcase.app

import scommons.reactnative.StaticResource

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object ShowcaseFonts {

  object MontserratBlack {

    val name = "Montserrat-Black"
    
    @js.native
    @JSImport("./showcase/app/Montserrat-Black.ttf", JSImport.Namespace)
    object Resource extends StaticResource
  }

  def fontsToPreload: Seq[(String, StaticResource)] = Seq(
    MontserratBlack.name -> MontserratBlack.Resource
  )
}
